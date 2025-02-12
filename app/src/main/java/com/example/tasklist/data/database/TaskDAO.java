package com.example.tasklist.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tasklist.data.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    private TaskDatabaseHelper databaseHelper;

    public TaskDAO(Context ctx){
        databaseHelper = new TaskDatabaseHelper(ctx);
    }

    public Task getTaskById(int id){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(
                "tasks",
                null,
                "id = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if(cursor.moveToFirst()){
            Task task = new Task(
                    cursor.getInt(0),       // id
                    cursor.getString(1),    // title
                    cursor.getString(2),    // description
                    cursor.getString(3),    // date
                    cursor.getInt(4) == 1   // isCompleted
            );
            cursor.close();
            sqLiteDatabase.close();
            return task;
        }
        return null;
    }

    public List<Task> getAllTasks(){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        List<Task> taskList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(
                "tasks",
                null,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToFirst()){
            Task task = new Task(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4) == 1
            );
            taskList.add(task);
        }
        cursor.close();
        sqLiteDatabase.close();
        return taskList;
    }

    public void updateTask(Task task){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", task.getTitle());
        values.put("description", task.getDescription());
        values.put("date", task.getDate());
        values.put("isCompleted", task.isCompleted() ? 1 : 0);
        sqLiteDatabase.update("task", values, "id = ?", new String[]{String.valueOf(task.getId())});
        sqLiteDatabase.close();
    }

    public void deleteTask(int id){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        sqLiteDatabase.delete("task", "id = ?", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
}
