package com.bd.proto;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.bd.proto.DatabaseHelper.dbnamey;
import static com.bd.proto.DatabaseHelper.dbpathy;
import static com.bd.proto.DatabaseHelper.dbpathydata;
import static com.bd.proto.Inicio.dbrutadata;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    SQLiteDatabase dby;
    Cursor miCursor;
    EditText ETid, ETcod, ETestad, ETpred, ETselecBDEx, ETselecBDGuar;
    EditText  EtSeleccion;
    Button btnI, btnB, btnE, btnD;
    TextView txtT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtT = findViewById(R.id.txttodo);

        ETid = findViewById(R.id.editText0);
        ETcod = findViewById(R.id.editText);
        ETestad = findViewById(R.id.editText2);
        ETpred = findViewById(R.id.editText4);
        ETselecBDEx = findViewById(R.id.SelecBDEx);
        ETselecBDGuar = findViewById(R.id.SelecBDGuar);

        btnI = findViewById(R.id.botoninsertar);
        btnB = findViewById(R.id.botonbuscar);
        btnE = findViewById(R.id.botoneditar);
        btnD = findViewById(R.id.botonborrar);

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.StartWork();
        dby = databaseHelper.getWritableDatabase();



        ///((((()))))\\\
//        EditText EtSeleccion = (EditText) getWindow().getDecorView().findViewById(R.id.escoge);
//        String rutita = EtSeleccion.getText().toString();
//        EtSeleccion.setText(rutita);
        ///((((()))))\\\
        MostrarDB();


//Verifica permisos para Android 6.0+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            checkExternalStoragePermission();
        }

//
//        databaseHelper = new DatabaseHelper(this, "EjemNumUno.db", 1);
//
//        try {
//            databaseHelper.CheckDatabase();
//        } catch (Exception e) {
//        }





     /*   try {
            //Obtiene ruta de base de datos origen.
            String pathDB = getDatabasePath("/data/data/" + getPackageName() + "/databases/zero.db").toString();
            //Copia base de datos a destino definido.
            DatabaseHelper.copyFile(pathDB, Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + getPackageName() + "/" +  "zero.db");
        }catch (Exception ignored){}*/
    }


    private void checkExternalStoragePermission() {

        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para leer.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 225);
        } else {
            Log.i("Mensaje", "Se tiene permiso para leer!");
        }

    }



    //codigo para copiar la bd en la memoria externa mediante un boton
    public void ExportarDB(View copiar) {
        try {
            //Obtiene ruta de base de datos origen.
            String pathDB = getDatabasePath(dbpathydata + dbnamey).toString();
            //Copia base de datos a destino definido.
            DatabaseHelper.copyFile(pathDB, Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + getPackageName() + "/" + ETselecBDEx.getText().toString()+".db");
        } catch (Exception ignored) {
        }


    }

    //////////////////////////////////////////////////////////////////////


    //codigo para copiar la bd en la memoria externa mediante un boton
    public void Exportar2DB(View dosDB) {
        try {
            //Obtiene ruta de base de datos origen.
            String pathDB = getDatabasePath(dbpathy + dbnamey).toString();
            //Copia base de datos a destino definido.
            DatabaseHelper.copyFile(pathDB, Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + getPackageName() + "/" + ETselecBDEx.getText().toString()+".db");
        } catch (Exception ignored) {
        }


    }

    //////////////////////////////////////////////////////////////////////

    public void GuardarDB(View copiar) {
        try {
            //Obtiene ruta de base de datos origen.
            String pathDB = getDatabasePath(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + getPackageName() + "/" + "EjemNumUno2.db").toString();
            //Copia base de datos a destino definido.
            DatabaseHelper.copyFile(pathDB, "/data/data/" + getPackageName() + "/databases/" + ETselecBDGuar.getText().toString()+".db");
        } catch (Exception ignored) {
        }


    }


    //////////////////////////////////////////////////////////////////////

    public void GuardarDB2(View copiar) {
        try {
            //Obtiene ruta de base de datos origen.
            String pathDB = getDatabasePath(dbpathy+ETselecBDEx.getText().toString()).toString()+".db";
            //Copia base de datos a destino definido.
            DatabaseHelper.copyFile(pathDB, "/data/data/" + getPackageName() + "/databases/" + dbnamey);
        } catch (Exception ignored) {
        }


    }

    //////////////////////////////////////////////////////////////////////

    public void CopiarDB2(View copiar) {
        try {
            //Obtiene ruta de base de datos origen.
            String pathDB = getDatabasePath(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + getPackageName() + "/" + "EjemNumUno2.db").toString();
            //Copia base de datos a destino definido.
            DatabaseHelper.copyFile(pathDB, "/data/data/" + getPackageName() + "/databases/EjemNumUno2.db");
        } catch (Exception ignored) {
        }


    }


    //////////////////////////////////////////////////////////////////////


    public void IntenbtnUno(View intbtn1) {

        try {
            //Obtiene ruta de base de datos origen.
            File pathDB = getDatabasePath(Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + getPackageName() + "/" + ETselecBDEx.getText().toString()+".db");

        } catch (Exception ignored) {
        }


    }
    //////////////////////////////////////////////////////////////////////



    @SuppressLint("SetTextI18n")
    private void MostrarDB() {
        try {

            databaseHelper.open();

            txtT.setText("");
            miCursor = dby.rawQuery("SELECT*from tablita", null);
            miCursor.moveToFirst();

            for (int i = 0; i < miCursor.getCount(); i++) {
                txtT.setText(txtT.getText().toString() + "\n" +
                        miCursor.getString(0).toString() + "  " +
                        miCursor.getString(1).toString() + "  " +
                        miCursor.getString(2).toString() + "  " +
                        miCursor.getString(3).toString());
                miCursor.moveToNext();
            }
        } catch (Exception ex) {
            Toast.makeText(MainActivity.this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void Insertar(View insertar) {


        try {
            dby.execSQL("INSERT into tablita values (" +
                    Integer.parseInt(ETid.getText().toString()) + ", '" +
                    ETcod.getText().toString() + "', '" +
                    ETestad.getText().toString() + "', '" +
                    ETpred.getText().toString() + "')");

            MostrarDB();
        } catch (Exception eInsert) {
            Toast.makeText(MainActivity.this, eInsert.getMessage().toString(), Toast.LENGTH_SHORT).show();

        }

    }

    public void Buscar(View buscar) {

        try {
            miCursor = dby.rawQuery("SELECT Codigoid, Estado, Predio from tablita where Codigoid = '" +
                    ETcod.getText().toString() + "'", null);

            miCursor.moveToFirst();
            txtT.setText(miCursor.getString(0).toString() + " " +
                    miCursor.getString(1).toString() + " " +
                    miCursor.getString(2).toString());
        } catch (Exception eBus) {

            Toast.makeText(MainActivity.this, eBus.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }

    public void Borrar(View borrar) {

        try {
            dby.execSQL("DELETE from tablita where id =  " + ETid.getText().toString() + "");
            MostrarDB();
        } catch (Exception eBorrar) {
            Toast.makeText(MainActivity.this, eBorrar.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void Editar(View editar) {

        try {
            dby.execSQL("UPDATE tablita set id = "+
                    ETid.getText().toString()+", Codigoid='"+
                    ETcod.getText().toString()+"', Estado = '"+
                    ETestad.getText().toString()+"', Predio = '"+
                    ETpred.getText().toString()+"' where id = "+
                    ETid.getText().toString()+"");
            MostrarDB();

        } catch (Exception eEditar) {
            Toast.makeText(MainActivity.this, eEditar.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }


}
