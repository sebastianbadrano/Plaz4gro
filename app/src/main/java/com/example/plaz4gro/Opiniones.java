package com.example.plaz4gro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class Opiniones extends AppCompatActivity {

    ImageButton titleBueno;
    ImageButton titleRegular;
    ImageButton titleMalo;
    Button enviarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opiniones);

        configureAtrasButton();
        configureEnviarButton();
        configureCalifiacionButton();


    }

    private void configureAtrasButton() {
        Button atrasButtonJ = (Button) findViewById(R.id.atrasButton);
        atrasButtonJ.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Opiniones.this, Detalles.class));
            }
        });
    }

    private void configureEnviarButton() {
        Button enviarButtonJ = (Button) findViewById(R.id.enviarButton);
        enviarButtonJ.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Opiniones.this, Opiniones2.class));
            }
        });
    }

    private void configureCalifiacionButton() {
        titleBueno = findViewById(R.id.buenoButton2);
        titleRegular = findViewById(R.id.regularButton2);
        titleMalo = findViewById(R.id.maloButton2);
        enviarButton = findViewById(R.id.enviarButton);

        titleBueno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enviarButton.getVisibility()==View.VISIBLE) {
                    enviarButton.setVisibility(View.GONE);
                    titleBueno.setImageResource(R.drawable.ic_bueno); //ic_grupo_528v2
                    titleRegular.setImageResource(R.drawable.ic_regular);
                    titleMalo.setImageResource(R.drawable.ic_malo);
                } else {
                    enviarButton.setVisibility(View.VISIBLE);
                    titleBueno.setImageResource(R.drawable.ic_grupo_528v2); //
                    titleRegular.setImageResource(R.drawable.ic_regular);
                    titleMalo.setImageResource(R.drawable.ic_malo);
                }

            }
        });

        titleRegular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enviarButton.getVisibility()==View.VISIBLE) {
                    enviarButton.setVisibility(View.GONE);
                    titleRegular.setImageResource(R.drawable.ic_regular); //ic_grupo_528v2
                    titleBueno.setImageResource(R.drawable.ic_bueno);
                    titleMalo.setImageResource(R.drawable.ic_malo);
                } else {
                    enviarButton.setVisibility(View.VISIBLE);
                    titleRegular.setImageResource(R.drawable.ic_grupo_527v2); //ic_bueno
                    titleBueno.setImageResource(R.drawable.ic_bueno);
                    titleMalo.setImageResource(R.drawable.ic_malo);
                }

            }
        });

        titleMalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enviarButton.getVisibility()==View.VISIBLE) {
                    enviarButton.setVisibility(View.GONE);
                    titleMalo.setImageResource(R.drawable.ic_malo); //ic_grupo_528v2
                    titleRegular.setImageResource(R.drawable.ic_regular);
                    titleBueno.setImageResource(R.drawable.ic_bueno);
                } else {
                    enviarButton.setVisibility(View.VISIBLE);
                    titleMalo.setImageResource(R.drawable.ic_grupo_529v2); //ic_bueno
                    titleRegular.setImageResource(R.drawable.ic_regular);
                    titleBueno.setImageResource(R.drawable.ic_bueno);

                }
            }
        });
    }

    }
