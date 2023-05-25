package com.example.winemeup;

import static com.example.winemeup.R.id.PersonPassword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.winemeup.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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

    private ActivitySignUpBinding binding;
    private FirebaseAuth firebaseAuth;

    //showing the progress
    private ProgressDialog progressDialog;


    private String email="",password="";


    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        firebaseAuth=FirebaseAuth.getInstance();







        binding.textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ActivitySignUp.this,ActivitySignIn.class));



            }
        });

        //configure progress digalog
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Getting the wine, please wait");
        progressDialog.setMessage("Creating the account !");
        progressDialog.setCanceledOnTouchOutside(false);

        binding.buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();



            }
        });
    }



    private void validateData() {
        //getting the data when the user writes it
        email=binding.PersonMail2.getText().toString().trim();
        password=binding.PersonPassword2.getText().toString().trim();
        //now actually validating the data
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //not valid email format
            binding.PersonMail2.setError("Are you already drunk? Invalid email format");


    } else if (TextUtils.isEmpty(password)) {
            //no password is entered
            binding.PersonPassword2.setError("Are you already drunk? You should enter a password");

        }
        else if(password.length()<4){
            //password less than 4 letters
            binding.PersonMail2.setError("At least 4 characters! W.I.N.E");
        }
        else{
            //data is okay
            firebaseSignUp();

        }


    }

    private void firebaseSignUp() {
        //show proogress
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //sign up succesfully
                        progressDialog.dismiss();
                        //get user info
                        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                        String email=firebaseUser.getEmail();
                        Toast.makeText(ActivitySignUp.this,"Account created\n"+email,Toast.LENGTH_SHORT).show();
                        //open the activity searching wine
                        startActivity(new Intent(ActivitySignUp.this,ActivityPage1.class));
                        finish();


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //failure
                        progressDialog.dismiss();
                        Toast.makeText(ActivitySignUp.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });

    }
}


