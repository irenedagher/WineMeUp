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
//import com.google.android.material.textfield.TextInputEditText;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivitySignUp extends AppCompatActivity {

    EditText PersonName2, PersonMail2, PersonPassword2;

    Button button_signup;
    FirebaseDatabase database;
    DatabaseReference reference;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAuth = FirebaseAuth.getInstance();
        PersonName2 = findViewById(R.id.PersonName2);
        PersonPassword2 = findViewById(R.id.PersonPassword2);
        PersonMail2 = findViewById(R.id.PersonMail2);

        button_signup = findViewById(R.id.button_signup);

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, email, password;
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                name = PersonName2.getText().toString();
                email = PersonMail2.getText().toString();
                password = PersonPassword2.getText().toString();


                Toast.makeText(ActivitySignUp.this, "Succesfully sign up!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ActivitySignUp.this, ActivityPage1.class);
                startActivity(intent);


            }
        });

    }
}


