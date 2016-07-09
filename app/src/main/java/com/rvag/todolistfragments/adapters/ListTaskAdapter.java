package com.rvag.todolistfragments.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rvag.todolistfragments.R;
import com.rvag.todolistfragments.model.Task;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Robert on 09/07/2016.
 */
public class ListTaskAdapter extends ArrayAdapter<Task> {
    Context context;
    int resource;
    ArrayList<Task> tasks;

    public ListTaskAdapter(Context context, int resource, ArrayList<Task> tasks) {
        super(context, resource, tasks);
        this.context = context;
        this.resource = resource;
        this.tasks = tasks;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        Activity activity = (Activity) context;
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(resource, null);

        ImageView imgImage = (ImageView) view.findViewById(R.id.imgImage);
        TextView twNameTask = (TextView) view.findViewById(R.id.twNameTask);

        twNameTask.setText(tasks.get(position).getName());

        //Picasso pone la imagen desde internet al imageView
        Picasso.with(activity)
                .load(tasks.get(position).getImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(imgImage);

        return  view;
    }
}
