package com.abdul.harmanapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName,etPin; //declaration
    public static String TAG = MainActivity.class.getSimpleName();

    @Override //memory is being allocated for the actvity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"oncreate");

        etName = findViewById(R.id.etName); //initialization or taking handle on etName
        etPin = findViewById(R.id.etPin); //initialization or taking handle on etName

        Button dialButton = findViewById(R.id.btnDial);

        registerForContextMenu(dialButton);
    }

    /**
     * when the actvity is visible to the user
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");

    }

    /**
     * when activity goes in the background
     * filling some form -- save its state
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
        saveAppState();

    }

    private void saveAppState() {
        //get the date from 2 edittexts
        String name = etName.getText().toString();
        String pin = etPin.getText().toString();
        //create a file
        SharedPreferences preferences = getSharedPreferences("Harmanfile",MODE_PRIVATE);
        //open file in edit mode
        SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        editor.putString("cname",name);
        editor.putString("cpin",pin);
        //save the file
        editor.apply();
    }


    /**
     * restore the state of the app
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
        restoreAppState();
    }

    private void restoreAppState() {
        //read from the file
        //put the data back into the edittexts
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");

    }

    public void clickHandler(View view) {
        Log.w(TAG,"clickHandler");

        switch (view.getId()){
            case R.id.btnLogin:
                launchHomeActivity();
                break;
            case R.id.btnDial:
                launchDialer();
                break;
        }


    }

    private void launchDialer() {
        Log.e(TAG,"launchDialer");

        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9880979732"));
        int c  = add(10,20);
        int k = 5+6;
        int s = c *k ;
        startActivity(dialIntent);
    }


    private  int add(int a, int b){
        Log.e(TAG,"add");

        int j = 20;
        return a+b;
    }


    private void launchHomeActivity() {
        Log.d(TAG,"launchDialer");

        String input = etName.getText().toString();
        // Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
        hIntent.putExtra("ip",input);
        // startActivity(hIntent);
        ActivityCompat.startActivityForResult(this,hIntent,123,null);//1
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//3
        super.onActivityResult(requestCode, resultCode, data);
        TextView resultTv = findViewById(R.id.tvResult);
        if(resultCode == RESULT_OK && requestCode == 123){
            String contact = data.getExtras().getString("con");
            resultTv.setText(contact);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        //inflate -- a baloon[xml] -- parsing the xml and creating its corresponding memory variables
        menuInflater.inflate(R.menu.main_menu,menu); //after inflating attach the baloon to menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         switch (item.getItemId()){
           case  R.id.harmanid:
               Toast.makeText(this, "harman sselected", Toast.LENGTH_SHORT).show();
             break;
           case  R.id.andid:
               Toast.makeText(this, "android sselected", Toast.LENGTH_SHORT).show();

               break;
         }
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }
}