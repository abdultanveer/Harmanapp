package com.abdul.harmanapp.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.abdul.harmanapp.database.FeedReaderContract.FeedEntry;

import androidx.annotation.Nullable;

/**
 * this class helps in creating a db, updating it etc
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_SHEET =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    public DbHelper(@Nullable Context context) {
        super(context, "harmandb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase workbook) {
        workbook.execSQL(SQL_CREATE_SHEET);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
