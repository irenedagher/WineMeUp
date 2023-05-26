/*package com.example.winemeup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class WineListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_wines);
        new FirebaseDatabaseHelper().readWines(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Wine> wines, List<String> keys) {
                //findViewById(R.id.loading_wines_pb).setVisibility(View.GONE);
                new RecyclerView_Config().setConfig(mRecyclerView,WineListActivity.this,
                        wines, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}*/