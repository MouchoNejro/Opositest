package com.example.Testeando.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.Testeando.R;

public class Contacto extends AppCompatActivity {


    EditText edttlf;
    CheckBox checkBoxtlf;
    Button btnterminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        //toolbarcont = (Toolbar) findViewById(R.id.toolbarexamen);
        //setSupportActionBar(toolbarcont);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);


        edttlf = findViewById(R.id.edttlf);
        checkBoxtlf = findViewById(R.id.checkBoxtlf);
        btnterminar = findViewById(R.id.btnreporte);

        checkBoxtlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBoxtlf.isChecked()){
                    edttlf.setVisibility(View.VISIBLE);
                }
                else if(!checkBoxtlf.isChecked()){
                    edttlf.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnterminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Contacto.this, GeneralTest.class);
                startActivity(i);
            }
        });
    }


}

