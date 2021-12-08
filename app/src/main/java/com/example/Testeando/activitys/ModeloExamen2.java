package com.example.Testeando.activitys;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Testeando.R;
import com.example.Testeando.javaclass.PreguntaHandler;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Locale;

public class ModeloExamen2 extends AppCompatActivity {

    //pregunta1
    TextView tvpreg1, tvpunt2, tvpunt,tvasignatura;
    RadioButton rbtnp1r1, rbtnp1r2, rbtnp1r3, rbtnp1r4;
    //pregunta2
    TextView tvpreg2;
    RadioButton rbtnp2r1, rbtnp2r2, rbtnp2r3, rbtnp2r4;
    //pregunta3
    TextView tvpreg3;
    RadioButton rbtnp3r1, rbtnp3r2, rbtnp3r3, rbtnp3r4;
    //pregunta4
    TextView tvpreg4;
    RadioButton rbtnp4r1, rbtnp4r2, rbtnp4r3, rbtnp4r4;
    //pregunta5
    TextView tvpreg5;
    RadioButton rbtnp5r1, rbtnp5r2, rbtnp5r3, rbtnp5r4;
    //pregunta6
    TextView tvpreg6;
    RadioButton rbtnp6r1, rbtnp6r2, rbtnp6r3, rbtnp6r4;
    //pregunta7
    TextView tvpreg7;
    RadioButton rbtnp7r1, rbtnp7r2, rbtnp7r3, rbtnp7r4;
    //pregunta8
    TextView tvpreg8;
    RadioButton rbtnp8r1, rbtnp8r2, rbtnp8r3, rbtnp8r4;
    //pregunta9
    TextView tvpreg9;
    RadioButton rbtnp9r1, rbtnp9r2, rbtnp9r3, rbtnp9r4;
    //pregunta10
    TextView tvpreg10;
    RadioButton rbtnp10r1, rbtnp10r2, rbtnp10r3, rbtnp10r4;
    //pregunta11
    TextView tvpreg11;
    RadioButton rbtnp11r1, rbtnp11r2, rbtnp11r3, rbtnp11r4;
    //pregunta12
    TextView tvpreg12;
    RadioButton rbtnp12r1, rbtnp12r2, rbtnp12r3, rbtnp12r4;
    //pregunta13
    TextView tvpreg13;
    RadioButton rbtnp13r1, rbtnp13r2, rbtnp13r3, rbtnp13r4;
    //pregunta14
    TextView tvpreg14;
    RadioButton rbtnp14r1, rbtnp14r2, rbtnp14r3, rbtnp14r4;
    //pregunta15
    TextView tvpreg15;
    RadioButton rbtnp15r1, rbtnp15r2, rbtnp15r3, rbtnp15r4;
    //pregunta16
    TextView tvpreg16;
    RadioButton rbtnp16r1, rbtnp16r2, rbtnp16r3, rbtnp16r4;
    //pregunta17
    TextView tvpreg17;
    RadioButton rbtnp17r1, rbtnp17r2, rbtnp17r3, rbtnp17r4;
    //pregunta18
    TextView tvpreg18;
    RadioButton rbtnp18r1, rbtnp18r2, rbtnp18r3, rbtnp18r4;
    //pregunta19
    TextView tvpreg19;
    RadioButton rbtnp19r1, rbtnp19r2, rbtnp19r3, rbtnp19r4;
    //pregunta20
    TextView tvpreg20;
    RadioButton rbtnp20r1, rbtnp20r2, rbtnp20r3, rbtnp20r4;
    //pregunta21
    TextView tvpreg21;
    RadioButton rbtnp21r1, rbtnp21r2, rbtnp21r3, rbtnp21r4;
    //pregunta22
    TextView tvpreg22;
    RadioButton rbtnp22r1, rbtnp22r2, rbtnp22r3, rbtnp22r4;
    //pregunta23
    TextView tvpreg23;
    RadioButton rbtnp23r1, rbtnp23r2, rbtnp23r3, rbtnp23r4;
    //pregunta24
    TextView tvpreg24;
    RadioButton rbtnp24r1, rbtnp24r2, rbtnp24r3, rbtnp24r4;
    //pregunta25
    TextView tvpreg25;
    RadioButton rbtnp25r1, rbtnp25r2, rbtnp25r3, rbtnp25r4;
    //pregunta26
    TextView tvpreg26;
    RadioButton rbtnp26r1, rbtnp26r2, rbtnp26r3, rbtnp26r4;
    //pregunta27
    TextView tvpreg27;
    RadioButton rbtnp27r1, rbtnp27r2, rbtnp27r3, rbtnp27r4;
    //pregunta28
    TextView tvpreg28;
    RadioButton rbtnp28r1, rbtnp28r2, rbtnp28r3, rbtnp28r4;
    //pregunta28
    TextView tvpreg29;
    RadioButton rbtnp29r1, rbtnp29r2, rbtnp29r3, rbtnp29r4;
    //pregunta30
    TextView tvpreg30;
    RadioButton rbtnp30r1, rbtnp30r2, rbtnp30r3, rbtnp30r4;


    RadioGroup rgr1, rgr2, rgr3, rgr4, rgr5, rgr6, rgr7, rgr8, rgr9, rgr10, rgr11, rgr12, rgr13, rgr14, rgr15, rgr16, rgr17, rgr18, rgr19, rgr20, rgr21, rgr22, rgr23, rgr24, rgr25, rgr26, rgr27,
            rgr28, rgr29, rgr30;
    Button btnacabatest;
    public double puntuacion = 0;
    double resta = 0.25;

