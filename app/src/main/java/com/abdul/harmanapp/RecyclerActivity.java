package com.abdul.harmanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


//project = database
//file -- table in db
//line of the file = row in the db
//commit[only the row that was changed is added along with the time stamp and the position]
// vs save[whole file is added]
public class RecyclerActivity extends AppCompatActivity {
    String[] countries = new String[]{"india","china","russia","ukraine"};//3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);//2
        CountriesAdapter adapter = new CountriesAdapter(countries);//7
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }
}