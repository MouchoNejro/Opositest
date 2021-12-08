package com.example.Testeando.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Testeando.Adapters.EspecialidadesAdapter;
import com.example.Testeando.R;
import com.example.Testeando.javaclass.EspecialidadesHelperClass;

import java.util.ArrayList;

public class Autonomos extends AppCompatActivity {
    RecyclerView featuredEspecRecycler;

    private EspecialidadesAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomos);

        featuredEspecRecycler=findViewById(R.id.autonomos_recycler);



        especialidadesrecycler();
    }

    private void especialidadesrecycler(){


        featuredEspecRecycler.setHasFixedSize(true);
        featuredEspecRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ArrayList<EspecialidadesHelperClass> featuredespec = new ArrayList<>();
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.deporte,"Actividades fisico-deportivas",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.administracion,"Administración y gestión",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.agricultura,"Agricultura y Ganadería",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.artes,"Artes gráficas,prensa y editoriales",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.comercio,"Comercio",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.construccion,"Construcción e industrias extractivas",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.deporte,"Actividades fisico-deportivas",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.administracion,"Administración y gestión",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.agricultura,"Agricultura y Ganadería",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.artes,"Artes gráficas,prensa y editoriales",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.comercio,"Comercio",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.construccion,"Construcción e industrias extractivas",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.deporte,"Actividades fisico-deportivas",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.administracion,"Administración y gestión",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.agricultura,"Agricultura y Ganadería",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.artes,"Artes gráficas,prensa y editoriales",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.comercio,"Comercio",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.construccion,"Construcción e industrias extractivas",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.deporte,"Actividades fisico-deportivas",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.administracion,"Administración y gestión",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.agricultura,"Agricultura y Ganadería",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.artes,"Artes gráficas,prensa y editoriales",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.comercio,"Comercio",""));
        featuredespec.add(new EspecialidadesHelperClass(R.drawable.construccion,"Construcción e industrias extractivas",""));

        EspecialidadesAdapter adapter=new EspecialidadesAdapter(featuredespec,listener);
        featuredEspecRecycler.setAdapter(adapter);
    }

    private void setOnclickListenerGeneral() {
        listener = new EspecialidadesAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                switch (position) {
                    //Tus examenes case
                    case 0:
                        String valor = "Comercio";
                        Intent intent = new Intent(Autonomos.this, ModeloExamen2.class);
                        intent.putExtra("valor",valor);
                        startActivity(intent);

                        break;
                    //Autonomos case
                    case 1: // Open second activity
                        //Intent intent = new Intent(Autonomos.this, clasepordefinir.class);
                        //startActivity();
                        break;
                    //Empleados case
                    case 2:
                        break;
                    //Oposiciones case
                    case 3:

                        break;

                }
            }
        };

    }
}