package com.example.Testeando.activitys;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Testeando.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import pl.droidsonroids.gif.GifImageView;

public class TusExamenes extends AppCompatActivity {

    private FirebaseFirestore fStore;
    TextView aprobado, completado,media,animos;
GifImageView tonto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tus_examenes);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String usu = mAuth.getCurrentUser().getUid();
        fStore= FirebaseFirestore.getInstance();
        aprobado=findViewById(R.id.tvaprobado);
        completado=findViewById(R.id.tvcompletado);
        media=findViewById(R.id.tvmedia);
        animos=findViewById(R.id.tvanimo);
        tonto=findViewById(R.id.gifresult);

        fStore.collection("users").document(usu)
                //extraigo info del doc
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();

                if (document.exists()) {
                String complet = String.valueOf(document.get("completados"));
                String ok = String.valueOf(document.get("resultados"));
                completado.setText(complet);
                aprobado.setText(ok);

                int aprob = Integer.parseInt(ok);
                int total = Integer.parseInt(complet);

                int percent=0;

                percent= 100*aprob/total;

                String porcentaje = String.valueOf(percent);

                media.setText(porcentaje + "%");


                    if (percent <=25){

                        tonto.setBackgroundResource(R.drawable.suspenso);
                        animos.setText("No eres el cuchillo más afilado del cajón.");

                    }

                if (percent <=49 && percent >=26){

                   tonto.setBackgroundResource(R.drawable.casi);
                    animos.setText("Casi sirves para algo creo que puedes hacerlo mejor.");

                }

                    if (percent >=50){

                        tonto.setBackgroundResource(R.drawable.aprobado);

                        animos.setText("Muy bien, apruebas raspadito.");

                    }

                    if (percent >=75){

                        tonto.setBackgroundResource(R.drawable.muyaprobado);
                        animos.setText("Nos rendimos ante tu portentosa mente.");

                    }
                }


            }
        });




    }
}