package com.abdul.harmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DbActivity extends AppCompatActivity {
EditText etTitle, etSubtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        etTitle = findViewById(R.id.etTitle);
        etSubtitle = findViewById(R.id.etSubtitle);
    }

    public void dbHandler(View view) {
        switch (view.getId()){
            case R.id.btnCommit:
                saveData();
                break;
            case R.id.btnGet:
                retreiveData();
                break;
        }
    }

    private void retreiveData() {
        //query the db
        //set the result in textview
    }

    private void saveData() {
        //get the data from edittexts
        String title = etTitle.getText().toString();
        String subtitle = etSubtitle.getText().toString();
        //put the data into db
    }
}