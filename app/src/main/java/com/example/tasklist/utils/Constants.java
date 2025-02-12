package com.example.tasklist.utils;

public class Constants {

    public static final String DATABASE_NAME = "tasks.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_TASKS_NAME = "tasks";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_COMPLETED = "completed";

    public static final String CREATE_TABLE_TASKS =
            "CREATE TABLE " + TABLE_TASKS_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_TITLE + " TEXT," +
                    COLUMN_DESCRIPTION + " TEXT," +
                    COLUMN_DATE + " TEXT," +
                    COLUMN_COMPLETED + " INTEGER)";

    public static final String DELETE_TABLE_TASKS =
            "DROP TABLE IF EXISTS " + TABLE_TASKS_NAME;
}