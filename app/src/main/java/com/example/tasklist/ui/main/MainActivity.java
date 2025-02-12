package com.example.tasklist.ui.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasklist.R;
import com.example.tasklist.data.model.Task;
import com.example.tasklist.repository.TaskRepository;
import com.example.tasklist.ui.task.TaskAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> taskList;
    private TaskRepository taskRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initData();
    }

    private void initData() {
        this.taskRepository = new TaskRepository(this);
        this.taskList = taskRepository.getAllTasks();
    }

    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TaskAdapter taskAdapter = new TaskAdapter(taskList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(taskAdapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(v -> addTask());
    }

    private void addTask() {
        Intent intent = new Intent(this, EditTaskActivity.class);
        startActivity(intent);
    }

}