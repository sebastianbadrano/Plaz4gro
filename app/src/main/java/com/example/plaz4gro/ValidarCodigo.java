package com.example.plaz4gro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ValidarCodigo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validar_codigo);
        validcod_btnsend();
    }

    private void validcod_btnsend(){
        Button btnsend = (Button) findViewById(R.id.validbtn);
        btnsend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                alertaSend();
            }
        });
    }

    private void alertaSend(){
        new AlertDialog.Builder(this).setTitle("Validación").setMessage("El código se ha validado correctamente")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ValidarCodigo.this,InicioSesion.class));
                    }
                }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeContextMenu();
            }
        }).setCancelable(false).show();
    }

}