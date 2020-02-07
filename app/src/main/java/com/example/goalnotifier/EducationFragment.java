package com.example.goalnotifier;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EducationFragment extends Fragment {

    private Spinner sp_startyear,sp_endyear,sp_course;
    private EditText et_schoolName,et_favourite;
    private Button btn_education_submit;
    public EducationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.educational_info,container,false);

        sp_course=(Spinner)view.findViewById(R.id.sp_course);
        sp_startyear=(Spinner)view.findViewById(R.id.sp_startyear);
        sp_endyear=(Spinner)view.findViewById(R.id.sp_endyear);
        et_schoolName=(EditText)view.findViewById(R.id.et_schoolname);
        et_favourite=(EditText)view.findViewById(R.id.et_favourite);

        btn_education_submit=(Button) view.findViewById(R.id.btn_education_submit);

        ConnectivityManager connectivityManager=(ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState()==NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState()==NetworkInfo.State.CONNECTED)
        {
            Toast.makeText(getActivity(),"connected",Toast.LENGTH_LONG).show();
            return view;
        }
        else{
            Toast.makeText(getActivity(),"Please turn/ON Internet",Toast.LENGTH_LONG).show();
            return view;
        }
    }
}
