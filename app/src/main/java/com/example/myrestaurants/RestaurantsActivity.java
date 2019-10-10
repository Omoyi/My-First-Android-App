package com.example.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] restaurants = new String[] {
            "Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"
    };
    public static final String TAG = RestaurantsActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
                Log.v(TAG, "In the onItemClickListener!");
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("Rachel");
        mLocationTextView.setText("Here are all the restaurants near: " + location);


    }

}

//Adapter: Essentially a bridge between the components of your user interface, and the data that your user interface should display.
//
//ArrayAdapter`: Responsible for taking an ArrayList of objects from our business logic and converting them into View objects to be displayed in our User Interface.
//
//Recycling: The act of an adapter re-using the individual Views of a ListView as the user scrolls through a list. After the ListView has created enough individual list items to fit the full height of the screen, it simply re-uses existing list items to display the new list items instead of creating more.
//
//ScrapViews: During the process of recycling, a View that leaves the screen, but is kept in memory to be re-used.