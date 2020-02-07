package com.example.goalnotifier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    Activity context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.profile_page,container,false);

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String number=user.getPhoneNumber();
        TextView txt=(TextView)rootview.findViewById(R.id.number);
        txt.setText(number);
        Button btn=(Button) rootview.findViewById(R.id.btn_logout);
        Button detail=(Button) rootview.findViewById(R.id.detail);
        context=getActivity();
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,UserDataActivity.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(this,SendOTP.class);
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getContext(),"Logout Successful",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),SendOTP.class);
                startActivity(intent);
            }
        });
        return rootview;
    }
}