    long Time = 0;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ref;
    private DatabaseReference ref2;
    private FirebaseDatabase database;
    private PreguntaHandler pregunta;
    private boolean corregido;
    private FirebaseFirestore fStore;
    private FirebaseStorage storage;
    private StorageReference mStorageReference;
    //cronometro
    private TextView crono;
    private static final long START_TIME_IN_MILLIS = 300000;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelo_examen2);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String usu = mAuth.getCurrentUser().getUid();
        fStore = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();
        mStorageReference = storage.getReference();
        database = FirebaseDatabase.getInstance();

        //llamada botones generales
        btnacabatest = findViewById(R.id.btnacabatest);
        tvpunt = findViewById(R.id.tvpunt);
        tvpunt2 = findViewById(R.id.tvpunt2);
        crono = findViewById(R.id.tvcron);
        //llamada preguntas y respuestas
        tvpreg1 = findViewById(R.id.tvpregunta1);
        rbtnp1r1 = findViewById(R.id.rbtnp1r1);
        rbtnp1r2 = findViewById(R.id.rbtnp1r2);
        rbtnp1r3 = findViewById(R.id.rbtnp1r3);
        rgr1 = findViewById(R.id.rgr1);
        rbtnp1r4 = findViewById(R.id.rbtnp1r4);

        tvpreg2 = findViewById(R.id.tvpregunta2);
        rbtnp2r1 = findViewById(R.id.rbtnp2r1);
        rbtnp2r2 = findViewById(R.id.rbtnp2r2);
        rbtnp2r3 = findViewById(R.id.rbtnp2r3);
        rgr2 = findViewById(R.id.rgr2);
        rbtnp2r4 = findViewById(R.id.rbtnp2r4);

        tvpreg3 = findViewById(R.id.tvpregunta3);
        rbtnp3r1 = findViewById(R.id.rbtnp3r1);
        rbtnp3r2 = findViewById(R.id.rbtnp3r2);
        rbtnp3r3 = findViewById(R.id.rbtnp3r3);
        rgr3 = findViewById(R.id.rgr3);
        rbtnp3r4 = findViewById(R.id.rbtnp3r4);

        tvpreg4 = findViewById(R.id.tvpregunta4);
        rbtnp4r1 = findViewById(R.id.rbtnp4r1);
        rbtnp4r2 = findViewById(R.id.rbtnp4r2);
        rbtnp4r3 = findViewById(R.id.rbtnp4r3);
        rgr4 = findViewById(R.id.rgr4);
        rbtnp4r4 = findViewById(R.id.rbtnp4r4);

        tvpreg5 = findViewById(R.id.tvpregunta5);
        rbtnp5r1 = findViewById(R.id.rbtnp5r1);
        rbtnp5r2 = findViewById(R.id.rbtnp5r2);
        rbtnp5r3 = findViewById(R.id.rbtnp5r3);
        rbtnp5r4 = findViewById(R.id.rbtnp5r4);
        rgr5 = findViewById(R.id.rgr5);

        tvpreg6 = findViewById(R.id.tvpregunta6);
        rbtnp6r1 = findViewById(R.id.rbtnp6r1);
        rbtnp6r2 = findViewById(R.id.rbtnp6r2);
        rbtnp6r3 = findViewById(R.id.rbtnp6r3);
        rbtnp6r4 = findViewById(R.id.rbtnp6r4);
        rgr6 = findViewById(R.id.rgr6);

        tvpreg7 = findViewById(R.id.tvpregunta7);
        rbtnp7r1 = findViewById(R.id.rbtnp7r1);
        rbtnp7r2 = findViewById(R.id.rbtnp7r2);
        rbtnp7r3 = findViewById(R.id.rbtnp7r3);
        rbtnp7r4 = findViewById(R.id.rbtnp7r4);
        rgr7 = findViewById(R.id.rgr7);

        tvpreg8 = findViewById(R.id.tvpregunta8);
        rbtnp8r1 = findViewById(R.id.rbtnp8r1);
        rbtnp8r2 = findViewById(R.id.rbtnp8r2);
        rbtnp8r3 = findViewById(R.id.rbtnp8r3);
        rbtnp8r4 = findViewById(R.id.rbtnp8r4);
        rgr8 = findViewById(R.id.rgr8);

        tvpreg9 = findViewById(R.id.tvpregunta9);
        rbtnp9r1 = findViewById(R.id.rbtnp9r1);
        rbtnp9r2 = findViewById(R.id.rbtnp9r2);
        rbtnp9r3 = findViewById(R.id.rbtnp9r3);
        rbtnp9r4 = findViewById(R.id.rbtnp9r4);
        rgr9 = findViewById(R.id.rgr9);

        tvpreg10 = findViewById(R.id.tvpregunta10);
        rbtnp10r1 = findViewById(R.id.rbtnp10r1);
        rbtnp10r2 = findViewById(R.id.rbtnp10r2);
        rbtnp10r3 = findViewById(R.id.rbtnp10r3);
        rbtnp10r4 = findViewById(R.id.rbtnp10r4);
        rgr10 = findViewById(R.id.rgr10);

        tvpreg11 = findViewById(R.id.tvpregunta11);
        rbtnp11r1 = findViewById(R.id.rbtnp11r1);
        rbtnp11r2 = findViewById(R.id.rbtnp11r2);
        rbtnp11r3 = findViewById(R.id.rbtnp11r3);
        rbtnp11r4 = findViewById(R.id.rbtnp11r4);
        rgr11 = findViewById(R.id.rgr11);

        tvpreg12 = findViewById(R.id.tvpregunta12);
        rbtnp12r1 = findViewById(R.id.rbtnp12r1);
        rbtnp12r2 = findViewById(R.id.rbtnp12r2);
        rbtnp12r3 = findViewById(R.id.rbtnp12r3);
        rbtnp12r4 = findViewById(R.id.rbtnp12r4);
        rgr12 = findViewById(R.id.rgr12);

        tvpreg13 = findViewById(R.id.tvpregunta13);
        rbtnp13r1 = findViewById(R.id.rbtnp13r1);
        rbtnp13r2 = findViewById(R.id.rbtnp13r2);
        rbtnp13r3 = findViewById(R.id.rbtnp13r3);
        rbtnp13r4 = findViewById(R.id.rbtnp13r4);
        rgr13 = findViewById(R.id.rgr13);

        tvpreg14 = findViewById(R.id.tvpregunta14);
        rbtnp14r1 = findViewById(R.id.rbtnp14r1);
        rbtnp14r2 = findViewById(R.id.rbtnp14r2);
        rbtnp14r3 = findViewById(R.id.rbtnp14r3);
        rbtnp14r4 = findViewById(R.id.rbtnp14r4);
        rgr14 = findViewById(R.id.rgr14);

        tvpreg15 = findViewById(R.id.tvpregunta15);
        rbtnp15r1 = findViewById(R.id.rbtnp15r1);
        rbtnp15r2 = findViewById(R.id.rbtnp15r2);
        rbtnp15r3 = findViewById(R.id.rbtnp15r3);
        rbtnp15r4 = findViewById(R.id.rbtnp15r4);
        rgr15 = findViewById(R.id.rgr15);

        tvpreg16 = findViewById(R.id.tvpregunta16);
        rbtnp16r1 = findViewById(R.id.rbtnp16r1);
        rbtnp16r2 = findViewById(R.id.rbtnp16r2);
        rbtnp16r3 = findViewById(R.id.rbtnp16r3);
        rbtnp16r4 = findViewById(R.id.rbtnp16r4);
        rgr16 = findViewById(R.id.rgr16);

        tvpreg17 = findViewById(R.id.tvpregunta17);
        rbtnp17r1 = findViewById(R.id.rbtnp17r1);
        rbtnp17r2 = findViewById(R.id.rbtnp17r2);
        rbtnp17r3 = findViewById(R.id.rbtnp17r3);
        rbtnp17r4 = findViewById(R.id.rbtnp17r4);
        rgr17 = findViewById(R.id.rgr17);

        tvpreg18 = findViewById(R.id.tvpregunta18);
        rbtnp18r1 = findViewById(R.id.rbtnp18r1);
        rbtnp18r2 = findViewById(R.id.rbtnp18r2);
        rbtnp18r3 = findViewById(R.id.rbtnp18r3);
        rbtnp18r4 = findViewById(R.id.rbtnp18r4);
        rgr18 = findViewById(R.id.rgr18);

        tvpreg19 = findViewById(R.id.tvpregunta19);
        rbtnp19r1 = findViewById(R.id.rbtnp19r1);
        rbtnp19r2 = findViewById(R.id.rbtnp19r2);
        rbtnp19r3 = findViewById(R.id.rbtnp19r3);
        rbtnp19r4 = findViewById(R.id.rbtnp19r4);
        rgr19 = findViewById(R.id.rgr19);

        tvpreg20 = findViewById(R.id.tvpregunta20);
        rbtnp20r1 = findViewById(R.id.rbtnp20r1);
        rbtnp20r2 = findViewById(R.id.rbtnp20r2);
        rbtnp20r3 = findViewById(R.id.rbtnp20r3);
        rbtnp20r4 = findViewById(R.id.rbtnp20r4);
        rgr20 = findViewById(R.id.rgr20);

        tvpreg21 = findViewById(R.id.tvpregunta21);
        rbtnp21r1 = findViewById(R.id.rbtnp21r1);
        rbtnp21r2 = findViewById(R.id.rbtnp21r2);
        rbtnp21r3 = findViewById(R.id.rbtnp21r3);
        rbtnp21r4 = findViewById(R.id.rbtnp21r4);
        rgr21 = findViewById(R.id.rgr21);

        tvpreg22 = findViewById(R.id.tvpregunta22);
        rbtnp22r1 = findViewById(R.id.rbtnp22r1);
        rbtnp22r2 = findViewById(R.id.rbtnp22r2);
        rbtnp22r3 = findViewById(R.id.rbtnp22r3);
        rbtnp22r4 = findViewById(R.id.rbtnp22r4);
        rgr22 = findViewById(R.id.rgr22);

        tvpreg23 = findViewById(R.id.tvpregunta23);
        rbtnp23r1 = findViewById(R.id.rbtnp23r1);
        rbtnp23r2 = findViewById(R.id.rbtnp23r2);
        rbtnp23r3 = findViewById(R.id.rbtnp23r3);
        rbtnp23r4 = findViewById(R.id.rbtnp23r4);
        rgr23 = findViewById(R.id.rgr23);

        tvpreg24 = findViewById(R.id.tvpregunta24);
        rbtnp24r1 = findViewById(R.id.rbtnp24r1);
        rbtnp24r2 = findViewById(R.id.rbtnp24r2);
        rbtnp24r3 = findViewById(R.id.rbtnp24r3);
        rbtnp24r4 = findViewById(R.id.rbtnp24r4);
        rgr24 = findViewById(R.id.rgr24);

        tvpreg25 = findViewById(R.id.tvpregunta25);
        rbtnp25r1 = findViewById(R.id.rbtnp25r1);
        rbtnp25r2 = findViewById(R.id.rbtnp25r2);
        rbtnp25r3 = findViewById(R.id.rbtnp25r3);
        rbtnp25r4 = findViewById(R.id.rbtnp25r4);
        rgr25 = findViewById(R.id.rgr25);

        tvpreg26 = findViewById(R.id.tvpregunta26);
        rbtnp26r1 = findViewById(R.id.rbtnp26r1);
        rbtnp26r2 = findViewById(R.id.rbtnp26r2);
        rbtnp26r3 = findViewById(R.id.rbtnp26r3);
        rbtnp26r4 = findViewById(R.id.rbtnp26r4);
        rgr26 = findViewById(R.id.rgr26);

        tvpreg27 = findViewById(R.id.tvpregunta27);
        rbtnp27r1 = findViewById(R.id.rbtnp27r1);
        rbtnp27r2 = findViewById(R.id.rbtnp27r2);
        rbtnp27r3 = findViewById(R.id.rbtnp27r3);
        rbtnp27r4 = findViewById(R.id.rbtnp27r4);
        rgr27 = findViewById(R.id.rgr27);

        tvpreg28 = findViewById(R.id.tvpregunta28);
        rbtnp28r1 = findViewById(R.id.rbtnp28r1);
        rbtnp28r2 = findViewById(R.id.rbtnp28r2);
        rbtnp28r3 = findViewById(R.id.rbtnp28r3);
        rbtnp28r4 = findViewById(R.id.rbtnp28r4);
        rgr28 = findViewById(R.id.rgr28);

        tvpreg29 = findViewById(R.id.tvpregunta29);
        rbtnp29r1 = findViewById(R.id.rbtnp29r1);
        rbtnp29r2 = findViewById(R.id.rbtnp29r2);
        rbtnp29r3 = findViewById(R.id.rbtnp29r3);
        rgr29 = findViewById(R.id.rgr29);
        rbtnp29r4 = findViewById(R.id.rbtnp29r4);

        tvpreg30 = findViewById(R.id.tvpregunta30);
        rbtnp30r1 = findViewById(R.id.rbtnp30r1);
        rbtnp30r2 = findViewById(R.id.rbtnp30r2);
        rbtnp30r3 = findViewById(R.id.rbtnp30r3);
        rbtnp30r4 = findViewById(R.id.rbtnp30r4);
        rgr30 = findViewById(R.id.rgr30);
        ///////////////////////////////////////////////////


        Intent intent = getIntent();
        final String asignatura = intent.getStringExtra("asignatura");
        final String grupo = intent.getStringExtra("grupo");
        final String curso = intent.getStringExtra("curso");


        //Ruta de acceso a BD
        firebaseAuth = FirebaseAuth.getInstance();
        ref = FirebaseDatabase.getInstance("https://testeando-5374d-default-rtdb.europe-west1.firebasedatabase.app/")
                .getReference("Oposiciones").child("Galicia").child(grupo).child(curso).child(asignatura);

        //metodos
        RellenarPreguntas();
        startTimer();
        corregido = false;

        if (mTimeLeftInMillis == 0) {
            corregirp1();
            corregirp2();
            corregirp3();
            corregirp4();
            corregirp5();
            corregirp6();
            corregirp7();
            corregirp8();
            corregirp9();
            corregirp10();
            corregirp11();
            corregirp12();
            corregirp13();
            corregirp14();
            corregirp15();
            corregirp16();
            corregirp17();
            corregirp18();
            corregirp19();
            corregirp20();
            corregirp21();
            corregirp22();
            corregirp23();
            corregirp24();
            corregirp25();
            corregirp26();
            corregirp27();
            corregirp28();
            corregirp29();
            corregirp30();

            //Boton salir
            btnacabatest.setText("SALIR");
            btnacabatest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(ModeloExamen2.this, GeneralTest.class);
                    startActivity(i);
                }
            });
        }
        //Boton terminar y corregir
        btnacabatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finaliza();
                pauseTimer();
            }
        });
    }

    public void finaliza() {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String usu = mAuth.getCurrentUser().getUid();
        fStore = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();
        mStorageReference = storage.getReference();
        database = FirebaseDatabase.getInstance();
        if (corregido == false) {

            if ((rbtnp1r1.isChecked() || rbtnp1r2.isChecked() || rbtnp1r3.isChecked() ||
                    rbtnp1r4.isChecked()) &&
                    (rbtnp2r1.isChecked() || rbtnp2r2.isChecked() || rbtnp2r3.isChecked() ||
                            rbtnp2r4.isChecked()) &&
                    (rbtnp3r1.isChecked() || rbtnp3r2.isChecked() || rbtnp3r3.isChecked() ||
                            rbtnp3r4.isChecked())) {

                corregirp1();
                corregirp2();
                corregirp3();
                corregirp4();
                corregirp5();
                corregirp6();
                corregirp7();
                corregirp8();
                corregirp9();
                corregirp10();
                corregirp11();
                corregirp12();
                corregirp13();
                corregirp14();
                corregirp15();
                corregirp16();
                corregirp17();
                corregirp18();
                corregirp19();
                corregirp20();
                corregirp21();
                corregirp22();
                corregirp23();
                corregirp24();
                corregirp25();
                corregirp26();
                corregirp27();
                corregirp28();
                corregirp29();
                corregirp30();

                corregido = true;


                DocumentReference punticos = fStore.collection("users").document(usu);
                punticos.update("completados", FieldValue.increment(1));


                btnacabatest.setText("SALIR");

            } else {
                Toast.makeText(ModeloExamen2.this, "Responda a todas las preguntas", Toast.LENGTH_SHORT).show();
            }
        } else {
            //guardaresultados();
            Intent i = new Intent(ModeloExamen2.this, GeneralTest.class);
            startActivity(i);
        }

    }


    //metodos de corrección + llamada
    public void corregirp1() {

        //PREGUNTA 1

        //esto se aplica las 29 preguntas restantes

        //llamada a pregunta 1
        ref.child("p1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //objeto clase pregunta
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                //corregimos
                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    //localiza el rb seleccionado y se compara
                    RadioButton rbselected = findViewById(rgr1.getCheckedRadioButtonId());
                    int nresp = rgr1.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }

                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }

                    double nota = puntuacion;
                    //preguntas mal respondidas
                    rbtnp1r1.setTextColor(Color.RED);
                    rbtnp1r2.setTextColor(Color.RED);
                    rbtnp1r3.setTextColor(Color.RED);
                    rbtnp1r4.setTextColor(Color.RED);

                    //en caso de estar bien respondida
                    switch (n) {
                        case 1:
                            rbtnp1r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp1r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp1r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp1r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp2() {
        //PREGUNTA 1
        ref.child("p2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());
                    RadioButton rbselected = findViewById(rgr2.getCheckedRadioButtonId());
                    int nresp = rgr2.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp2r1.setTextColor(Color.RED);
                    rbtnp2r2.setTextColor(Color.RED);
                    rbtnp2r3.setTextColor(Color.RED);
                    rbtnp2r4.setTextColor(Color.RED);
                    switch (n) {
                        case 1:
                            rbtnp2r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp2r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp2r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp2r4.setTextColor(Color.GREEN);
                            break;

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp3() {
        //PREGUNTA 1
        ref.child("p3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());
                    RadioButton rbselected = findViewById(rgr3.getCheckedRadioButtonId());
                    int nresp = rgr3.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }

                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp3r1.setTextColor(Color.RED);
                    rbtnp3r2.setTextColor(Color.RED);
                    rbtnp3r3.setTextColor(Color.RED);
                    rbtnp3r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp3r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp3r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp3r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp3r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp4() {
        //PREGUNTA 1
        ref.child("p4").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());
                    RadioButton rbselected = findViewById(rgr4.getCheckedRadioButtonId());
                    int nresp = rgr4.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp4r1.setTextColor(Color.RED);
                    rbtnp4r2.setTextColor(Color.RED);
                    rbtnp4r3.setTextColor(Color.RED);
                    rbtnp4r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp4r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp4r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp4r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp4r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp5() {
        //PREGUNTA 1
        ref.child("p5").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());
                    RadioButton rbselected = findViewById(rgr5.getCheckedRadioButtonId());
                    int nresp = rgr5.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp5r1.setTextColor(Color.RED);
                    rbtnp5r2.setTextColor(Color.RED);
                    rbtnp5r3.setTextColor(Color.RED);
                    rbtnp5r4.setTextColor(Color.RED);
                    switch (n) {
                        case 1:
                            rbtnp5r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp5r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp5r3.setTextColor(Color.GREEN);
                            break;
                        case 5:
                            rbtnp5r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp6() {
        //PREGUNTA 1
        ref.child("p6").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());
                    RadioButton rbselected = findViewById(rgr6.getCheckedRadioButtonId());
                    int nresp = rgr6.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp6r1.setTextColor(Color.RED);
                    rbtnp6r2.setTextColor(Color.RED);
                    rbtnp6r3.setTextColor(Color.RED);
                    rbtnp6r4.setTextColor(Color.RED);
                    switch (n) {
                        case 1:
                            rbtnp6r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp6r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp6r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp6r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp7() {
        //PREGUNTA 1
        ref.child("p7").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());
                    RadioButton rbselected = findViewById(rgr7.getCheckedRadioButtonId());
                    int nresp = rgr7.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp7r1.setTextColor(Color.RED);
                    rbtnp7r2.setTextColor(Color.RED);
                    rbtnp7r3.setTextColor(Color.RED);
                    rbtnp7r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp7r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp7r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp7r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp7r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp8() {
        //PREGUNTA 1
        ref.child("p8").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());
                    RadioButton rbselected = findViewById(rgr8.getCheckedRadioButtonId());
                    int nresp = rgr8.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp8r1.setTextColor(Color.RED);
                    rbtnp8r2.setTextColor(Color.RED);
                    rbtnp8r3.setTextColor(Color.RED);
                    rbtnp8r4.setTextColor(Color.RED);
                    switch (n) {
                        case 1:
                            rbtnp8r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp8r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp8r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp8r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp9() {
        //PREGUNTA 1
        ref.child("p9").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());
                    RadioButton rbselected = findViewById(rgr9.getCheckedRadioButtonId());
                    int nresp = rgr9.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp9r1.setTextColor(Color.RED);
                    rbtnp9r2.setTextColor(Color.RED);
                    rbtnp9r3.setTextColor(Color.RED);
                    rbtnp9r4.setTextColor(Color.RED);
                    switch (n) {
                        case 1:
                            rbtnp9r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp9r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp9r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp9r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp10() {
        //PREGUNTA 1
        ref.child("p10").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());
                    RadioButton rbselected = findViewById(rgr10.getCheckedRadioButtonId());
                    int nresp = rgr10.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp10r1.setTextColor(Color.RED);
                    rbtnp10r2.setTextColor(Color.RED);
                    rbtnp10r3.setTextColor(Color.RED);
                    rbtnp10r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp10r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp10r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp10r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp10r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp11() {

        //PREGUNTA 1
        ref.child("p11").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr11.getCheckedRadioButtonId());
                    int nresp = rgr11.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp11r1.setTextColor(Color.RED);
                    rbtnp11r2.setTextColor(Color.RED);
                    rbtnp11r3.setTextColor(Color.RED);
                    rbtnp11r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp11r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp11r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp11r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp11r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp12() {

        //PREGUNTA 1
        ref.child("p12").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr12.getCheckedRadioButtonId());
                    int nresp = rgr12.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp12r1.setTextColor(Color.RED);
                    rbtnp12r2.setTextColor(Color.RED);
                    rbtnp12r3.setTextColor(Color.RED);
                    rbtnp12r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp11r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp11r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp11r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp12r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp13() {

        //PREGUNTA 1
        ref.child("p13").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr13.getCheckedRadioButtonId());
                    int nresp = rgr13.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp13r1.setTextColor(Color.RED);
                    rbtnp13r2.setTextColor(Color.RED);
                    rbtnp13r3.setTextColor(Color.RED);
                    rbtnp13r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp13r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp13r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp13r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp13r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp14() {

        //PREGUNTA 1
        ref.child("p14").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr14.getCheckedRadioButtonId());
                    int nresp = rgr14.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp14r1.setTextColor(Color.RED);
                    rbtnp14r2.setTextColor(Color.RED);
                    rbtnp14r3.setTextColor(Color.RED);
                    rbtnp14r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp14r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp14r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp14r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp14r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp15() {

        //PREGUNTA 1
        ref.child("p15").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr15.getCheckedRadioButtonId());
                    int nresp = rgr15.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp15r1.setTextColor(Color.RED);
                    rbtnp15r2.setTextColor(Color.RED);
                    rbtnp15r3.setTextColor(Color.RED);
                    rbtnp15r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp15r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp15r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp15r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp15r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp16() {

        //PREGUNTA 1
        ref.child("p16").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr16.getCheckedRadioButtonId());
                    int nresp = rgr16.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp16r1.setTextColor(Color.RED);
                    rbtnp16r2.setTextColor(Color.RED);
                    rbtnp16r3.setTextColor(Color.RED);
                    rbtnp16r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp16r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp16r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp16r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp16r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp17() {

        //PREGUNTA 1
        ref.child("p17").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr17.getCheckedRadioButtonId());
                    int nresp = rgr17.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp17r1.setTextColor(Color.RED);
                    rbtnp17r2.setTextColor(Color.RED);
                    rbtnp17r3.setTextColor(Color.RED);
                    rbtnp17r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp17r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp17r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp17r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp17r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp18() {

        //PREGUNTA 1
        ref.child("p18").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr18.getCheckedRadioButtonId());
                    int nresp = rgr18.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp18r1.setTextColor(Color.RED);
                    rbtnp18r2.setTextColor(Color.RED);
                    rbtnp18r3.setTextColor(Color.RED);
                    rbtnp18r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp18r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp18r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp18r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp18r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp19() {

        //PREGUNTA 1
        ref.child("p19").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr19.getCheckedRadioButtonId());
                    int nresp = rgr19.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp19r1.setTextColor(Color.RED);
                    rbtnp19r2.setTextColor(Color.RED);
                    rbtnp19r3.setTextColor(Color.RED);
                    rbtnp19r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp19r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp19r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp19r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp19r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp20() {

        //PREGUNTA 1
        ref.child("p20").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr20.getCheckedRadioButtonId());
                    int nresp = rgr20.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp20r1.setTextColor(Color.RED);
                    rbtnp20r2.setTextColor(Color.RED);
                    rbtnp20r3.setTextColor(Color.RED);
                    rbtnp20r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp20r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp20r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp20r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp20r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp21() {

        //PREGUNTA 1
        ref.child("p21").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr21.getCheckedRadioButtonId());
                    int nresp = rgr21.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp21r1.setTextColor(Color.RED);
                    rbtnp21r2.setTextColor(Color.RED);
                    rbtnp21r3.setTextColor(Color.RED);
                    rbtnp21r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp21r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp21r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp21r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp21r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp22() {

        //PREGUNTA 1
        ref.child("p22").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr22.getCheckedRadioButtonId());
                    int nresp = rgr22.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp22r1.setTextColor(Color.RED);
                    rbtnp22r2.setTextColor(Color.RED);
                    rbtnp22r3.setTextColor(Color.RED);
                    rbtnp22r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp22r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp22r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp22r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp22r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp23() {

        //PREGUNTA 1
        ref.child("p23").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr23.getCheckedRadioButtonId());
                    int nresp = rgr23.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp23r1.setTextColor(Color.RED);
                    rbtnp23r2.setTextColor(Color.RED);
                    rbtnp23r3.setTextColor(Color.RED);
                    rbtnp23r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp23r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp23r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp23r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp23r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp24() {

        //PREGUNTA 1
        ref.child("p24").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr24.getCheckedRadioButtonId());
                    int nresp = rgr24.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp24r1.setTextColor(Color.RED);
                    rbtnp24r2.setTextColor(Color.RED);
                    rbtnp24r3.setTextColor(Color.RED);
                    rbtnp24r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp24r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp24r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp24r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp24r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp25() {

        //PREGUNTA 1
        ref.child("p25").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr25.getCheckedRadioButtonId());
                    int nresp = rgr25.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp25r1.setTextColor(Color.RED);
                    rbtnp25r2.setTextColor(Color.RED);
                    rbtnp25r3.setTextColor(Color.RED);
                    rbtnp25r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp25r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp25r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp25r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp25r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp26() {

        //PREGUNTA 1
        ref.child("p26").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr26.getCheckedRadioButtonId());
                    int nresp = rgr26.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp26r1.setTextColor(Color.RED);
                    rbtnp26r2.setTextColor(Color.RED);
                    rbtnp26r3.setTextColor(Color.RED);
                    rbtnp26r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp26r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp26r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp26r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp26r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp27() {

        //PREGUNTA 1
        ref.child("p27").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr27.getCheckedRadioButtonId());
                    int nresp = rgr27.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp27r1.setTextColor(Color.RED);
                    rbtnp27r2.setTextColor(Color.RED);
                    rbtnp27r3.setTextColor(Color.RED);
                    rbtnp27r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp27r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp27r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp27r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp27r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp28() {

        //PREGUNTA 1
        ref.child("p28").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr28.getCheckedRadioButtonId());
                    int nresp = rgr28.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp28r1.setTextColor(Color.RED);
                    rbtnp28r2.setTextColor(Color.RED);
                    rbtnp28r3.setTextColor(Color.RED);
                    rbtnp28r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp28r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp28r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp28r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp28r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp29() {

        //PREGUNTA 1
        ref.child("p29").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr29.getCheckedRadioButtonId());
                    int nresp = rgr29.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }
                    rbtnp29r1.setTextColor(Color.RED);
                    rbtnp29r2.setTextColor(Color.RED);
                    rbtnp29r3.setTextColor(Color.RED);
                    rbtnp29r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp29r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp29r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp29r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp29r4.setTextColor(Color.GREEN);
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void corregirp30() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String usu = mAuth.getCurrentUser().getUid();
        fStore = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();
        mStorageReference = storage.getReference();
        database = FirebaseDatabase.getInstance();
        //PREGUNTA 1
        ref.child("p30").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                if (pregunta != null) {
                    String corr = pregunta.correcta;
                    int n = Integer.parseInt(corr.toString());

                    RadioButton rbselected = findViewById(rgr30.getCheckedRadioButtonId());
                    int nresp = rgr30.indexOfChild(rbselected) + 1;

                    if (nresp == n) {
                        puntuacion++;
                        tvpunt2.setText("" + puntuacion);
                    }
                    if (nresp != n) {

                        puntuacion = puntuacion - resta;
                        tvpunt2.setText("" + puntuacion);
                    }

                    double nota = puntuacion;
                    double aprobado = 15.0;
                    if (nota >= aprobado) {
                        DocumentReference punticos = fStore.collection("users").document(usu);
                        punticos.update("resultados", FieldValue.increment(1));
                    }
                    rbtnp30r1.setTextColor(Color.RED);
                    rbtnp30r2.setTextColor(Color.RED);
                    rbtnp30r3.setTextColor(Color.RED);
                    rbtnp30r4.setTextColor(Color.RED);

                    switch (n) {
                        case 1:
                            rbtnp30r1.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            rbtnp30r2.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            rbtnp30r3.setTextColor(Color.GREEN);
                            break;
                        case 4:
                            rbtnp30r4.setTextColor(Color.GREEN);
                            break;
                    }


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
/////////////////////////////////// FIN CORRECCION///////////////////////////////////////////////

    //RELLENO DE PREGUNTAS Y RESPUESTAS. (aplicado a las 30)
    public void RellenarPreguntas() {

        //Llamada a bd
        ref.child("p1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //objeto clase pregunta
                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);

                //Rellena el tv
                if (pregunta != null) {

                    tvpreg1 = findViewById(R.id.tvpregunta1);
                    rbtnp1r1 = findViewById(R.id.rbtnp1r1);
                    rbtnp1r2 = findViewById(R.id.rbtnp1r2);
                    rbtnp1r3 = findViewById(R.id.rbtnp1r3);
                    rgr1 = findViewById(R.id.rgr1);
                    rbtnp1r4 = findViewById(R.id.rbtnp1r4);


                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp1r4.setText(res4);
                    tvpreg1.setText(pre);
                    rbtnp1r1.setText(res1);
                    rbtnp1r2.setText(res2);
                    rbtnp1r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {


                    tvpreg2 = findViewById(R.id.tvpregunta2);
                    rbtnp2r1 = findViewById(R.id.rbtnp2r1);
                    rbtnp2r2 = findViewById(R.id.rbtnp2r2);
                    rbtnp2r3 = findViewById(R.id.rbtnp2r3);
                    rgr2 = findViewById(R.id.rgr2);
                    rbtnp2r4 = findViewById(R.id.rbtnp2r4);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;


                    tvpreg2.setText(pre);
                    rbtnp2r1.setText(res1);
                    rbtnp2r2.setText(res2);
                    rbtnp2r3.setText(res3);
                    rbtnp2r4.setText(res4);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg3 = findViewById(R.id.tvpregunta3);
                    rbtnp3r1 = findViewById(R.id.rbtnp3r1);
                    rbtnp3r2 = findViewById(R.id.rbtnp3r2);
                    rbtnp3r3 = findViewById(R.id.rbtnp3r3);
                    rgr3 = findViewById(R.id.rgr3);
                    rbtnp3r4 = findViewById(R.id.rbtnp3r4);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;


                    tvpreg3.setText(pre);
                    rbtnp3r1.setText(res1);
                    rbtnp3r2.setText(res2);
                    rbtnp3r3.setText(res3);
                    rbtnp3r4.setText(res4);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p4").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg4 = findViewById(R.id.tvpregunta4);
                    rbtnp4r1 = findViewById(R.id.rbtnp4r1);
                    rbtnp4r2 = findViewById(R.id.rbtnp4r2);
                    rbtnp4r3 = findViewById(R.id.rbtnp4r3);
                    rgr4 = findViewById(R.id.rgr4);
                    rbtnp4r4 = findViewById(R.id.rbtnp4r4);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp4r4.setText(res4);
                    tvpreg4.setText(pre);
                    rbtnp4r1.setText(res1);
                    rbtnp4r2.setText(res2);
                    rbtnp4r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p5").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg5 = findViewById(R.id.tvpregunta5);
                    rbtnp5r1 = findViewById(R.id.rbtnp5r1);
                    rbtnp5r2 = findViewById(R.id.rbtnp5r2);
                    rbtnp5r3 = findViewById(R.id.rbtnp5r3);
                    rbtnp5r4 = findViewById(R.id.rbtnp5r4);
                    rgr5 = findViewById(R.id.rgr5);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp5r4.setText(res4);
                    tvpreg5.setText(pre);
                    rbtnp5r1.setText(res1);
                    rbtnp5r2.setText(res2);
                    rbtnp5r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p6").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg6 = findViewById(R.id.tvpregunta6);
                    rbtnp6r1 = findViewById(R.id.rbtnp6r1);
                    rbtnp6r2 = findViewById(R.id.rbtnp6r2);
                    rbtnp6r3 = findViewById(R.id.rbtnp6r3);
                    rbtnp6r4 = findViewById(R.id.rbtnp6r4);
                    rgr6 = findViewById(R.id.rgr6);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp6r4.setText(res4);
                    tvpreg6.setText(pre);
                    rbtnp6r1.setText(res1);
                    rbtnp6r2.setText(res2);
                    rbtnp6r3.setText(res3);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p7").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {


                    tvpreg7 = findViewById(R.id.tvpregunta7);
                    rbtnp7r1 = findViewById(R.id.rbtnp7r1);
                    rbtnp7r2 = findViewById(R.id.rbtnp7r2);
                    rbtnp7r3 = findViewById(R.id.rbtnp7r3);
                    rbtnp7r4 = findViewById(R.id.rbtnp7r4);
                    rgr7 = findViewById(R.id.rgr7);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp7r4.setText(res4);
                    tvpreg7.setText(pre);
                    rbtnp7r1.setText(res1);
                    rbtnp7r2.setText(res2);
                    rbtnp7r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p8").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {


                    tvpreg8 = findViewById(R.id.tvpregunta8);
                    rbtnp8r1 = findViewById(R.id.rbtnp8r1);
                    rbtnp8r2 = findViewById(R.id.rbtnp8r2);
                    rbtnp8r3 = findViewById(R.id.rbtnp8r3);
                    rbtnp8r4 = findViewById(R.id.rbtnp8r4);
                    rgr8 = findViewById(R.id.rgr8);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp8r4.setText(res4);
                    tvpreg8.setText(pre);
                    rbtnp8r1.setText(res1);
                    rbtnp8r2.setText(res2);
                    rbtnp8r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p9").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg9 = findViewById(R.id.tvpregunta9);
                    rbtnp9r1 = findViewById(R.id.rbtnp9r1);
                    rbtnp9r2 = findViewById(R.id.rbtnp9r2);
                    rbtnp9r3 = findViewById(R.id.rbtnp9r3);
                    rbtnp9r4 = findViewById(R.id.rbtnp9r4);
                    rgr9 = findViewById(R.id.rgr9);


                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp9r4.setText(res4);
                    tvpreg9.setText(pre);
                    rbtnp9r1.setText(res1);
                    rbtnp9r2.setText(res2);
                    rbtnp9r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p10").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg10 = findViewById(R.id.tvpregunta10);
                    rbtnp10r1 = findViewById(R.id.rbtnp10r1);
                    rbtnp10r2 = findViewById(R.id.rbtnp10r2);
                    rbtnp10r3 = findViewById(R.id.rbtnp10r3);
                    rbtnp10r4 = findViewById(R.id.rbtnp10r4);
                    rgr10 = findViewById(R.id.rgr10);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp10r4.setText(res4);
                    tvpreg10.setText(pre);
                    rbtnp10r1.setText(res1);
                    rbtnp10r2.setText(res2);
                    rbtnp10r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p11").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;


                    tvpreg11 = findViewById(R.id.tvpregunta11);
                    rbtnp11r1 = findViewById(R.id.rbtnp11r1);
                    rbtnp11r2 = findViewById(R.id.rbtnp11r2);
                    rbtnp11r3 = findViewById(R.id.rbtnp11r3);
                    rbtnp11r4 = findViewById(R.id.rbtnp11r4);
                    rgr11 = findViewById(R.id.rgr11);

                    tvpreg11.setText(pre);
                    rbtnp11r1.setText(res1);
                    rbtnp11r2.setText(res2);
                    rbtnp11r3.setText(res3);
                    rbtnp11r4.setText(res4);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p12").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg12 = findViewById(R.id.tvpregunta12);
                    rbtnp12r1 = findViewById(R.id.rbtnp12r1);
                    rbtnp12r2 = findViewById(R.id.rbtnp12r2);
                    rbtnp12r3 = findViewById(R.id.rbtnp12r3);
                    rbtnp12r4 = findViewById(R.id.rbtnp12r4);
                    rgr12 = findViewById(R.id.rgr12);
                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp12r4.setText(res4);
                    tvpreg12.setText(pre);
                    rbtnp12r1.setText(res1);
                    rbtnp12r2.setText(res2);
                    rbtnp12r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p13").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {
                    tvpreg13 = findViewById(R.id.tvpregunta13);
                    rbtnp13r1 = findViewById(R.id.rbtnp13r1);
                    rbtnp13r2 = findViewById(R.id.rbtnp13r2);
                    rbtnp13r3 = findViewById(R.id.rbtnp13r3);
                    rbtnp13r4 = findViewById(R.id.rbtnp13r4);
                    rgr13 = findViewById(R.id.rgr13);
                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp13r4.setText(res4);
                    tvpreg13.setText(pre);
                    rbtnp13r1.setText(res1);
                    rbtnp13r2.setText(res2);
                    rbtnp13r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p14").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {
                    tvpreg14 = findViewById(R.id.tvpregunta14);
                    rbtnp14r1 = findViewById(R.id.rbtnp14r1);
                    rbtnp14r2 = findViewById(R.id.rbtnp14r2);
                    rbtnp14r3 = findViewById(R.id.rbtnp14r3);
                    rbtnp14r4 = findViewById(R.id.rbtnp14r4);
                    rgr14 = findViewById(R.id.rgr14);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp14r4.setText(res4);
                    tvpreg14.setText(pre);
                    rbtnp14r1.setText(res1);
                    rbtnp14r2.setText(res2);
                    rbtnp14r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p15").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {
                    tvpreg15 = findViewById(R.id.tvpregunta15);
                    rbtnp15r1 = findViewById(R.id.rbtnp15r1);
                    rbtnp15r2 = findViewById(R.id.rbtnp15r2);
                    rbtnp15r3 = findViewById(R.id.rbtnp15r3);
                    rbtnp15r4 = findViewById(R.id.rbtnp15r4);
                    rgr15 = findViewById(R.id.rgr15);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp15r4.setText(res4);
                    tvpreg15.setText(pre);
                    rbtnp15r1.setText(res1);
                    rbtnp15r2.setText(res2);
                    rbtnp15r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p16").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {
                    tvpreg16 = findViewById(R.id.tvpregunta16);
                    rbtnp16r1 = findViewById(R.id.rbtnp16r1);
                    rbtnp16r2 = findViewById(R.id.rbtnp16r2);
                    rbtnp16r3 = findViewById(R.id.rbtnp16r3);
                    rbtnp16r4 = findViewById(R.id.rbtnp16r4);
                    rgr16 = findViewById(R.id.rgr16);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp16r4.setText(res4);
                    tvpreg16.setText(pre);
                    rbtnp16r1.setText(res1);
                    rbtnp16r2.setText(res2);
                    rbtnp16r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p17").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg17 = findViewById(R.id.tvpregunta17);
                    rbtnp17r1 = findViewById(R.id.rbtnp17r1);
                    rbtnp17r2 = findViewById(R.id.rbtnp17r2);
                    rbtnp17r3 = findViewById(R.id.rbtnp17r3);
                    rbtnp17r4 = findViewById(R.id.rbtnp17r4);
                    rgr17 = findViewById(R.id.rgr17);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp17r4.setText(res4);
                    tvpreg17.setText(pre);
                    rbtnp17r1.setText(res1);
                    rbtnp17r2.setText(res2);
                    rbtnp17r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p18").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg18 = findViewById(R.id.tvpregunta18);
                    rbtnp18r1 = findViewById(R.id.rbtnp18r1);
                    rbtnp18r2 = findViewById(R.id.rbtnp18r2);
                    rbtnp18r3 = findViewById(R.id.rbtnp18r3);
                    rbtnp18r4 = findViewById(R.id.rbtnp18r4);
                    rgr18 = findViewById(R.id.rgr18);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp18r4.setText(res4);
                    tvpreg18.setText(pre);
                    rbtnp18r1.setText(res1);
                    rbtnp18r2.setText(res2);
                    rbtnp18r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p19").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg19 = findViewById(R.id.tvpregunta19);
                    rbtnp19r1 = findViewById(R.id.rbtnp19r1);
                    rbtnp19r2 = findViewById(R.id.rbtnp19r2);
                    rbtnp19r3 = findViewById(R.id.rbtnp19r3);
                    rbtnp19r4 = findViewById(R.id.rbtnp19r4);
                    rgr19 = findViewById(R.id.rgr19);


                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp19r4.setText(res4);
                    tvpreg19.setText(pre);
                    rbtnp19r1.setText(res1);
                    rbtnp19r2.setText(res2);
                    rbtnp19r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p20").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg20 = findViewById(R.id.tvpregunta20);
                    rbtnp20r1 = findViewById(R.id.rbtnp20r1);
                    rbtnp20r2 = findViewById(R.id.rbtnp20r2);
                    rbtnp20r3 = findViewById(R.id.rbtnp20r3);
                    rbtnp20r4 = findViewById(R.id.rbtnp20r4);
                    rgr20 = findViewById(R.id.rgr20);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp20r4.setText(res4);
                    tvpreg20.setText(pre);
                    rbtnp20r1.setText(res1);
                    rbtnp20r2.setText(res2);
                    rbtnp20r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p21").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg21 = findViewById(R.id.tvpregunta21);
                    rbtnp21r1 = findViewById(R.id.rbtnp21r1);
                    rbtnp21r2 = findViewById(R.id.rbtnp21r2);
                    rbtnp21r3 = findViewById(R.id.rbtnp21r3);
                    rbtnp21r4 = findViewById(R.id.rbtnp21r4);
                    rgr21 = findViewById(R.id.rgr21);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp21r4.setText(res4);
                    tvpreg21.setText(pre);
                    rbtnp21r1.setText(res1);
                    rbtnp21r2.setText(res2);
                    rbtnp21r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p22").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg22 = findViewById(R.id.tvpregunta22);
                    rbtnp22r1 = findViewById(R.id.rbtnp22r1);
                    rbtnp22r2 = findViewById(R.id.rbtnp22r2);
                    rbtnp22r3 = findViewById(R.id.rbtnp22r3);
                    rbtnp22r4 = findViewById(R.id.rbtnp22r4);
                    rgr22 = findViewById(R.id.rgr22);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp22r4.setText(res4);
                    tvpreg22.setText(pre);
                    rbtnp22r1.setText(res1);
                    rbtnp22r2.setText(res2);
                    rbtnp22r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p23").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {


                    tvpreg23 = findViewById(R.id.tvpregunta23);
                    rbtnp23r1 = findViewById(R.id.rbtnp23r1);
                    rbtnp23r2 = findViewById(R.id.rbtnp23r2);
                    rbtnp23r3 = findViewById(R.id.rbtnp23r3);
                    rbtnp23r4 = findViewById(R.id.rbtnp23r4);
                    rgr23 = findViewById(R.id.rgr23);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp23r4.setText(res4);
                    tvpreg23.setText(pre);
                    rbtnp23r1.setText(res1);
                    rbtnp23r2.setText(res2);
                    rbtnp23r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p24").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {


                    tvpreg24 = findViewById(R.id.tvpregunta24);
                    rbtnp24r1 = findViewById(R.id.rbtnp24r1);
                    rbtnp24r2 = findViewById(R.id.rbtnp24r2);
                    rbtnp24r3 = findViewById(R.id.rbtnp24r3);
                    rbtnp24r4 = findViewById(R.id.rbtnp24r4);
                    rgr24 = findViewById(R.id.rgr24);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp24r4.setText(res4);
                    tvpreg24.setText(pre);
                    rbtnp24r1.setText(res1);
                    rbtnp24r2.setText(res2);
                    rbtnp24r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p25").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {


                    tvpreg25 = findViewById(R.id.tvpregunta25);
                    rbtnp25r1 = findViewById(R.id.rbtnp25r1);
                    rbtnp25r2 = findViewById(R.id.rbtnp25r2);
                    rbtnp25r3 = findViewById(R.id.rbtnp25r3);
                    rbtnp25r4 = findViewById(R.id.rbtnp25r4);
                    rgr25 = findViewById(R.id.rgr25);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp25r4.setText(res4);
                    tvpreg25.setText(pre);
                    rbtnp25r1.setText(res1);
                    rbtnp25r2.setText(res2);
                    rbtnp25r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p26").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg26 = findViewById(R.id.tvpregunta26);
                    rbtnp26r1 = findViewById(R.id.rbtnp26r1);
                    rbtnp26r2 = findViewById(R.id.rbtnp26r2);
                    rbtnp26r3 = findViewById(R.id.rbtnp26r3);
                    rbtnp26r4 = findViewById(R.id.rbtnp26r4);
                    rgr26 = findViewById(R.id.rgr26);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp26r4.setText(res4);
                    tvpreg26.setText(pre);
                    rbtnp26r1.setText(res1);
                    rbtnp26r2.setText(res2);
                    rbtnp26r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p27").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg27 = findViewById(R.id.tvpregunta27);
                    rbtnp27r1 = findViewById(R.id.rbtnp27r1);
                    rbtnp27r2 = findViewById(R.id.rbtnp27r2);
                    rbtnp27r3 = findViewById(R.id.rbtnp27r3);
                    rbtnp27r4 = findViewById(R.id.rbtnp27r4);
                    rgr27 = findViewById(R.id.rgr27);


                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp27r4.setText(res4);
                    tvpreg27.setText(pre);
                    rbtnp27r1.setText(res1);
                    rbtnp27r2.setText(res2);
                    rbtnp27r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p28").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg28 = findViewById(R.id.tvpregunta28);
                    rbtnp28r1 = findViewById(R.id.rbtnp28r1);
                    rbtnp28r2 = findViewById(R.id.rbtnp28r2);
                    rbtnp28r3 = findViewById(R.id.rbtnp28r3);
                    rbtnp28r4 = findViewById(R.id.rbtnp28r4);
                    rgr28 = findViewById(R.id.rgr28);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp28r4.setText(res4);
                    tvpreg28.setText(pre);
                    rbtnp28r1.setText(res1);
                    rbtnp28r2.setText(res2);
                    rbtnp28r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p29").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {

                    tvpreg29 = findViewById(R.id.tvpregunta29);
                    rbtnp29r1 = findViewById(R.id.rbtnp29r1);
                    rbtnp29r2 = findViewById(R.id.rbtnp29r2);
                    rbtnp29r3 = findViewById(R.id.rbtnp29r3);
                    rgr29 = findViewById(R.id.rgr29);
                    rbtnp29r4 = findViewById(R.id.rbtnp29r4);


                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp29r4.setText(res4);
                    tvpreg29.setText(pre);
                    rbtnp29r1.setText(res1);
                    rbtnp29r2.setText(res2);
                    rbtnp29r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("p30").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                PreguntaHandler pregunta = snapshot.getValue(PreguntaHandler.class);
                if (pregunta != null) {


                    tvpreg30 = findViewById(R.id.tvpregunta30);
                    rbtnp30r1 = findViewById(R.id.rbtnp30r1);
                    rbtnp30r2 = findViewById(R.id.rbtnp30r2);
                    rbtnp30r3 = findViewById(R.id.rbtnp30r3);
                    rbtnp30r4 = findViewById(R.id.rbtnp30r4);
                    rgr30 = findViewById(R.id.rgr30);

                    String pre = pregunta.pregunta;
                    String res1 = pregunta.resp1;
                    String res2 = pregunta.resp2;
                    String res3 = pregunta.resp3;
                    String res4 = pregunta.resp4;

                    rbtnp30r4.setText(res4);
                    tvpreg30.setText(pre);
                    rbtnp30r1.setText(res1);
                    rbtnp30r2.setText(res2);
                    rbtnp30r3.setText(res3);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    //CRONOMETRO / CUENTA ATRAS
    public void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
            }
        }.start();
        mTimerRunning = true;
    }

    public void updateCountDownText() {

        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        crono.setText(timeLeftFormatted);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
    }


}