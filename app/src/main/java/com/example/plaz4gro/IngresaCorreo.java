package com.example.plaz4gro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IngresaCorreo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresa_correo);
        correo_btnsend();
    }

    private void correo_btnsend(){
        Button btnsend = (Button) findViewById(R.id.envcorreo);
        btnsend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                alertaSend();
            }
        });
    }

    private void alertaSend(){
        new AlertDialog.Builder(this).setTitle("Correo enviado").setMessage("Se envio un codigo a su correo, por favor verifique e ingreselo a la aplicación")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(IngresaCorreo.this,InicioSesion.class));
                    }
                }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeContextMenu();
            }
        }).setCancelable(false).show();
    }

}