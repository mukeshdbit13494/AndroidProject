package com.example.goalnotifier;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SendOTP extends AppCompatActivity {
    FirebaseAuth myAuth;
    EditText et_number;
    Button btn_send;
    String codesend;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        myAuth=FirebaseAuth.getInstance();
        et_number=(EditText)findViewById(R.id.et_sendotp);
        btn_send=(Button)findViewById(R.id.btn_sendotp);


        Button home=(Button)findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SendOTP.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOTP();
            }
        });
    }
    private void sendOTP(){
        String number=et_number.getText().toString();
        String regexStr = "^[0-9]{10}$";
        if(number.isEmpty())
        {
            et_number.setHint("*please Enter mobile Number");
            et_number.setHintTextColor(Color.RED);
        }
        else if(number.length()>10 || number.length()<10)
        {
            et_number.setHint("*please Enter valid mobile Number");
            et_number.setHintTextColor(Color.RED);
        }
        else if(number.matches(regexStr))
        {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    "+91"+number,60,TimeUnit.SECONDS,this,mCallbacks);
        }
        else
        {
            et_number.setHint("*please Enter valid mobile Number");
            et_number.setHintTextColor(Color.RED);
        }
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codesend=s;
            Intent intent=new Intent(SendOTP.this,VerifyOTP.class);
            intent.putExtra("codesend",codesend);
            startActivity(intent);
        }
    };
}
