package com.example.form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import adapter.FormAdapter;
import model.Form;
import repository.DatabaseHelper;

public class HomeActivity extends AppCompatActivity {

    public ArrayList<Form> forms = new ArrayList<>();
    public RecyclerView formRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        formRecycleView = findViewById(R.id.formRecycleView);
        getForms();

        FormAdapter adapter = new FormAdapter(this,forms);
        formRecycleView.setAdapter(adapter);
    }
    public void getForms(){


        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        forms = db.getAllForms();


    }
}