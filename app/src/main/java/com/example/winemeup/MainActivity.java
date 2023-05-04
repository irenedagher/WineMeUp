package com.example.winemeup;

import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_signup = (Button) findViewbyId(R.id.button_signup);
        button.setOnClickListener(new View.OnClickListener() {
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
