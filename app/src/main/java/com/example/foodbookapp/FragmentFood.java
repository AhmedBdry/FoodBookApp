package com.example.foodbookapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


public class FragmentFood extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_fragment_food, container, false);
        ArrayList<Food>foods = new ArrayList<>();
        foods.add(new Food(R.drawable.burger,"Cheese Burger","3.5$"));
        foods.add(new Food(R.drawable.shawerma,"Chicken Shawerma","4.5$"));
        foods.add(new Food(R.drawable.pancakes,"Pancakes","3.99$"));
        foods.add(new Food(R.drawable.pizza,"Pepperoni Pizza","3.99$"));
        foods.add(new Food(R.drawable.filletsteak,"Fillet Steak","10.5$"));
        foods.add(new Food(R.drawable.waffles,"Chocolate Waffles","2.5$"));

        GridView gridView =view.findViewById(R.id.listfood);
        final FoodAdapter adapter = new FoodAdapter(getActivity(),foods);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),FoodCard.class);
                intent.putExtra("foodobject", (Parcelable) adapter.getItem(position));
                startActivity(intent);
            }
        });

        return view;

    }

}
