package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.FormAdapter;
import model.Form;
import repository.DatabaseHelper;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
        Button button;
    EditText txt2,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
    Spinner roadSpinner,subLinkSpinner;
    public ArrayList<Form> forms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initForm();

        FormAdapter formAdapter = new FormAdapter(this,forms);

        subLinkSpinner = findViewById(R.id.spinner);
        roadSpinner = findViewById(R.id.road);
        ArrayAdapter<Form> roadAdapter = new ArrayAdapter<Form>(this,android.R.layout.simple_spinner_dropdown_item,forms);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roadSpinner.setAdapter(roadAdapter);
        subLinkSpinner.setAdapter(adapter);
        roadSpinner.setOnItemSelectedListener(this);
        button=(Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
public void next(View view){
        Intent intent = new Intent(this, MainActivity3.class);
                startActivity(intent);
}
    public void initForm(){
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        forms = db.getAllForms();

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Form form = (Form) roadSpinner.getSelectedItem();
        txt2=findViewById(R.id.editTextLink);
        txt4=findViewById(R.id.editTextStart);
        txt5=findViewById(R.id.editTextStart2);
        txt6=findViewById(R.id.editTextEnd);
        txt7=findViewById(R.id.editTextEnd2);
        txt8=findViewById(R.id.editTextCorridor);
        txt9=findViewById(R.id.editTextRegion);
        txt10=findViewById(R.id.editTextShoulder);

        txt2.setText(form.getLink());

        txt4.setText(form.getStart());

        txt6.setText(form.getEnd());

        txt8.setText(form.getCorridor());
        txt9.setText(form.getRegion());
        txt10.setText(form.getShoulder_type());



    }
    public void onNothingSelected(AdapterView<?> parent) {

    }


}