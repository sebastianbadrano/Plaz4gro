package com.example.plaz4gro;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AyudaPedidos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda_pedidos);
    }

    public void Siguiente (View view){
        Intent siguiente = new Intent(this, NoLlegoPedido.class);
        startActivity(siguiente);
    }

    public void Siguiente2 (View view){
        Intent siguiente2 = new Intent(this, CancelarProducto.class);
        startActivity(siguiente2);
    }

    public void Siguiente3 (View view){
        Intent siguiente3 = new Intent(this, ContactarVendedor.class);
        startActivity(siguiente3);
    }
}