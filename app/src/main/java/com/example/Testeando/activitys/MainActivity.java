package com.example.Testeando.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;



import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.example.Testeando.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    //Variables

    private Executor executor;
    FirebaseAuth firebaseAuth;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaración de botones
        Button btnregis = findViewById(R.id.btnregistra);
        Button btnsesion = findViewById(R.id.iniciasesion);


        //Acción de boton registrar con mail
        btnregis.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, Registro.class);
            startActivity(i);

        });

        //Acción de boton de inciar sesión
        btnsesion.setOnClickListener(v -> {
            Intent i2 = new Intent(getApplicationContext(), Login.class);


            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(findViewById(R.id.iniciasesion), "transition_login");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
            startActivity(i2, options.toBundle());
        });
    }


    @Override
    protected void onStart() {
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, GeneralTest.class));
            finish();
        }

        super.onStart();
    }

}






