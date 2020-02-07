package com.example.goalnotifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    FirebaseAuth myAuth;
    FirebaseUser user;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.home_page,container,false);
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user==null ) {

            Intent intent = new Intent(getActivity(), SendOTP.class);
            startActivity(intent);
        } else {
        }
        return view;
    }
}
