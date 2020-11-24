package com.example.plaz4gro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OpcionesPago extends AppCompatActivity {

    Button titleCash;
    Button titleDebit;
    Button titleCredit;
    LinearLayout listCash;
    LinearLayout listDebit;
    LinearLayout listCredit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones_pago);

        configurePayment();
        configureDropdowns();
    }

    private void configureDropdowns() {
        titleCash = findViewById(R.id.cashButton);
        titleDebit = findViewById(R.id.debitButton);
        titleCredit = findViewById(R.id.creditButton);
        listCash = findViewById(R.id.cashOptions);
        listDebit = findViewById(R.id.debitOptions);
        listCredit = findViewById(R.id.creditOptions);

        titleCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listCash.getVisibility()==View.VISIBLE){
                    listCash.setVisibility(View.GONE);
                    titleCash.setBackgroundResource(R.drawable.buttonfield);
                }else{
                    listCash.setVisibility(View.VISIBLE);
                    titleCash.setBackgroundResource(R.drawable.buttonfieldselect);
                }
                titleDebit.setBackgroundResource(R.drawable.buttonfield);
                titleCredit.setBackgroundResource(R.drawable.buttonfield);
                listDebit.setVisibility(View.GONE);
                listCredit.setVisibility(View.GONE);
            }
        });
        titleDebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listDebit.getVisibility()==View.VISIBLE){
                    listDebit.setVisibility(View.GONE);
                    titleDebit.setBackgroundResource(R.drawable.buttonfield);
                }else{
                    listDebit.setVisibility(View.VISIBLE);
                    titleDebit.setBackgroundResource(R.drawable.buttonfieldselect);
                }
                titleCash.setBackgroundResource(R.drawable.buttonfield);
                titleCredit.setBackgroundResource(R.drawable.buttonfield);
                listCash.setVisibility(View.GONE);
                listCredit.setVisibility(View.GONE);
            }
        });
        titleCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listCredit.getVisibility()==View.VISIBLE){
                    listCredit.setVisibility(View.GONE);
                    titleCredit.setBackgroundResource(R.drawable.buttonfield);
                }else{
                    listCredit.setVisibility(View.VISIBLE);
                    titleCredit.setBackgroundResource(R.drawable.buttonfieldselect);
                }
                titleCash.setBackgroundResource(R.drawable.buttonfield);
                titleDebit.setBackgroundResource(R.drawable.buttonfield);
                listCash.setVisibility(View.GONE);
                listDebit.setVisibility(View.GONE);
            }
        });
    }

    private void configurePayment(){
        // PSE
        Button pseOpt = (Button) findViewById(R.id.pseButton);
        pseOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openPse = new Intent("android.intent.action.VIEW", Uri.parse("https://www.pse.com.co"));
                startActivity(openPse);
            }
        });

        // EFECTIVO
        Button cashOpt1J = (Button) findViewById(R.id.cashOpt1);
        Button cashOpt2J = (Button) findViewById(R.id.cashOpt2);
        Button cashOpt3J = (Button) findViewById(R.id.cashOpt3);
        cashOpt1J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpcionesPago.this,EfectivoEfecty.class));
            }
        });
        cashOpt2J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpcionesPago.this,EfectivoPagaTodo.class));
            }
        });
        cashOpt3J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpcionesPago.this,EfectivoViaBaloto.class));
            }
        });

        // DEBITO
        Button debitOpt1 = (Button) findViewById(R.id.debitOpt1);
        debitOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openDavivienda = new Intent("android.intent.action.VIEW", Uri.parse("https://www.davivienda.com/wps/portal/personas/nuevo"));
                startActivity(openDavivienda);
            }
        });
        Button debitOpt2 = (Button) findViewById(R.id.debitOpt2);
        debitOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openBancolombia = new Intent("android.intent.action.VIEW", Uri.parse("https://www.grupobancolombia.com/personas"));
                startActivity(openBancolombia);
            }
        });
        Button debitOpt3 = (Button) findViewById(R.id.debitOpt3);
        debitOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openBancoBogota = new Intent("android.intent.action.VIEW", Uri.parse("https://www.bancodebogota.com/wps/portal/banco-de-bogota/bogota"));
                startActivity(openBancoBogota);
            }
        });



        // CREDITO
        Button creditOpt1J = (Button) findViewById(R.id.creditOpt1);
        Button creditOpt2J = (Button) findViewById(R.id.creditOpt2);
        Button creditOpt3J = (Button) findViewById(R.id.creditOpt3);
        Button creditOpt4J = (Button) findViewById(R.id.creditOpt4);
        Button creditOpt5J = (Button) findViewById(R.id.creditOpt5);
        creditOpt1J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpcionesPago.this,TarjetaCredito.class));
            }
        });
        creditOpt2J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpcionesPago.this,TarjetaCredito.class));
            }
        });
        creditOpt3J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpcionesPago.this,TarjetaCredito.class));
            }
        });
        creditOpt4J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpcionesPago.this,TarjetaCredito.class));
            }
        });
        creditOpt5J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpcionesPago.this,TarjetaCredito.class));
            }
        });
    }
}