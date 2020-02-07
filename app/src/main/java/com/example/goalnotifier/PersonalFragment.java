package com.example.goalnotifier;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PersonalFragment extends Fragment {
    private Activity context;
    private Spinner sp_state,sp_city;
    private Button btn_userdata_submit;
    private RadioGroup rg_gender;
    private RadioButton rb_gender;
    private DatabaseReference databaseReference;
    private FirebaseUser user;
    String phoneNumber;
    EditText et_name,et_email,et_fathername,et_mobile,et_pincode;
    public PersonalFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.personal_info,container,false);


        //To get mobile number from login user
        user=FirebaseAuth.getInstance().getCurrentUser();
        phoneNumber=user.getPhoneNumber();

        //To create node for the new user with phone number as child
        databaseReference= FirebaseDatabase.getInstance().getReference("Users").child(phoneNumber);

        et_name=(EditText)view.findViewById(R.id.et_name);
        et_email=(EditText)view.findViewById(R.id.et_email);
        et_fathername=(EditText)view.findViewById(R.id.et_fathername);
        et_mobile=(EditText)view.findViewById(R.id.et_mobile);
        et_pincode=(EditText)view.findViewById(R.id.et_pincode);

        btn_userdata_submit=(Button)view.findViewById(R.id.btn_userdata_submit);

        sp_state=(Spinner)view.findViewById(R.id.sp_state);
        sp_city=(Spinner)view.findViewById(R.id.sp_city);

        rg_gender=(RadioGroup)view.findViewById(R.id.rg_gender);
        //rb_gender=(RadioButton)view.findViewById(rg_gender.getCheckedRadioButtonId());


        btn_userdata_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    Toast.makeText(getActivity(),"connected",Toast.LENGTH_LONG).show();
                } else
                {
                    Toast.makeText(getActivity(),"Please turn/ON Internet",Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}
