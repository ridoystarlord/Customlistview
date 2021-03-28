package com.ridoy.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class customadapter extends ArrayAdapter {

    ArrayList<listitem> items;

    public customadapter(@NonNull Context context, int layout, ArrayList<listitem> items) {
        super(context, layout);
        this.items=items;
    }
    public void update(ArrayList<listitem> results){
        items=new ArrayList<>();
        items.addAll(results);
        notifyDataSetChanged();

    }
    public class ViewHolder{
        TextView textview;
        ImageView imageView;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row=convertView;
        ViewHolder viewHolder;
        if (row==null){
            row= LayoutInflater.from(getContext()).inflate(R.layout.listitemlayout,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.imageView=row.findViewById(R.id.imageviewid);
            viewHolder.textview=row.findViewById(R.id.textviewid);
            row.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) row.getTag();

        }
        viewHolder.imageView.setImageResource(items.get(position).image);
        viewHolder.textview.setText(items.get(position).university_name);

        return row;
    }
}
