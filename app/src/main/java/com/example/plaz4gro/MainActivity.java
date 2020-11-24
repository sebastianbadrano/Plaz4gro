package com.example.plaz4gro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurebtnayuda();
        configurebtnsalir();
        btnEntrar();

    }

    private void btnEntrar(){
        Button btnEntrarJ = (Button) findViewById(R.id.entrarbtn);
        btnEntrarJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InicioSesion.class));
            }
        });
    }

    private void configurebtnayuda(){
        ImageButton btnEntrarJ = (ImageButton) findViewById(R.id.ayudabtn);
        btnEntrarJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ayudaprincipal.class));
            }
        });
    }

    private void configurebtnsalir(){
        Button btnsalir = (Button) findViewById(R.id.salirbtn);
        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}