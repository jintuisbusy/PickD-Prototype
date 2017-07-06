package com.jintu.pickd.Activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.jintu.pickd.R;

import java.util.ArrayList;

public class ManActivity extends Activity {

    Adapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man);

        final ListView listview = (ListView) findViewById(R.id.mList);
        final ArrayList<Drawable> list = new ArrayList<>();

        list.add(getResources().getDrawable(R.drawable.m1));
        list.add(getResources().getDrawable(R.drawable.m2));
        list.add(getResources().getDrawable(R.drawable.m3));
        list.add(getResources().getDrawable(R.drawable.m4));
        list.add(getResources().getDrawable(R.drawable.m5));
        list.add(getResources().getDrawable(R.drawable.m6));
        list.add(getResources().getDrawable(R.drawable.m7));
        adapter = new Adapter(this,0,list);
        listview.setAdapter(adapter);
    }
}
class Adapter extends ArrayAdapter<Drawable>{
    ArrayList<Drawable> items ;
    ImageView image ;

    public Adapter(Context c, int resources, ArrayList<Drawable>list){
        super(c,resources,list);
        this.items = list ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.men_items, parent, false);
        }
        image= (ImageView) convertView.findViewById(R.id.mImg);
        image.setBackground(items.get(position));
        return convertView;
    }
}