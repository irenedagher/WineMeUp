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
        button_signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSignUppage();
            }
        });
    }
    public void openSignUppage() {
        Intent intent=new Intent(this,ActivitySignUp.class);
        startActivity(intent);
    }
}
