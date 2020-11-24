package com.example.plaz4gro;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NoLlegoPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_llego_pedido);
    }

    public void Anterior (View view){
        Intent anterior = new Intent(this, AyudaPedidos.class);
        startActivity(anterior);
    }
}