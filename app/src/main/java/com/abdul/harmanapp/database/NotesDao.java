package com.abdul.harmanapp.database;

import android.content.Context;

/**
 * this class will help me create,read,update and delete a row
 * in the db
 */
public class NotesDao {
    DbHelper dbHelper;

    public NotesDao(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void createRow(String title, String subtitle){}
    public void readRow(){}
    public void updateRow(){}
    public void deleteRow(){}

}
