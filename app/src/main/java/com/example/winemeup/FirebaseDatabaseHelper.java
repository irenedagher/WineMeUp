package com.example.winemeup;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
   /* private DatabaseReference mReferenceDish;*/
    private DatabaseReference mReferenceWine;
   /* private DatabaseReference mReferenceVariety;*/
    private List<Wine> wines = new ArrayList<>();
    //private List<Variety> varieties = new ArrayList<>();
    //private List<Dish> dishes = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Wine> wines, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceWine = mDatabase.getReference("wines");

    }

    public void readWines(final DataStatus dataStatus){
        mReferenceWine.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Wine wine = keyNode.getValue(Wine.class);
                    wines.add(wine);
                }
                dataStatus.DataIsLoaded(wines,
                        keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
