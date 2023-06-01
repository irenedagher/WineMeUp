package com.example.winemeup;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {

    private TextView nameTV,descriptionTV,galaxyTV,starTV,dobTV,diedTV;
    private Wine receivedWine;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private void initializeWidgets(){
        nameTV= findViewById(R.id.nameTV);
        descriptionTV= findViewById(R.id.descriptionTV);
        galaxyTV= findViewById(R.id.galaxyTV);
        starTV= findViewById(R.id.starTV);
        dobTV= findViewById(R.id.dobTV);
        diedTV= findViewById(R.id.dodTV);
        FloatingActionButton editFAB = findViewById(R.id.editFAB);
        mCollapsingToolbarLayout=findViewById(R.id.mCollapsingToolbarLayout);
        mCollapsingToolbarLayout.setExpandedTitleColor(getResources().
                getColor(R.color.white));
    }
    private void receiveAndShowData(){
        receivedWine= Utils.receiveWine(getIntent(),DetailActivity.this);

        if(receivedWine != null){
            nameTV.setText(receivedWine.getDomain());
            descriptionTV.setText(receivedWine.getDescription());
            galaxyTV.setText(receivedWine.getColour());
            starTV.setText(receivedWine.getPrice());
            dobTV.setText(receivedWine.getNameDish());
            diedTV.setText(receivedWine.getRegion());

            mCollapsingToolbarLayout.setTitle(receivedWine.getDomain());
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initializeWidgets();
        receiveAndShowData();
    }
}
//end
