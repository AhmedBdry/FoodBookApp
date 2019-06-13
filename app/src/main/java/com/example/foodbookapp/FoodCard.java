package com.example.foodbookapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_card);

        Food food = getIntent().getParcelableExtra("foodobject");

        ImageView imageView = findViewById(R.id.imgcart);
        TextView textView = findViewById(R.id.txt1cart);
        TextView textView1 = findViewById(R.id.txt2cart);

        imageView.setImageResource(food.getImageResId());
        textView.setText(food.getTitle());
        textView1.setText(food.getPrice());
    }
}
