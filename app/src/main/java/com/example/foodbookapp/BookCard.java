package com.example.foodbookapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class BookCard extends AppCompatActivity {

    TextView title,author,date;
    RatingBar ratingBar;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_card);
        title=findViewById(R.id.titleas);
        author=findViewById(R.id.authoras);
        date=findViewById(R.id.dateas);
        ratingBar=findViewById(R.id.ratingas);
        img=findViewById(R.id.imgas);

        Book book=getIntent().getParcelableExtra("bookobject");
        date.setText(book.getDate());
        ratingBar.setRating(book.getRatingBar());
        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        img.setImageResource(book.getImageId());


    }


}