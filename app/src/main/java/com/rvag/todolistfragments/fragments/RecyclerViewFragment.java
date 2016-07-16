package com.rvag.todolistfragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.rvag.todolistfragments.R;
import com.rvag.todolistfragments.adapters.RecyclerViewTaskAdapter;
import com.rvag.todolistfragments.model.Task;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        final EditText edtTaskCV = (EditText) view.findViewById(R.id.editTaskRecycler);
        final EditText edtDescriptionTaskCV = (EditText) view.findViewById(R.id.editDescriptionTaskRecycler);
        Button btnSaveTask = (Button) view.findViewById(R.id.btnTaskRecycler);

        final ArrayList<Task> tasks = new ArrayList<Task>();

        final RecyclerView rvTaskRecycler = (RecyclerView) view.findViewById(R.id.rvTaskRecycler);
        final RecyclerViewTaskAdapter adapter = new RecyclerViewTaskAdapter(getContext(),tasks,R.layout.cardview_task);

        rvTaskRecycler.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvTaskRecycler.setLayoutManager(linearLayoutManager);

        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = edtTaskCV.getText().toString();
                String taskDescription = edtDescriptionTaskCV.getText().toString();

                Task task = new Task(taskName,"http://icons.iconarchive.com/icons/searchallwreckers/car/72/Ford-Mustang-icon.png");
                task.setDescripcion(taskDescription);
                tasks.add(task);

                adapter.notifyDataSetChanged();
                edtTaskCV.setText("");
                edtDescriptionTaskCV.setText("");
            }
        });

        return view;
    }

}
