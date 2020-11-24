package com.example.plaz4gro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    ImageButton lista, paquete;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        lista = findViewById(R.id.idUbicacion);
        paquete = findViewById(R.id.idPaquete);
      //  paquete = findViewById(R.id.idUbicacion);

       // irLista ();
        irMapa();
        
    }

   /* private void irLista() {
        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
          Intent i = new Intent(Home.this, ListaPaqueteActivity.class )
                startActivity(i);
            }
        });
    }*/

    private void irMapa() {

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent packageContext;
                Intent i = new Intent(Home.this, MapsActivity.class );
                startActivity(i);
            }
        });
    }
}