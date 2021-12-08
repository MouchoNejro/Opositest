package com.example.Testeando.activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Testeando.Adapters.FeaturedAdapter;
import com.example.Testeando.R;
import com.example.Testeando.javaclass.FeaturedHelperClass;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Objects;

public class GeneralTest extends AppCompatActivity {


    RecyclerView featuredRecycler;
    private FirebaseFirestore fStore;
    private FirebaseAuth firebaseAuth;
    private FeaturedAdapter.RecyclerViewClickListener listener;
    ImageView anadexamen,registrausu,borrausu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_general_test);

        //inicializo el objeto firebase
        firebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        //Hooks
        /*featuredEspecRecycler=findViewById(R.id.featured_espec);
        featuredOposRecycler= findViewById(R.id.features_opos); */
        featuredRecycler = findViewById(R.id.featured_recycler);


        //llamada a metodo
        featuredRecycler();

        //oposporcarecycler();
        //especialidadesrecycler();

        Toolbar toolgeneral = findViewById(R.id.toolgeneral);
        setSupportActionBar(toolgeneral);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        anadexamen = findViewById(R.id.anadirexamen);
        registrausu= findViewById(R.id.registrausu);


        controlAcceso(firebaseAuth.getCurrentUser().getUid());

        //AQUI SI EL USUARIO COINCIDE CON EL DEL IF SE MUESTRA EL BOTON DE LOS EXCEL
       /* FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        String userID = firebaseUser.getUid();
        if(userID.equals("pKfcKyzgrdhbP6Yu5ITG0ZHqgvf2")){
        //Seteo de la visibilidad del boton a visible
        anadexamen.setVisibility(View.VISIBLE); */

        //listener del boton y su toast
        anadexamen.setOnClickListener(view -> {
            Toast.makeText(GeneralTest.this, "¡Bienvenido Jefe", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GeneralTest.this, Admin.class);
            startActivity(intent);

        });

        registrausu .setOnClickListener(view -> {
            String id = firebaseAuth.getCurrentUser().getUid();
            Toast.makeText(GeneralTest.this, "¡Bienvenido Jefe", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GeneralTest.this, Registro.class);
            intent.putExtra("id",id);
            startActivity(intent);
        });
    }


    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredTest = new ArrayList<>();
        featuredTest.add(new FeaturedHelperClass(R.drawable.miniexamen2, "Tus exámenes", "Consulta tus exámenes realizados."));
        featuredTest.add(new FeaturedHelperClass(R.drawable.oposicion, "Oposiciones", "Exámenes para opositores."));
        featuredTest.add(new FeaturedHelperClass(R.drawable.autoescuela, "Autoescuela", " Exámenes para cualquier permiso de conducir."));
        featuredTest.add(new FeaturedHelperClass(R.drawable.ux, "Informatica", "Exámenes para programadores."));
        setOnclickListenerGeneral();
        FeaturedAdapter adapter = new FeaturedAdapter(featuredTest, listener);
        featuredRecycler.setAdapter(adapter);

    }

    private void setOnclickListenerGeneral() {
        listener = new FeaturedAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                switch (position) {
                    //Tus examenes case
                    case 0:


                        Intent intent = new Intent(GeneralTest.this, TusExamenes.class);

                        startActivity(intent);

                        break;
                    //Autonomos case
                    case 1: // Open second activity

                        Intent intent1 = new Intent(GeneralTest.this, RecyclerOpos.class);
                        startActivity(intent1);

                        break;
                    //Empleados case
                    case 2:
                        Intent intent2 = new Intent(GeneralTest.this, RecyclerAutoescuela.class);

                        startActivity(intent2);

                        break;
                    //Oposiciones case
                    case 3:


                        break;

                }
            }
        };

    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menugeneral, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.perfil:

                Intent i = new Intent(GeneralTest.this, Perfil.class);
                startActivity(i);
                break;

            case R.id.notificacion:

                return true;


            case R.id.formate:

                Uri uri = Uri.parse("http://www.formate.es/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.contacto:

                Intent intenta = new Intent(GeneralTest.this, Contacto.class);
                startActivity(intenta);
                break;

            case R.id.preguntasfrec:

                Uri uripregu = Uri.parse("https://www.formate.es/preguntas-frecuentes/"); // missing 'http://' will cause crashed
                Intent intentpregu = new Intent(Intent.ACTION_VIEW, uripregu);
                startActivity(intentpregu);
                break;

            case R.id.legal:

                Uri urilegal = Uri.parse("https://www.formate.es/aviso-legal/"); // missing 'http://' will cause crashed
                Intent intentlegal = new Intent(Intent.ACTION_VIEW, urilegal);
                startActivity(intentlegal);
                break;

            case R.id.cerrar:

                SharedPreferences preferences = getSharedPreferences("cbRecuerdame", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();
                firebaseAuth.signOut();
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void controlAcceso(String uid) {

        DocumentReference df = fStore.collection("users").document(uid);
        //extraigo info del docu
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(@NonNull DocumentSnapshot documentSnapshot) {
                Log.d("TAG", "exito: " + documentSnapshot.getData());
                //identifación de rol de acceso

                if (documentSnapshot.getString("admin") != null) {
                    //usuario es administrador
                    anadexamen.setVisibility(View.VISIBLE);
                    registrausu.setVisibility(View.VISIBLE);

                    String nombre =  documentSnapshot.getString("nombre");
                    Toast.makeText(GeneralTest.this, "¡Bienvenido " + nombre, Toast.LENGTH_SHORT).show();
                }

                if (documentSnapshot.getString("alumno") != null) {
                    //usuario es alumno
                    String nombre =  documentSnapshot.getString("nombre");
                    Toast.makeText(GeneralTest.this, "¡Bienvenido " + nombre, Toast.LENGTH_SHORT).show();
                }

                if (documentSnapshot.getString("profesor") != null) {
                    //usuario es alumno
                    registrausu.setVisibility(View.VISIBLE);
                    anadexamen.setVisibility(View.VISIBLE);
                    String nombre = documentSnapshot.getString("nombre");
                    Toast.makeText(GeneralTest.this, "¡Bienvenido " + nombre, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}