package com.abdul.harmanapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.abdul.harmanapp.database.FeedReaderContract.FeedEntry;

/**
 * this class will help me create,read,update and delete a row
 * in the db
 */
public class NotesDao {
    DbHelper dbHelper;
    SQLiteDatabase database; //declaration

    public NotesDao(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void openDb(){
        database = dbHelper.getWritableDatabase();//instantiation
    }

    public void createRow(String title, String subtitle){
        //insert title and subtitle in db
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,subtitle);
        database.insert(FeedEntry.TABLE_NAME,null,values);
    }
    public String readRow(){
        Cursor cursor = database.query(FeedEntry.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToLast();
        int titleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE); //1
        int subTitleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE);//2
        String title =  cursor.getString(titleIndex);
        String subtitle = cursor.getString(subTitleIndex);
        return title + "\n"+ subtitle;
    }
    public void updateRow(){}
    public void deleteRow(){}

}
