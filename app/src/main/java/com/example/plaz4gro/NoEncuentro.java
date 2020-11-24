package com.example.plaz4gro;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NoEncuentro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_encuentro);
    }

    public void Anterior (View view){
        Intent anterior = new Intent(this, AyudaProducto.class);
        startActivity(anterior);
    }
}