package com.example.form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
    setContentView(R.layout.list_view);
        formRecycleView = findViewById(R.id.formRecycleView);
        getForms();
        FormAdapter adapter = new FormAdapter(this,forms);


        formRecycleView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));
        formRecycleView.setAdapter(adapter);

    }

    private void getForms() {
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        forms = db.getAllForms();
    }

}