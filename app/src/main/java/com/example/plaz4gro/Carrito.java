package com.example.plaz4gro;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Carrito extends AppCompatActivity {

    private ListView listaProductosJ;

    private ArrayList<Product> productos = new ArrayList<Product>();

    private Object ActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrito);
        configurePaymentButton();

        listaProductosJ = (ListView) findViewById(R.id.mainList);

        uploadProductsExample();
        ProductAdapter productsArrayAdapter = new ProductAdapter(getApplicationContext(), productos);
        listaProductosJ.setAdapter(productsArrayAdapter);


        //configureDeleteItem();
    }

    private void uploadProductsExample(){
        String[] names = new String[]{"Papa","Arroz","Lechuga","Papaya","Cafe","Garbanzo","Comino","Leche","Tela"};
        String[] farmers = new String[]{"Rodrigo Hernandez","Fabricio Gomez","Rosa Benavides","Rosa Benavides","Ludovico Garrido","Alma Consuelo","Gabriela Cortez","Rodrigo Hernandez","Rodrigo Hernandez"};
        String[] quantities = new String[]{"9.9 Kg","6.5 Kg","3.2 Kg","30.0 Unidades","10.3 Kg","8.0 Kg","1.1 Kg","40.3 L","2.1 Kg"};
        for(int i=0;i<names.length;i++){
            Product example = new Product();
            example.setName(names[i]);
            example.setFarmer(farmers[i]);
            example.setQuantity(quantities[i]);
            productos.add(example);
        }
    }

    private void configurePaymentButton(){
        Button paymentButtonJ = (Button) findViewById(R.id.paymentButton);
        paymentButtonJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Carrito.this,OpcionesPago.class));
            }
        });
    }
}