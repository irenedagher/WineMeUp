package com.example.winemeup;

import static com.example.winemeup.R.id.PersonPassword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ActivitySignIn extends AppCompatActivity {


   EditText PersonName,PersonPassword;

    Button button_signin;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAuth = FirebaseAuth.getInstance();
        PersonName = findViewById(R.id.PersonName);
        PersonPassword = findViewById(R.id.PersonPassword);

        button_signin = findViewById(R.id.button_signin);

        button_signin.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {
                                                 if (!validateMail() | !validatePassword()) {

                                                 }else{
                                                     checkUser();
                                                 }
                                             }

                                         }
        );

    }

    public Boolean validateMail(){
        String val=PersonName.getText().toString();
        if(val.isEmpty()){
            PersonName.setError("Already drunk ? Username cannot be empty");
            return false;

        }else{
            PersonName.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val=PersonPassword.getText().toString();
        if(val.isEmpty()){
            PersonPassword.setError("Already drunk ?Password cannot be empty");
            return false;

        }else{
            PersonPassword.setError(null);
            return true;
        }
    }
    public void checkUser(){
        String userMail=PersonName.getText().toString().trim();
        String userPassword=PersonPassword.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase=reference.orderByChild("username").equalTo(userMail);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    PersonName.setError(null);
                    String passwordFromDB=snapshot.child(userPassword).child("password").getValue(String.class);
                    if(!Objects.equals(passwordFromDB,userPassword)){
                        PersonName.setError(null);
                        Intent intent=new Intent(ActivitySignIn.this,ActivityPage1.class);
                        startActivity(intent);
                    }else{
                        PersonPassword.setError("Invalid credentials");
                        PersonPassword.requestFocus();
                    }
                }else{
                    PersonName.setError("User does not exist");
                    PersonName.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



};
