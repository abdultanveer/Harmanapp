package com.abdul.harmanapp.webservices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.abdul.harmanapp.R;

public class WhowroteitActivity extends AppCompatActivity {
    EditText mBookInput;
    TextView mTitleText, mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whowroteit);
        mBookInput = findViewById(R.id.bookInput);

    }

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
        new FetchBookTask(mTitleText, mAuthorText).execute(queryString);
    }
}