package com.example.winemeup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //private bu button_signup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_signup = (Button) findViewById(R.id.button_signup);
        Button button_signin = (Button) findViewById(R.id.button_signin);
        button_signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSignUppage();
            }
        });
        button_signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSignInpage();
            }
        });
    }
    public void openSignUppage() {
        Intent intent=new Intent(this,ActivitySignUp.class);
        startActivity(intent);
    }
    public void openSignInpage() {
        Intent intent=new Intent(this,WineListActivity.class);
        startActivity(intent);
    }
}
