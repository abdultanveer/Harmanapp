package com.abdul.harmanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.abdul.harmanapp.database.NotesAdapter;
import com.abdul.harmanapp.database.NotesDao;

public class DbActivity extends AppCompatActivity {
EditText etTitle, etSubtitle;
NotesDao notesDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        etTitle = findViewById(R.id.etTitle);
        etSubtitle = findViewById(R.id.etSubtitle);
        notesDao = new NotesDao(this);
        notesDao.openDb();
        NotesAdapter adapter = new NotesAdapter(notesDao);
        RecyclerView mreRecyclerView = findViewById(R.id.recyclerView2);
        mreRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mreRecyclerView.setAdapter(adapter);
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
       String row = notesDao.readRow();
        //set the result in textview
        TextView tvOutput = findViewById(R.id.tvOutput);
        tvOutput.setText(row);
    }

    private void saveData() {
        //get the data from edittexts
        String title = etTitle.getText().toString();
        String subtitle = etSubtitle.getText().toString();
        //put the data into db
        notesDao.createRow(title,subtitle);
        etTitle.setText("");
        etSubtitle.setText("");
    }
}