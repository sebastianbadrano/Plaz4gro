package com.example.plaz4gro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Opiniones2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opiniones2);

        configureAtrasButton();
        configureEnviarButton();
    }

    private void configureAtrasButton(){
        Button atrasButtonJ = (Button) findViewById(R.id.atrasButton);
        atrasButtonJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Opiniones2.this,Opiniones.class));
            }
        });
    }

    private void configureEnviarButton(){
        Button enviarButtonJ = (Button) findViewById(R.id.enviarButton);
        enviarButtonJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Opiniones2.this,Detalles.class));
            }
        });
    }

}
