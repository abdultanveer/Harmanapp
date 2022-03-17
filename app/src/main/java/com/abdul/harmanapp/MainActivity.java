package com.abdul.harmanapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9880979732"));
        startActivity(dialIntent);
    }

    private void launchHomeActivity() {
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
}