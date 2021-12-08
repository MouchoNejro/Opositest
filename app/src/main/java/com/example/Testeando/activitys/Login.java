package com.example.Testeando.activitys;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Testeando.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    EditText edtcorreo2, edtpass2;
    Button btniniciar, btnnuevouser, btnrecuperar;
    //notificacion de progreso
    private ProgressDialog progressDialog;
    //creo objeto firebaseauth
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private CheckBox cbRecuerdame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicia_sesion);

        cbRecuerdame = findViewById(R.id.cbRecuerdame);
        btnrecuperar = findViewById(R.id.btnrecuperar);
        btnnuevouser = findViewById(R.id.btnHaciaRegistro);
        btniniciar = findViewById(R.id.btninicia);
        edtcorreo2 = findViewById(R.id.edtcorreo2);
        edtpass2 = findViewById(R.id.edtpass2);

        //inicializo el objeto firebaseauth
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        btniniciar.setOnClickListener(view ->{Login();

        edtcorreo2.setText("");
        edtpass2.setText("");
        });

        btnnuevouser.setOnClickListener(v -> {
            Intent i2 = new Intent(Login.this, Registro.class);
            startActivity(i2); });

        //CODIGO OLVIDAR CONTRASEÑA
        btnrecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText resetMail = new EditText(view.getContext());
                resetMail.setHint("Escribe aquí el correo con el que te registraste");
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("¿Has olvidado tu contraseña?");
                passwordResetDialog.setMessage("Introduce tu correo si quieres recibir\n" +
                        "el enlace para cambiarla");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String mail = resetMail.getText().toString();
                        firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(@NonNull Void unused) {
                                Toast.makeText(Login.this,
                                        "Enlace enviado al correo\n" + mail, Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this,
                                        "¡Error! No existe nigún usuario con ese correo", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                passwordResetDialog.create().show();
            }
        });

        //codigo para comprobar si guardo su cuenta
        SharedPreferences preferences = getSharedPreferences("cbRecuerdame", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        if (checkbox.equals("true")) {
            Intent i2 = new Intent(Login.this, GeneralTest.class);
            startActivity(i2);
        } else if (checkbox.equals("false")) {
            Toast.makeText(Login.this, "Por favor inicie sesion.", Toast.LENGTH_SHORT).show();
        }

        //CODIGO PARA RECORDAR CUENTA
        cbRecuerdame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("cbRecuerdame", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                } else if (!compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("cbRecuerdame", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                }
            }
        });
    }

//metodo para login
    private void Login() {

        //recogemos la info de las cajas de texto
        String correo = edtcorreo2.getText().toString().trim();
        String contrasena = edtpass2.getText().toString().trim();
        //String nombre= edtusu.getEditText().getText().toString().trim();

        if (!validaMail() | !validaPassword()) {
            return;
        }
        progressDialog.setMessage("Iniciando sesión");
        progressDialog.show();

        //Loguear usuario
        firebaseAuth.signInWithEmailAndPassword(correo, contrasena).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                   /* firebaseUser = firebaseAuth.getCurrentUser();
                    String userID = firebaseUser.getUid();

                    if(userID.equals("pKfcKyzgrdhbP6Yu5ITG0ZHqgvf2")){

                        Toast.makeText(Login.this, "¡Bienvenido Jefe", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, Admin.class);
                        startActivity(intent);
                    }
                     else  {*/
                        Toast.makeText(Login.this, "¡Nos alegramos de verte", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, GeneralTest.class);
                        startActivity(intent);
                    //}

                } else {
                    Toast.makeText(Login.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }

                progressDialog.dismiss();
            }
        });

    }

    //metodos de control de entrada de datos
    private boolean validaMail() {
        // Extract de mail
        String emailInput = edtcorreo2.getText().toString().trim();
        // si campo vacio
        if (emailInput.isEmpty()) {
            edtcorreo2.setError("No puedes dejar un campo vacío");
            return false;
        }
        // comparacion de mail con mails predefinidos
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            edtcorreo2.setError("Por favor introduzca un email valido");
            return false;
        } else {
            edtcorreo2.setError(null);
            return true;
        }
    }

    private boolean validaPassword() {
        String passwordInput = edtpass2.getText().toString().trim();

        // si esta vacío sale mensaje
        if (passwordInput.isEmpty()) {
            edtpass2.setError("No puedes dejar un campo vacío");
            return false;
        } else {
            edtpass2.setError(null);
            return true;
        }
    }


}

