package com.example.Testeando.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.Testeando.Adapters.AdapterAuto;
import com.example.Testeando.Adapters.AdapterOposiciones;
import com.example.Testeando.Adapters.FeaturedAdapter;
import com.example.Testeando.R;
import com.example.Testeando.javaclass.Oposicion;

import java.util.ArrayList;

public class RecyclerAutoescuela extends AppCompatActivity {

    ArrayList<Oposicion> s2;
    RecyclerView recycler;
    private FeaturedAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_autoescuela);

        s2 = new ArrayList<>();
        recycler = findViewById(R.id.recycler_auto);
        llenarArray();
        AdapterAuto adapterAuto = new AdapterAuto(this, s2);

        adapterAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adapterAuto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int itemPosition = recycler.getChildLayoutPosition(view);
                        switch (itemPosition) {
                            case 0:


                                break;

                            case 1:


                                break;
                        }
                    }
                });
            }
        });
        recycler.setAdapter(adapterAuto);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    public void llenarArray() {

        s2.add(new Oposicion(R.drawable.motorbike, "Carnet A"));
        s2.add(new Oposicion(R.drawable.car, "Carnet B"));
        s2.add(new Oposicion(R.drawable.truck, "Carnet C"));
        s2.add(new Oposicion(R.drawable.bus, "Carnet D"));
        s2.add(new Oposicion(R.drawable.trailer, "Carnet E"));

    }

}