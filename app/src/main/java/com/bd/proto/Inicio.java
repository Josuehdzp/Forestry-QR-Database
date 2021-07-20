package com.bd.proto;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import static com.bd.proto.DatabaseHelper.dbnamey;


public class Inicio extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    MainActivity mainActivity;
    SQLiteDatabase dby;
    Cursor miCursor;
    EditText Etseleccion;

    Button Btnseleccion;
    TextView txtT;



    public static String dbruta= Environment.getExternalStorageDirectory().getPath()+"/";
    public static String dbnombre= "Blutbad1.db";
    public static String dbrutadata= "/data/data/com.bd.proto/databases/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccionardb);

        EditText EtSeleccion = (EditText) findViewById(R.id.escoge);
        String rutita = EtSeleccion.getText().toString();



        Btnseleccion= findViewById(R.id.botonseleccion);




    }

    public void antes(String rutt){



    }


    public void enseña(View enseña){

        Toast.makeText(this, dbruta, Toast.LENGTH_LONG).show();


    }


}
