package com.example.Testeando.activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Testeando.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class Registro extends AppCompatActivity {

    //declaración de variables.
    private TextInputLayout edtcorreo, edtpass, edtconfpass, edttelef;
    private TextInputEditText edtusu;
    private Button btnregis, btnhacialogin;
    private ProgressDialog progressDialog;
    private ImageView volver;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ref;
    private FirebaseDatabase database;
    private String validamail;
    private FirebaseFirestore fStore;
    private CheckBox ckAlum, ckProfe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //referencio los views
        edtcorreo = findViewById(R.id.edtcorreo);
        edtpass = findViewById(R.id.edtpass);
        edtconfpass = findViewById(R.id.edtconfpass);
        btnregis = findViewById(R.id.btnregis);
        btnhacialogin = findViewById(R.id.btnhacialogin);
        volver = findViewById(R.id.volver);
        edtusu = findViewById(R.id.edtnombrecompleto);
        edttelef = findViewById(R.id.edttelef);
        ckAlum = findViewById(R.id.checkboxAlumno);
        ckProfe = findViewById(R.id.checkboxProfe);

        //instancia de firebase
        firebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        //mensaje progreso en esta activity
        progressDialog = new ProgressDialog(this);

        controlAcceso();

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registro();

            }
        });

        //si el usuario tiene cuenta puede acceder al login
        btnhacialogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registro.this, Login.class);
                startActivity(i);
            }
        });

        //boton volver (flecha atras)
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registro.this, MainActivity.class);
                startActivity(i);
            }
        });

        ckAlum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ckProfe.setChecked(false);
                }
            }
        });
        ckProfe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ckAlum.setChecked(false);
                }
            }
        });
    }

    //metodo registro
    private void registro() {

        //recogemos la info de las cajas de texto
        String correo = edtcorreo.getEditText().getText().toString().trim();
        String contrasena = edtpass.getEditText().getText().toString().trim();
        String nombre = edtusu.getText().toString().trim();
        String telef = edttelef.getEditText().getText().toString().trim();

        // Validación general de los datos introducidos
        if (!validaMail() |  !confirmaPassword() | !validatelef()) {
            return;
        }


        if(validaPassword() == false){
            Toast.makeText(Registro.this, "La contraseña debe de tener 6 caracteres, una mayuscula y una minuscula.", Toast.LENGTH_LONG).show();
        }else{

        }



        //Notificación mientras se hace el registro
        progressDialog.setMessage("Registro en proceso");
        progressDialog.show();


        //LLamada a firebase para registro con correo y contrasena (se guardan los datos paas/mail en la base "normal" de firebase)
        firebaseAuth.createUserWithEmailAndPassword(correo, contrasena).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //si la tarea es exitosa procedemos al registro.
                if (task.isSuccessful()) {

                    FirebaseUser user = firebaseAuth.getCurrentUser();

                    String usuario = user.getUid();
                    //Si el registro es exitoso salta un toast
                    Toast.makeText(Registro.this, "Registro realizado con éxito", Toast.LENGTH_SHORT).show();
                    DocumentReference df = fStore.collection("users").document(usuario);
                    Map<String, Object> userInfo = new HashMap<>();
                    userInfo.put("nombre", nombre);
                    userInfo.put("correo", correo);
                    userInfo.put("telef", telef);
                    //especificar si el usuario es admin
                    if (ckAlum.isChecked()) {
                        userInfo.put("alumno", "1");
                    }
                    if (ckProfe.isChecked()) {
                        userInfo.put("profesor", "1");
                    }
                    if
                    (!ckProfe.isChecked() && !ckAlum.isChecked()) {
                        userInfo.put("alumno", "1");
                    }
                    df.set(userInfo);


                  /*  //aquí añado datos a la base de realtime (no añado contraseñas por seguridad) pero si otros datos con id autogenerada.
                    //en primer lugar se instancia la direccion de la base
                    database = FirebaseDatabase.getInstance("https://opositest-1d361-default-rtdb.europe-west1.firebasedatabase.app");
                    //en segundo lugar seleccionamos la tabla
                    ref = database.getReference("users");
                    //enviamos los datos que queremos conservar
                    UserHandler user2 = new UserHandler(correo, nombre, telef);

                    ref.child(firebaseAuth.getUid()).setValue(user2);

                    FirebaseAuth.getInstance().signOut(); */
                    //abrimos la nueva activity

                    //********notas para modif en bd**********************

                    //generamos el telef como id unica.
                    //ref.child(telef).setValue(user);
                    //con .push() genero una id unica para cada usuario
                    //ref.push().setValue(user);
                    //con uidFromAuthentication pongo en ambas base la misma id

                    //******** fin notas para modif en bd**********************
                } else {
                    //si hay una "colision" (datos repetidos en la base)
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {

                        Toast.makeText(Registro.this, "Este correo ya está registrado", Toast.LENGTH_SHORT).show();

                    } else {

                        //Si se produce algún tipo de error
                        Toast.makeText(Registro.this, "No se pudo completar el registro", Toast.LENGTH_SHORT).show();
                    }
                }

                progressDialog.dismiss();
            }
        });
    }

    //Control de entrada de datos para el correo
    private boolean validaMail() {
        // Extract de mail
        String emailInput = edtcorreo.getEditText().getText().toString().trim();
        // si campo vacio
        if (emailInput.isEmpty()) {
            edtcorreo.setError("No puedes dejar un campo vacío");
            return false;
        }
        // comparacion de mail con mails predefinidos
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            edtcorreo.setError("Por favor introduzca un email valido");
            return false;
        } else {
            edtcorreo.setError(null);
            return true;
        }
    }

    private boolean validatelef() {
        // Extract de telef
        String phoneimput = edttelef.getEditText().getText().toString().trim();
        // si campo vacio
        if (phoneimput.isEmpty()) {
            edtcorreo.setError("No puedes dejar un campo vacío");
            return false;
        } else {
            edtcorreo.setError(null);
            return true;
        }
    }

    //Control de entrada de datos para la contraseña
    private boolean validaPassword() {
        String passwordInput = edtpass.getEditText().getText().toString().trim();

        // si esta vacío sale mensaje
        if (passwordInput.isEmpty()) {
            edtpass.setError("No puedes dejar un campo vacío");
            return false;
        }

        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");

        boolean flag=true;

        if (passwordInput.length() < 6) {
            flag=false;
        }
        if (!UpperCasePatten.matcher(passwordInput).find()) {
            flag=false;
        }
        if (!lowerCasePatten.matcher(passwordInput).find()) {
            flag=false;
        }
        if (!digitCasePatten.matcher(passwordInput).find()) {
            flag=false;
        }
        return flag;
    }


    //Verificación de que la contraseña está correctamente escrita
    private boolean confirmaPassword() {

        String passwordInput2 = edtconfpass.getEditText().getText().toString().trim();
        // si esta vacío sale mensaje
        if (passwordInput2.isEmpty()) {
            edtconfpass.setError("No puedes dejar un campo vacío");
            return false;
        }

        // Si no coinciden sale mensaje
        if (!edtconfpass.getEditText().getText().toString().equals(edtpass.getEditText().getText().toString())) {
            edtconfpass.setError("Las contraseñas no coinciden");
            return false;
        } else {
            edtconfpass.setError(null);
            return true;
        }

    }

    private void controlAcceso() {
        Intent intent = getIntent();
        final String uid = intent.getStringExtra("id");

        if (uid != null) {

            DocumentReference df = fStore.collection("users").document(uid);
            //extraigo info del docu
            df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(@NonNull DocumentSnapshot documentSnapshot) {
                    Log.d("TAG", "exito: " + documentSnapshot.getData());
                    //identifación de rol de acceso

                    if (documentSnapshot.getString("admin") != null) {
                        //usuario es administrador
                        ckAlum.setVisibility(View.VISIBLE);
                        ckProfe.setVisibility(View.VISIBLE);
                        String nombre = documentSnapshot.getString("nombre");
                        Toast.makeText(Registro.this, "¡Bienvenido " + nombre, Toast.LENGTH_SHORT).show();
                    }
                    if (documentSnapshot.getString("alumno") != null) {
                        //usuario es alumno
                        String nombre = documentSnapshot.getString("nombre");
                        Toast.makeText(Registro.this, "¡Bienvenido " + nombre, Toast.LENGTH_SHORT).show();
                    }
                    if (documentSnapshot.getString("profesor") != null) {
                        //usuario es alumno
                        ckAlum.setVisibility(View.VISIBLE);
                        ckProfe.setVisibility(View.VISIBLE);
                        String nombre = documentSnapshot.getString("nombre");
                        Toast.makeText(Registro.this, "¡Bienvenido " + nombre, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}


