package com.example.tasklist.repository;

import android.content.Context;

import com.example.tasklist.data.database.TaskDAO;
import com.example.tasklist.data.model.Task;

import java.util.List;

public class TaskRepository {

    private TaskDAO taskDAO;

    public TaskRepository(Context ctx){
        this.taskDAO = new TaskDAO(ctx);
    }

    public Task getTaskById(int id){
        return taskDAO.getTaskById(id);
    }

    public List<Task> getAllTasks(){
        return taskDAO.getAllTasks();
    }

    public void updateTask(Task task){
        taskDAO.updateTask(task);
    }

    public void deleteTask(int id){
        taskDAO.deleteTask(id);
    }

}
