package com.example.goalnotifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VerifyOTP extends AppCompatActivity {
    FirebaseAuth myAuth;
    EditText et_verify;
    Button btn_verify;
    String codesend;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify_otp);

        codesend=getIntent().getStringExtra("codesend");

        myAuth=FirebaseAuth.getInstance();
        et_verify=(EditText)findViewById(R.id.et_verifyotp);
        btn_verify=(Button)findViewById(R.id.btn_verifyotp);


        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyOTP();
            }
        });
    }
    public void verifyOTP()
    {
        String code=et_verify.getText().toString();
        if(code.isEmpty() || codesend.isEmpty())
        {
            Toast.makeText(this,"Please try again!",Toast.LENGTH_SHORT).show();

        }
        else{
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codesend, code);
            signInWithPhoneAuthCredential(credential);
        }
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        myAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent=new Intent(VerifyOTP.this,MainActivity.class);
                            startActivity(intent);
                            //Toast.makeText(getApplicationContext(),"WELOME TO REGISTRATION ACTIVITY",Toast.LENGTH_LONG).show();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(getApplicationContext(), "Login Failed please try again!", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }
}
