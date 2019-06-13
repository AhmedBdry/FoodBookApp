package com.example.foodbookapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    ArrayList<Book>books;
    AlertDialog dialog ;

    public BookAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
        this.books=books;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_book,parent,false);
        ImageView imageView = convertView.findViewById(R.id.img);
        TextView textView1 = convertView.findViewById(R.id.txt1);
        TextView textView2 = convertView.findViewById(R.id.txt2);
        TextView textView3 = convertView.findViewById(R.id.txt3);
        RatingBar ratingBar = convertView.findViewById(R.id.rating);
        Book book = getItem(position);
        imageView.setImageResource(book.getImageId());
        textView1.setText(book.getTitle());
        textView2.setText(book.getAuthor());
        textView3.setText(book.getDate());
        ratingBar.setRating(book.getRatingBar());
        ImageView clear = convertView.findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("Warning!")
                        .setMessage("Are you sure you want to delete this book?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                books.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog.dismiss();
                            }
                        });
                dialog=builder.create();
                dialog.show();
            }
        });



        return convertView;
    }
}
