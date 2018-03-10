package com.example.hp.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ArrayList<Contacto> contactos;
    EditText txtNombre;
    EditText txtEmail;
    EditText txtTelefono;
    EditText txtDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle par = getIntent().getExtras();
        txtNombre = (EditText)findViewById(R.id.etNombre);
        txtEmail = (EditText)findViewById(R.id.etEmail);
        txtTelefono = (EditText)findViewById(R.id.etTelefono);
        txtDescripcion = (EditText)findViewById(R.id.etDescripcion);
        if(par!=null){
            txtNombre.setText(par.getString(getResources().getString(R.string.nombre)));
            txtTelefono.setText(par.getString(getResources().getString(R.string.telefono)));
            txtEmail.setText(par.getString(getResources().getString(R.string.email)));
            txtDescripcion.setText(par.getString(getResources().getString(R.string.descripcion)));
        }

    }
    public void siguiente(View view){
        //Toast.makeText(getApplicationContext(),"TEXTO SALUDO",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this,DetalleActivity.class);
        intent.putExtra(getResources().getString(R.string.nombre),txtNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.email),txtEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.telefono),txtTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.descripcion),txtDescripcion.getText().toString());
        startActivity(intent);
        finish();
    }
}
