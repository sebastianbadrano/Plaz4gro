package com.example.plaz4gro;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AyudaProducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda_producto);
    }

    public void Siguiente (View view){
        Intent siguiente = new Intent(this, NoEncuentro.class);
        startActivity(siguiente);
    }

    public void Siguiente2 (View view){
        Intent siguiente2 = new Intent(this, CancelarProducto.class);
        startActivity(siguiente2);
    }

    public void Siguiente3 (View view){
        Intent siguiente3 = new Intent(this, BusquedaCiudad.class);
        startActivity(siguiente3);
    }
}