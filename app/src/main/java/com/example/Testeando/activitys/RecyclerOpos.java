package com.example.Testeando.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Testeando.Adapters.AdapterOposiciones;
import com.example.Testeando.Adapters.FeaturedAdapter;
import com.example.Testeando.R;
import com.example.Testeando.javaclass.Oposicion;

import java.util.ArrayList;

public class RecyclerOpos extends AppCompatActivity {

    ArrayList<Oposicion> s1;
    RecyclerView recycler;
    private FeaturedAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_oposiciones);

        s1 = new ArrayList<>();
        recycler = findViewById(R.id.recycler_opo);
        llenarArray();
        AdapterOposiciones adapterOposiciones = new AdapterOposiciones(this, s1);

        adapterOposiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adapterOposiciones.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int itemPosition = recycler.getChildLayoutPosition(view);
                        switch (itemPosition){

                            case 0:

                                Intent i = new Intent(RecyclerOpos.this, ModeloExamen2.class);
                                i.putExtra("grupo","A1");
                                i.putExtra("curso","Cuerpo Administrativo");
                                i.putExtra("asignatura","Constitucion");
                                startActivity(i);
                                break;

                            case 1:

                                Intent i1 = new Intent(RecyclerOpos.this, ModeloExamen2.class);
                                i1.putExtra("grupo","B1");
                                i1.putExtra("curso","Policia local");
                                i1.putExtra("asignatura","General");
                                startActivity(i1);

                                break;

                            case 2:

                                Intent i2 = new Intent (RecyclerOpos.this, ModeloExamen2.class);
                                i2.putExtra("grupo","A2");
                                i2.putExtra("curso","Agente Hacienda Publica");
                                i2.putExtra("asignatura","Acceso Libre");
                                startActivity(i2);

                                break;
                        }
                    }
                });
            }
        });
        recycler.setAdapter(adapterOposiciones);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    public void llenarArray() {
        s1.add(new Oposicion(R.drawable.judge, "Jueces y Fiscales"));
        s1.add(new Oposicion(R.drawable.policeman, "Fuerzas y Cuerpos de Seguridad"));
        s1.add(new Oposicion(R.drawable.hacienda, "Hacienda"));
        s1.add(new Oposicion(R.drawable.doctor, "Sanidad"));
        s1.add(new Oposicion(R.drawable.teacher, "Universidades"));
        s1.add(new Oposicion(R.drawable.lawyer, "Abogacía"));
        s1.add(new Oposicion(R.drawable.politica, "Ayuntamientos"));
        s1.add(new Oposicion(R.drawable.earth, "Medio Ambiente"));
        s1.add(new Oposicion(R.drawable.leyendo, "Bibliotecas"));
        s1.add(new Oposicion(R.drawable.mailman, "Correos"));
    }


    }



