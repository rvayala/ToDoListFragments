package com.rvag.todolistfragments.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rvag.todolistfragments.R;
import com.rvag.todolistfragments.model.Task;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Robert on 16/07/2016.
 */
public class RecyclerViewTaskAdapter extends RecyclerView.Adapter<RecyclerViewTaskAdapter.TaskViewHolder> {

    private int resource;
    private Context context;
    private ArrayList<Task> tasks;

    public RecyclerViewTaskAdapter(Context context, ArrayList<Task> tasks, int resource) {
        this.tasks = tasks;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.tvTaskCV.setText(task.getName());
        holder.tvDescriptionTaskCV.setText(task.getDescripcion());

        Picasso.with(context).load(task.getImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgTaskCV);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgTaskCV;
        private TextView tvTaskCV;
        private TextView tvDescriptionTaskCV;

        public TaskViewHolder(View itemView) {
            super(itemView);

            imgTaskCV = (ImageView) itemView.findViewById(R.id.imgImageCV);
            tvTaskCV = (TextView) itemView.findViewById(R.id.twNameTaskCV);
            tvDescriptionTaskCV = (TextView) itemView.findViewById(R.id.twDescripcionTaskCV);
        }
    }
}
