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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.winemeup.databinding.ActivitySignInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ActivitySignIn extends AppCompatActivity {



    private ActivitySignInBinding binding;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;
    private String email="",password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySignInBinding.inflate(getLayoutInflater());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(binding.getRoot());

        progressDialog= new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Signing in");
        progressDialog.setCanceledOnTouchOutside(false);

        //if have account,signup
        firebaseAuth=FirebaseAuth.getInstance();
        binding.haveAccountTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            startActivity(new Intent(ActivitySignIn.this,ActivitySignUp.class));

            }
        });

        binding.buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }


        });

    }

private void validateData(){
        email=binding.PersonName.getText().toString().trim();
        password=binding.PersonPassword.getText().toString().trim();
    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
        //not valid email format
        binding.PersonName.setError("Are you already drunk? Invalid email format");


    } else if (TextUtils.isEmpty(password)) {
        //no password is entered
        binding.PersonPassword.setError("Are you already drunk? You should enter a password");

    }
    else if(password.length()<4){
        //password less than 4 letters
        binding.PersonName.setError("At least 4 characters! W.I.N.E");
    }
    else{
        //data is okay
        firebaseSignin();

    }

}

    private void firebaseSignin() {
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //succesfull

                        FirebaseUser  firebaseUser=firebaseAuth.getCurrentUser();
                        String email=firebaseUser.getEmail();
                        Toast.makeText(ActivitySignIn.this,"LoggedIn\n"+email,Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(ActivitySignIn.this,ActivityPage1.class));
                        finish();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(ActivitySignIn.this, ""+e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
    }


};
