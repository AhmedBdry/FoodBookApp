package com.example.foodbookapp;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends ArrayAdapter {
    ArrayList<Food> foods ;
    public FoodAdapter(Context context, ArrayList<Food> foods) {
        super(context, 0, foods);
        this.foods=foods;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_food,parent,false);
        TextView textView = convertView.findViewById(R.id.txt1);
        TextView textView1 = convertView.findViewById(R.id.txt2);
        ImageView imageView = convertView.findViewById(R.id.imgids);
        ImageView clear = convertView.findViewById(R.id.clearid);
        Food food = (Food) getItem(position);
        textView.setText(food.getTitle());
        textView1.setText(food.getPrice());
        imageView.setImageResource(food.getImageResId());
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Warning")
                        .setMessage("are you sure to remove this file ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                foods.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return convertView;
    }
}
