package com.example.plaz4gro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ActividadBotones extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.miscompras);

        //configureDetailsButton();

    }

    /*private void configureDetailsButton(){
        ImageButton detailsButtonJ = (ImageButton) findViewById(R.id.detallesButton);
        detailsButtonJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActividadBotones.this,Detalles.class));
                //
            }
        });
    }/*

    /*private void configureDetailsButton() {
        ImageButton paymentButtonJ = (ImageButton) findViewById(R.id.details2Button);
        paymentButtonJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActividadBotones.this, Detalles.class));
            }
        });
    }*/


}
