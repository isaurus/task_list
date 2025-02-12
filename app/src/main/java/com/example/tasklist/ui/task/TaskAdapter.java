package com.example.tasklist.ui.task;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasklist.R;
import com.example.tasklist.data.model.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList){
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
        Task currentTask = taskList.get(position);

        holder.txtTaskTitle.setText(currentTask.getTitle());
        holder.txtTaskDate.setText(currentTask.getDate());
        holder.chkTaskIsCompleted.setChecked(currentTask.isCompleted());

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView txtTaskTitle;
        TextView txtTaskDate;
        CheckBox chkTaskIsCompleted;

        public TaskViewHolder(@NonNull View itemView) {

            super(itemView);

            txtTaskTitle = itemView.findViewById(R.id.txtTaskTitle);
            txtTaskDate = itemView.findViewById(R.id.txtTaskDate);
            chkTaskIsCompleted = itemView.findViewById(R.id.chkTaskIsCompleted);
        }
    }
}
