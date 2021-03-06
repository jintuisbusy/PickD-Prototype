package com.jintu.pickd.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jintu.pickd.Model.Category;
import com.jintu.pickd.R;

import java.util.List;

/**
 * Created by Jack on 4/1/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context mContext;
    private List<Category> CategoryList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            // count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public CategoryAdapter(Context mContext, List<Category> CategoryList) {
        this.mContext = mContext;
        this.CategoryList = CategoryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Category Category = CategoryList.get(position);
        holder.title.setText(Category.getName());
        // holder.count.setText(Category.getNumOfSongs() + " songs");

        // loading Category cover using Glide library
        Glide
                .with(mContext)
                .load(Category.getThumbnail())
                .into(holder.thumbnail);
    }



    @Override
    public int getItemCount() {
        return CategoryList.size();
    }
}