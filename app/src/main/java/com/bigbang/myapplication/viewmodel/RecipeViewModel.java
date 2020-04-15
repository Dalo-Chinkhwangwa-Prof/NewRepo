package com.bigbang.myapplication.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.bigbang.myapplication.model.Recipe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RecipeViewModel extends AndroidViewModel {

    private PublishSubject<List<Recipe>> recipePublishSubject = PublishSubject.create();

    public RecipeViewModel(@NonNull Application application) {
        super(application);
    }

    public Observable<List<Recipe>> getRecipes(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("recipes");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Recipe> recipeList = new ArrayList<>();
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    recipeList.add(ds.getValue(Recipe.class));
                }
                recipePublishSubject.onNext(recipeList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("TAG_Z", "To cause merge conflict");
            }
        });

        return recipePublishSubject;
    }
}
