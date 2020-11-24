package com.example.plaz4gro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Detalles extends AppCompatActivity {

    Button titleFlecha1;
    Button titleFlecha3;
    Button titleFlecha4;

    LinearLayout listCaja1;
    LinearLayout listCaja3;
    LinearLayout listCaja4;

    //Button titleDetails;
    //LinearLayout listDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles);

        configureOpinarButton();
        configureAtrasButton();
        //configurePayment();
        configureDropdowns2();
        configureAyudaButton();
    }

    private void configureAtrasButton(){
        Button atrasButtonJ = (Button) findViewById(R.id.atrasButton);
        atrasButtonJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detalles.this,MisCompras.class));
            }
        });
    }

    private void configureOpinarButton(){
        Button flecha2ButtonJ = (Button) findViewById(R.id.flecha2);
        flecha2ButtonJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Detalles.this, Opiniones.class);
                        startActivity(intent);
            }
        });
    }

    private void configureAyudaButton(){
        Button ayudaButtonJ = (Button) findViewById(R.id.enviarButton);
        ayudaButtonJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               confirmFireMissiles();
            }
        });
    }

    public void confirmFireMissiles() {
        DialogFragment newFragment = new MensajesPush();
        newFragment.show(getSupportFragmentManager(), "missiles");
    }


    private void configureDropdowns2() {
        titleFlecha1 = findViewById(R.id.flecha1);
        listCaja1 = findViewById(R.id.caja1);
        titleFlecha3 = findViewById(R.id.flecha3);
        listCaja3 = findViewById(R.id.caja3);
        titleFlecha4 = findViewById(R.id.flecha4);
        listCaja4 = findViewById(R.id.caja4);

        titleFlecha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listCaja1.getVisibility()==View.VISIBLE){
                    listCaja1.setVisibility(View.GONE);
                    titleFlecha1.setBackgroundResource(R.drawable.ic_cerrado);
                }else{
                    listCaja1.setVisibility(View.VISIBLE);
                    titleFlecha1.setBackgroundResource(R.drawable.ic_abierto);
                }
                titleFlecha3.setBackgroundResource(R.drawable.ic_cerrado);
                titleFlecha4.setBackgroundResource(R.drawable.ic_cerrado);
                listCaja3.setVisibility(View.GONE);
                listCaja4.setVisibility(View.GONE);
            }
        });
        titleFlecha3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listCaja3.getVisibility()==View.VISIBLE){
                    listCaja3.setVisibility(View.GONE);
                    titleFlecha3.setBackgroundResource(R.drawable.ic_cerrado);
                }else{
                    listCaja3.setVisibility(View.VISIBLE);
                    titleFlecha3.setBackgroundResource(R.drawable.ic_abierto);
                }
                titleFlecha1.setBackgroundResource(R.drawable.ic_cerrado);
                titleFlecha4.setBackgroundResource(R.drawable.ic_cerrado);
                listCaja1.setVisibility(View.GONE);
                listCaja4.setVisibility(View.GONE);
            }
        });
        titleFlecha4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listCaja4.getVisibility()==View.VISIBLE){
                    listCaja4.setVisibility(View.GONE);
                    titleFlecha4.setBackgroundResource(R.drawable.ic_cerrado);
                }else{
                    listCaja4.setVisibility(View.VISIBLE);
                    titleFlecha4.setBackgroundResource(R.drawable.ic_abierto);
                }
                titleFlecha1.setBackgroundResource(R.drawable.ic_cerrado);
                titleFlecha3.setBackgroundResource(R.drawable.ic_cerrado);
                listCaja1.setVisibility(View.GONE);
                listCaja3.setVisibility(View.GONE);
            }
        });
    }





   /*private void configureDropdowns() {
        titleCash = findViewById(R.id.cashButton);
        titleDebit = findViewById(R.id.debitButton);
        titleCredit = findViewById(R.id.creditButton);
        listCash = findViewById(R.id.cashOptions);
        listDebit = findViewById(R.id.debitOptions);
        listCredit = findViewById(R.id.creditOptions);
        //titleDetails = findViewById(R.id.detailsButton);
       // listDetails = findViewById(R.id.detailsOptions);

        titleDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listDetails.getVisibility() == View.VISIBLE) {
                    listDetails.setVisibility(View.GONE);
                    titleDetails.setBackgroundResource(R.drawable.buttonfield2);
                } else {
                    listDetails.setVisibility(View.VISIBLE);
                    titleDetails.setBackgroundResource(R.drawable.buttonfieldselect2);
                }
            }
        })

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
    }/*



    /*private void configurePayment(){
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
                startActivity(new Intent(Detalles.this,EfectivoEfecty.class));
            }
        });
        cashOpt2J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detalles.this,EfectivoPagaTodo.class));
            }
        });
        cashOpt3J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detalles.this,EfectivoViaBaloto.class));
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
                startActivity(new Intent(Detalles.this,TarjetaCredito.class));
            }
        });
        creditOpt2J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detalles.this,TarjetaCredito.class));
            }
        });
        creditOpt3J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detalles.this,TarjetaCredito.class));
            }
        });
        creditOpt4J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detalles.this,TarjetaCredito.class));
            }
        });
        creditOpt5J.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detalles.this,TarjetaCredito.class));
            }
        });
    }*/
}