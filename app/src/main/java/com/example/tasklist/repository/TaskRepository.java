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

    private Task getTaskById(int id){
        return taskDAO.getTaskById(id);
    }

    private List<Task> getAllTasks(){
        return taskDAO.getAllTasks();
    }

    private void updateTask(Task task){
        taskDAO.updateTask(task);
    }

    private void deleteTask(int id){
        taskDAO.deleteTask(id);
    }

}
