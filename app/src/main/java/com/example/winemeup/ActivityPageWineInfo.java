/*package com.example.winemeup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
//ALL VERSION OF FILES NOT USED ANYMORE (I hope)
public class ActivityPageWineInfo extends AppCompatActivity {
    private static final String TAG = "ViewWine";

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_info);

        mListView = (ListView) findViewById(R.id.listview_Wine);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void showData(DataSnapshot dataSnapshot){
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            Wine wine = new Wine();
            wine.setColour(ds.child("0").getValue(Wine.class).getColour());
            wine.setCountry(ds.child("0").getValue(Wine.class).getCountry());
            wine.setDescription(ds.child("0").getValue(Wine.class).getDescription());
            wine.setDomain(ds.child("0").getValue(Wine.class).getDomain());
            wine.setPrice(ds.child("0").getValue(Wine.class).getPrice());
            wine.setRegion(ds.child("0").getValue(Wine.class).getRegion());
            wine.setNameDish(ds.child("0").getValue(Wine.class).getNameDish());
            wine.setYear(ds.child("0").getValue(Wine.class).getYear());

            Log.d(TAG, "showData: colour: " + wine.getColour());
            Log.d(TAG, "showData: country: " + wine.getCountry());
            Log.d(TAG, "showData: description: " + wine.getDescription());
            Log.d(TAG, "showData: domain: " + wine.getDomain());
            Log.d(TAG, "showData: region: " + wine.getRegion());
            Log.d(TAG, "showData: price: " + wine.getPrice());
            Log.d(TAG, "showData: nameDish: " + wine.getNameDish());
            Log.d(TAG, "showData: year: " + wine.getYear());

            ArrayList<String> array = new ArrayList<>();
            array.add(wine.getColour());
            array.add(wine.getCountry());
            array.add(wine.getDescription());
            array.add(wine.getNameDish());
            array.add(wine.getDomain());
            array.add(String.valueOf(wine.getPrice()));
            array.add(wine.getRegion());
            array.add(String.valueOf(wine.getYear()));
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,array);
            mListView.setAdapter(adapter);




        }
    }

}*/
