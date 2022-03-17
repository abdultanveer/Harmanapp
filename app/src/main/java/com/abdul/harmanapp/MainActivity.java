package com.abdul.harmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName); //initialization or taking handle on etName
    }

    public void clickHandler(View view) {
        String input = etName.getText().toString();
       // Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this,com.abdul.harmanapp.HomeActivity.class);
        hIntent.putExtra("ip",input);
        startActivity(hIntent);
    }
}