package com.example.Testeando.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Testeando.Adapters.OposPorCaAdapter;
import com.example.Testeando.R;
import com.example.Testeando.javaclass.OposPorCaHelperClass;

import java.util.ArrayList;

public class OposicionesGeneral extends AppCompatActivity {

    RecyclerView featuredOposRecycler;

    private OposPorCaAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oposiciones_general);

        featuredOposRecycler = findViewById(R.id.featured_opos);

        oposporcarecycler();


    }

    private void oposporcarecycler() {

        featuredOposRecycler.setHasFixedSize(true);
        featuredOposRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<OposPorCaHelperClass> featuredopos = new ArrayList<>();

        featuredopos.add(new OposPorCaHelperClass(R.drawable.galicia2, "Oposiciones Galicia", "Corpo administrativo (subgrupo C1) "));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.asturias2, "Oposiciones Asturias", "Especialidad de personal de limpieza y cocina"));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.navarra, "Oposiciones Navarra", "Escala superior de finanzas(A1)"));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.andalucia, "Oposiciones Andalucía", "Personal de recursos naturales y forestales (AP)"));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.galicia2, "Oposiciones Galicia", "Corpo administrativo (subgrupo C1) "));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.asturias2, "Oposiciones Asturias", "Especialidad de personal de limpieza y cocina"));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.navarra, "Oposiciones Navarra", "Escala superior de finanzas(A1)"));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.andalucia, "Oposiciones Andalucía", "Personal de recursos naturales y forestales (AP)"));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.galicia2, "Oposiciones Galicia", "Corpo administrativo (subgrupo C1) "));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.asturias2, "Oposiciones Asturias", "Especialidad de personal de limpieza y cocina"));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.navarra, "Oposiciones Navarra", "Escala superior de finanzas(A1)"));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.andalucia, "Oposiciones Andalucía", "Personal de recursos naturales y forestales (AP)"));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.galicia2, "Oposiciones Galicia", "Corpo administrativo (subgrupo C1) "));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.asturias2, "Oposiciones Asturias", "Especialidad de personal de limpieza y cocina"));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.navarra, "Oposiciones Navarra", "Escala superior de finanzas(A1)"));
        featuredopos.add(new OposPorCaHelperClass(R.drawable.andalucia, "Oposiciones Andalucía", "Personal de recursos naturales y forestales (AP)"));

        setOnclickListenerGeneral();
        OposPorCaAdapter adapter = new OposPorCaAdapter(featuredopos,listener);
        featuredOposRecycler.setAdapter(adapter);

    }

    private void setOnclickListenerGeneral() {
        listener = new OposPorCaAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                switch (position) {
                    //Tus examenes case
                    case 0:


                        break;
                    //Autonomos case
                    case 1: // Open second activity
                        String path =  "A1/Cuerpo Administrativo/Constitucion";
                        Intent intent = new Intent(OposicionesGeneral.this, ModeloExamen2.class);
                        intent.putExtra("path",path);
                        startActivity(intent);
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