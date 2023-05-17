package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name, pass;
Button button;
EditText editText, mEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editTextTextEmailAddress);
        mEditText = (EditText) findViewById(R.id.editTextTextPassword);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name= editText.getText().toString();
                pass= mEditText.getText().toString();
                if(name.equals("admin") && pass.equals("admin")){
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }else{
                    showToast("Invalid username or password");
                }
            }
        });
    }
        private void showToast(String text){
            Toast.makeText(this,text, Toast.LENGTH_SHORT).show();



    }
}