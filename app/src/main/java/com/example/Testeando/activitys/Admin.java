package com.example.Testeando.activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Testeando.R;
import com.example.Testeando.javaclass.CreaPreguntasHandler;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class Admin extends AppCompatActivity {

    private int r;
    private String id="", comuni="", grup="", oposi="",numpregunta="";
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ref;
    private FirebaseDatabase database;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private final int IMG_REQUEST_ID = 11;
    private Uri imgUri;
    private ImageView imgView;
    private Button btnsubirImagen, btnsBuscarImagen, excel, btnsubir;
    public static final int cellCount = 11;
    private EditText edtcorrecta, edtrespuesta3,edtrespuesta4, edtrespuesta2, edtresp, edtpregunta, edtNumPregun, edtasignatura,edtgrupo, edtcategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        edtasignatura = findViewById(R.id.edtasignatura);
        edtNumPregun = findViewById(R.id.edtNumPregun);
        edtpregunta = findViewById(R.id.edtpregunta);
        edtresp = findViewById(R.id.edtresp);
        edtrespuesta2 = findViewById(R.id.edtrespuesta2);
        edtrespuesta3 = findViewById(R.id.edtrespuesta3);
        edtrespuesta4=findViewById(R.id.edtrespuesta4);
        edtcorrecta = findViewById(R.id.edtcorrecta);
        btnsubir = findViewById(R.id.btnsubir);
        edtgrupo=findViewById(R.id.edtgrupo);
        edtcategoria=findViewById(R.id.edtcatego);
        excel = findViewById(R.id.excel);


        firebaseAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();


        //meter preguntas a mano en la bd
        btnsubir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String grupo = edtgrupo.getText().toString().trim();
                if(grupo.isEmpty()) {
                    edtgrupo.setError("El campo no puede estar vacío");
                    return;
                }

                String categoria = edtcategoria.getText().toString().trim();
                if(categoria.isEmpty()) {
                    edtcategoria.setError("El campo no puede estar vacío");
                    return;
                }

                String asignatura = edtasignatura.getText().toString().trim();
                if(asignatura.isEmpty()) {
                    edtasignatura.setError("El campo no puede estar vacío");
                    return;
                }
                String numpregun = edtNumPregun.getText().toString().trim();
                if(numpregun.isEmpty()) {
                    edtNumPregun.setError("El campo no puede estar vacío");
                    return;
                }
                String pregunta = edtpregunta.getText().toString().trim();
                if(pregunta.isEmpty()) {
                    edtpregunta.setError("El campo no puede estar vacío");
                    return;
                }
                String resp1 = edtresp.getText().toString().trim();
                if(resp1.isEmpty()) {
                    edtresp.setError("El campo no puede estar vacío");
                    return;
                }
                String resp2 = edtrespuesta2.getText().toString().trim();
                if(resp2.isEmpty()) {
                    edtrespuesta2.setError("El campo no puede estar vacío");
                    return;
                }
                String resp3 = edtrespuesta3.getText().toString().trim();
                if(resp3.isEmpty()) {
                    edtrespuesta3.setError("El campo no puede estar vacío");
                    return;
                }

                String resp4 = edtrespuesta4.getText().toString().trim();
                if(resp4.isEmpty()) {
                    edtrespuesta4.setError("El campo no puede estar vacío");
                    return;
                }

                String correcta = edtcorrecta.getText().toString().trim();
                if(correcta.isEmpty()) {
                    edtcorrecta.setError("El campo no puede estar vacío");
                    return;
                }

                database = FirebaseDatabase.getInstance("https://testeando-5374d-default-rtdb.europe-west1.firebasedatabase.app/");
                ref = database.getReference("Oposiciones").child("Galicia");
                CreaPreguntasHandler creapregunta = new CreaPreguntasHandler(asignatura,pregunta, resp1, resp2, resp3,resp4, correcta);
                ref.child(grupo).child(categoria).child(asignatura).child(numpregun).setValue(creapregunta);

                edtgrupo.setText("");
                edtcategoria.setText("");
                edtasignatura.setText("");
                edtNumPregun.setText("");
                edtresp.setText("");
                edtrespuesta2.setText("");
                edtrespuesta3.setText("");
                edtrespuesta4.setText("");
                edtcorrecta.setText("");
                edtpregunta.setText("");


            }
        });



        excel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


           selectfile();

            }
        });


    }//**************************************FIN ON CREATE****************************************

    //***************************************METODOS EXCELL***************************************




    private void selectfile() {
        // seleccion de archivo desde el almacenamiento
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "Seleccione archivo"), 102);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 102) {
            if (resultCode == RESULT_OK) {

                if (data != null) {
                    readfile(data.getData());
                }

            }
        }
    }

    ProgressDialog dialog;

    private void readfile(final Uri file) {
        dialog = new ProgressDialog(this);
        dialog.setMessage("Cargando datos");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                final Map<String, Object> map1 = new HashMap<String, Object>();

                try {
                    XSSFWorkbook workbook;

                    // Se comprueba al info

                    try (InputStream inputStream = getContentResolver().openInputStream(file)) {
                        workbook = new XSSFWorkbook(inputStream);
                    }

                    XSSFSheet sheet = workbook.getSheetAt(0);
                    FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
                    int recount = sheet.getPhysicalNumberOfRows();

                    if (recount > 0) {
                        // chequeo de las columnas
                        for (r = 0; r < recount; r++) {
                            Row row = sheet.getRow(r);
                            if (row.getPhysicalNumberOfCells() == cellCount) {

                                // se saca la info de las celdas
                                String ca = getCellData(row, 0, formulaEvaluator);
                                String grupo = getCellData(row, 1, formulaEvaluator);
                                String opo = getCellData(row, 2, formulaEvaluator);
                                String asignatura = getCellData(row, 3, formulaEvaluator);
                                String numpregun = getCellData(row, 4, formulaEvaluator);
                                String pregunta = getCellData(row, 5, formulaEvaluator);
                                String resp1 = getCellData(row, 6, formulaEvaluator);
                                String resp2 = getCellData(row, 7, formulaEvaluator);
                                String resp3 = getCellData(row, 8, formulaEvaluator);
                                String resp4 = getCellData(row, 9, formulaEvaluator);
                                String correcta = getCellData(row, 10, formulaEvaluator);


                                // inicializo hashmap y le meto los valores antes extraidos

                                HashMap<String, Object> map2 = new HashMap<>();

                                map2.put("pregunta", pregunta);
                                map2.put("resp1", resp1);
                                map2.put("resp2", resp2);
                                map2.put("resp3", resp3);
                                map2.put("resp4",resp4);
                                map2.put("correcta", correcta);
                                map2.put("asignatura",asignatura);
                                map2.put("pregunta",pregunta);

                                //genero una id para la bd
                                comuni = ca.toString();
                                grup = grupo.toString();
                                oposi = opo.toString();
                                id = asignatura.toString();
                                numpregunta=numpregun.toString();
                                map1.put(numpregun,map2);
                            }
                        }



                   /*     //Si todo ha ido bien se añade la info a la bd
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                fStore= FirebaseFirestore.getInstance();
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                //se añade a la bd, preguntas-->hashmap-->id-->laspreguntas
                                fStore.collection("Examenes").document(id).set(map1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            dialog.dismiss();
                                            Toast.makeText(Admin.this, "Añadido con exito", Toast.LENGTH_LONG).show();
                                        } else {
                                            dialog.dismiss();
                                            Toast.makeText(Admin.this, "Vaya, algo ha salido mal", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        }); */

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                //se añade a la bd, preguntas-->hashmap-->id-->laspreguntas
                                FirebaseDatabase.getInstance("https://testeando-5374d-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Oposiciones").
                                      child(comuni).child(grup).child(oposi).child(id).updateChildren(map1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            dialog.dismiss();
                                            Toast.makeText(Admin.this, "Añadido con exito", Toast.LENGTH_LONG).show();
                                        } else {
                                            dialog.dismiss();
                                            Toast.makeText(Admin.this, "Vaya, algo ha salido mal", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        });
                    }

                    //salta error si esta vacio
                    else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Toast.makeText(Admin.this, "Archivo vacío", Toast.LENGTH_LONG).show();
                            }
                        });
                        return;
                    }
                }
                // error si falla o si no encuentra el archivo
                //
                catch (final FileNotFoundException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Admin.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                // saca error si hay problemas con el input output
                catch (final IOException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Admin.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    //obtener datos de las celdas
    private String getCellData(Row row, int cellposition, FormulaEvaluator formulaEvaluator) {
        String value = "";
        DataFormatter df = new DataFormatter();
        // saca los datos de la hoja excel
        Cell cell = row.getCell(cellposition);
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BOOLEAN:
                return value + cell.getBooleanCellValue();
           case Cell.CELL_TYPE_NUMERIC:
               //dataformatter para que no saque todos los nº como decimal
                final DataFormatter formatter = new DataFormatter();
                return value + formatter.formatCellValue(cell);
            case Cell.CELL_TYPE_STRING:
                return value + cell.getStringCellValue();
            default:
                return value;
        }
    }
}