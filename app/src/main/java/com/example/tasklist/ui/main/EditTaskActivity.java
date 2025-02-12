package com.example.tasklist.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tasklist.R;
import com.example.tasklist.data.model.Task;
import com.example.tasklist.repository.TaskRepository;

import java.util.List;

public class EditTaskActivity extends AppCompatActivity {

    private EditText edtTaskTitle;
    private EditText edtTaskDate;
    private EditText edtTaskDescription;

    private TaskRepository taskRepository;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        initViews();
        initData();
    }

    private void initData() {
        taskRepository = new TaskRepository(this);
        taskList = taskRepository.getAllTasks();
    }

    private void initViews() {
        edtTaskTitle = findViewById(R.id.edtTaskTitle);
        edtTaskDate = findViewById(R.id.edtTaskDate);
        edtTaskDescription = findViewById(R.id.edtTaskDescription);

        setSupportActionBar(findViewById(R.id.editToolBar));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_task_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.itemDone){
            Task task = new Task(
                    getTaskId(),
                    edtTaskTitle.getText().toString(),
                    edtTaskDate.getText().toString(),
                    edtTaskDescription.getText().toString(),
                    false);
            taskRepository.updateTask(task);
        }
        return super.onOptionsItemSelected(item);
    }
}