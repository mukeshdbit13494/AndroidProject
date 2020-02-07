package com.example.goalnotifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddFragment extends Fragment {
    Button btn_task,btn_subtask;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.add_task,container,false);
        btn_task=(Button)view.findViewById(R.id.btn_add_task);
        btn_subtask=(Button)view.findViewById(R.id.btn_subtask);

        btn_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_subtask.setEnabled(true);
                btn_subtask.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getActivity(),SubtaskActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        return view;
    }
}
