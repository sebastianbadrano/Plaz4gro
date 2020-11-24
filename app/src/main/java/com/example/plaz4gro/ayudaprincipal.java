package com.example.plaz4gro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ayudaprincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayudaprincipal);
        configureopcion11();
        configureopcion12();
        configureopcion13();


    }

    private void configureopcion11(){
        Button btnopcion11 = (Button) findViewById(R.id.opcion11);
        btnopcion11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ayudaprincipal.this, ayuda_op1.class));
            }
        });
    }

    private void configureopcion12(){
        Button btnopcion12 = (Button) findViewById(R.id.opcion12);
        btnopcion12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ayudaprincipal.this, ayuda_op2.class));
            }
        });
    }

    private void configureopcion13(){
        Button btnopcion13 = (Button) findViewById(R.id.opcion13);
        btnopcion13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ayudaprincipal.this, ayuda_op3.class));
            }
        });
    }
}