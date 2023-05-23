package com.example.winemeup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_signup_ = (Button) findViewById(R.id.button_signup_);
        Button button_signin_ = (Button) findViewById(R.id.button_signin_);


        button_signup_.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivitySignUp();
            }
        });

        button_signin_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySignIn();

            }

        });
    }

public void openActivitySignIn(){
    Intent intent=new Intent(this, ActivitySignIn.class);
    startActivity(intent);
}
public void openActivitySignUp(){
            Intent intent=new Intent(this, ActivitySignUp.class);
            startActivity(intent);
        }
}
