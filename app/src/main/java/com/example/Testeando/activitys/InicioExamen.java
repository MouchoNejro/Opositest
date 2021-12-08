package com.example.Testeando.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Testeando.Adapters.AdapterExpandable;
import com.example.Testeando.R;

import java.util.ArrayList;
import java.util.HashMap;

public class InicioExamen extends AppCompatActivity {

    ExpandableListView expandableListView;
    ArrayList<String> listGroup = new ArrayList<>();
    ArrayList<String> listComunidades = new ArrayList<>();
    ArrayList<String> listOposiciones = new ArrayList<>();
    HashMap<String, ArrayList<String>> listChild = new HashMap<>();
    AdapterExpandable adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_examen);

        expandableListView = findViewById(R.id.exp_list_view);
        rellenarArray1();
        rellenarArray2();

        for (int i =0;i<listComunidades.size();i++){
            listGroup.add(listComunidades.get(i));
            ArrayList<String> arrayList = new ArrayList<>();

            for(int c=0;c<listOposiciones.size();c++){
                arrayList.add(listOposiciones.get(c));
            }
            listChild.put(listGroup.get(i), arrayList);

            adapter = new AdapterExpandable(listGroup, listChild);
            expandableListView.setAdapter(adapter);
        }

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {

                switch (groupPosition){
                    case 0:
                        Toast.makeText(getApplicationContext(),"case 0" , Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"case 1" , Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"case 2" , Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"case 3" , Toast.LENGTH_SHORT).show();
                        break;



                }


                return false;
            }
        });

    }

    public void rellenarArray1(){
        listComunidades.add("Galicia");
        listComunidades.add("Andalucía");
        listComunidades.add("Aragón");
        listComunidades.add("Asturias");
        listComunidades.add("Baleares");
        listComunidades.add("Canarias");
        listComunidades.add("Cantabria");
        listComunidades.add("Castilla la Mancha");
        listComunidades.add("Castilla y León");
        listComunidades.add("Cataluña");
        listComunidades.add("Comunidad Valenciana");
        listComunidades.add("Extremadura");
        listComunidades.add("La Rioja");
        listComunidades.add("Madrid");
        listComunidades.add("Murcia");
        listComunidades.add("Navarra");
        listComunidades.add("País Vasco");
        listComunidades.add("Ceuta");
        listComunidades.add("Melilla");
    }
    public void rellenarArray2(){
        listOposiciones.add("Jueces y Fiscales");
        listOposiciones.add("Justicia");
        listOposiciones.add("Interior");
        listOposiciones.add("Fuerzas y Cuerpos de Seguridad");
        listOposiciones.add("Hacienda");
        listOposiciones.add("Administración General");
        listOposiciones.add("Seguridad Social");
        listOposiciones.add("Universidades");
        listOposiciones.add("C.Generales");
        listOposiciones.add("Comunidades Autónomas");
        listOposiciones.add("Abogacía");
        listOposiciones.add("Ayuntamientos y Corporaciones locales");
        listOposiciones.add("Test Legislación");
        listOposiciones.add("Medio Ambiente");
        listOposiciones.add("Sanidad - Celadores");
        listOposiciones.add("Sanidad- Auxiliares Enfermería");
        listOposiciones.add("Sanidad - Otras categorías");
        listOposiciones.add("Sanidad - Legislación");
        listOposiciones.add("Bibliotecas");
        listOposiciones.add("Correos");
        listOposiciones.add("EMT");
        listOposiciones.add("Gesores Administrativos");
    }


}