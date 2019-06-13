package com.example.foodbookapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBook extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view =  inflater.inflate(R.layout.fragment_fragment_book, container, false);

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("One Hundred Years of Solitude ", "by Gabriel García Márquez", R.drawable.solitude, 3.5f, "1992"));
        books.add(new Book("Terra Nostra ", "Carlos Fuentes", R.drawable.nostra, 3, "1980"));
        books.add(new Book("Angels & Demons ", "by Dan Brown", R.drawable.angels, 4, "1990"));
        books.add(new Book("The Sword Thief  ", " by Peter Lerangis", R.drawable.sword, 2, "1993"));
        books.add(new Book("Inferno", "by Dan Brown", R.drawable.inferno, 4.5f, "1985"));
        books.add(new Book("Bloodline ", "by James Rollins", R.drawable.blood, 2, "1960"));
        books.add(new Book("The House of the Spirits ", "by Isabel Allende", R.drawable.spirits, 3, "1983"));
        books.add(new Book("The Hummingbird's Daughter ", "by Luis Alberto Urrea ", R.drawable.humming, 3.5f, "1996"));

        ListView listView =(ListView) view.findViewById(R.id.listviewbook);
        final BookAdapter adapter = new BookAdapter(getActivity(),books);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getActivity(),BookCard.class);
             intent.putExtra("bookobject",adapter.getItem(position));
            startActivity(intent);
          }
        });

        return view ;

    }

}
