package com.example.Testeando.activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Testeando.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;


public class Perfil extends AppCompatActivity {

    private ImageView fotoperfil;
    private TextInputEditText edtnombre, edtmail, edttelf;
    private Button upload,buscar;
    private TextView tvmail, tvNombre;
    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    public Uri imageUri;
    private FirebaseStorage storage;
    private StorageReference mStorageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        firebaseAuth = FirebaseAuth.getInstance();
        fotoperfil = findViewById(R.id.imagenperfil);
        edtnombre = findViewById(R.id.nameprofile);
        edtmail = findViewById(R.id.mailprofile);
        edttelf = findViewById(R.id.telefperfil);
        tvmail = findViewById(R.id.tvMail);
        tvNombre = findViewById(R.id.tvNombre);
        upload = findViewById(R.id.btnupload);
        buscar =  findViewById(R.id.btnmodif);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String usu = mAuth.getCurrentUser().getUid();
        fStore= FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();
        mStorageReference = storage.getReference();
        database = FirebaseDatabase.getInstance();




        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CropImage.activity().start(Perfil.this);

               /* Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);*/

            }
        });

    upload.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        cambiarimagen();
    }
    });

        fStore.collection("users").document(usu)
                //extraigo info del doc
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();

                if (document.exists()) {
                    String correo = document.getString("correo");
                    String name = document.getString("nombre");
                    String telefo = document.getString("telef");
                    tvNombre.setText(name);
                    tvmail.setText(correo);
                    edtnombre.setText(name);
                    edtmail.setText(correo);
                    edttelf.setText(telefo);
          }

            }
        });


        mStorageReference.child("imagen/"+usu).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(Perfil.this).load(uri).fit().centerCrop().into(fotoperfil);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {

            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK) {
                imageUri = result.getUri();
                fotoperfil.setImageURI(imageUri);
            } else {
                Toast.makeText(Perfil.this, "Por favor, seleccione una imagen", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void cambiarimagen() {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String usu = mAuth.getCurrentUser().getUid();
        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Guardando tu imagen...");
        pd.show();

        //codigo para subir imagen
        StorageReference refs = mStorageReference.child("imagen/"+usu);
        refs.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                pd.dismiss();
                Snackbar.make(findViewById(R.id.imagenperfil), "Imagen subida", Snackbar.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(Perfil.this, "Error al subir la imagen",Toast.LENGTH_LONG).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                double progresspercent = (100.00 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                pd.setMessage("Progreso: "+ (int) progresspercent + "%");
            }
        });


    }

}




