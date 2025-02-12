package com.example.tasklist.data.database;

import static com.example.tasklist.utils.Constants.CREATE_TABLE_TASKS;
import static com.example.tasklist.utils.Constants.DATABASE_NAME;
import static com.example.tasklist.utils.Constants.DATABASE_VERSION;
import static com.example.tasklist.utils.Constants.DELETE_TABLE_TASKS;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TaskDatabaseHelper extends SQLiteOpenHelper {

    public TaskDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_TASKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_TABLE_TASKS);
        onCreate(sqLiteDatabase);
    }
}
