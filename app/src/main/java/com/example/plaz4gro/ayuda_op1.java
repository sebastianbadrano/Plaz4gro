package com.example.plaz4gro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ayuda_op1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda_op1);

        ayuda_op_1_send();
    }

    private void ayuda_op_1_send(){
        Button btnsend = (Button) findViewById(R.id.ayudaop1_btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertaSend();
            }
        });
    }
    private void alertaSend(){
        new AlertDialog.Builder(this)
                .setTitle("Ticket generado")
                .setMessage("Se ha creado un ticket, en breve te ayudaremos a solucionar tu problema.")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeContextMenu();
                    }
                })
                .setCancelable(false)
                .show();
    }
}