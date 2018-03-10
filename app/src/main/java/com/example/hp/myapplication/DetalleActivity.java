package com.example.hp.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {
    private TextView textNombre;
    private TextView textFono;
    private TextView textEmail;
    private TextView textDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Bundle param = getIntent().getExtras();


        String nombre = param.getString(getResources().getString(R.string.nombre));
        String fono = param.getString(getResources().getString(R.string.telefono));
        String email = param.getString(getResources().getString(R.string.email));
        String descripcion = param.getString(getResources().getString(R.string.descripcion));

        textNombre = (TextView) findViewById(R.id.tvNombre);
        textFono = (TextView) findViewById(R.id.tvTelefono);
        textEmail = (TextView) findViewById(R.id.tvEmail);
        textDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        textNombre.setText(nombre);
        textFono.setText(fono);
        textEmail.setText(email);
        textDescripcion.setText(descripcion);

    }

    public void editarUsuario(View view){
        Intent intent = new Intent(DetalleActivity.this,MainActivity.class);
        intent.putExtra(getResources().getString(R.string.nombre),textNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.email),textEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.telefono),textFono.getText().toString());
        intent.putExtra(getResources().getString(R.string.descripcion),textDescripcion.getText().toString());
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleActivity.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
