package com.example.plaz4gro;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MisCompras extends AppCompatActivity implements SensorEventListener {
    private SensorManager senSensorManager;
    private Sensor senAccelerometer;

    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 10200;


    private ListView listaProductosJ;

    private ArrayList<Product> productos = new ArrayList<Product>();

    private Object ActionBarDrawerToggle;

    Button titleDetails;
    LinearLayout listDetails;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.miscompras);
        configurePaymentButton();
        //configureDetailsButton();
        //configurePayment();
        //configurePayment2();


        listaProductosJ = (ListView) findViewById(R.id.mainList);

        uploadProductsExample();
        ProductAdapter productsArrayAdapter = new ProductAdapter(getApplicationContext(), productos);
        listaProductosJ.setAdapter(productsArrayAdapter);

        //configureDropdowns();
        //configureDeleteItem();

        //Inicalizar los sensores
        senSensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        assert senSensorManager != null;

        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
        if(senAccelerometer==null) {
            finish();
        }
    }

    public void start(){
        senSensorManager.registerListener(this, senAccelerometer, senSensorManager.SENSOR_DELAY_NORMAL);
    }

    public void stop(){
        senSensorManager.unregisterListener(this, senAccelerometer);
    }

    @Override
    protected void onPause(){
        stop();
        super.onPause();
    }

    @Override
    protected void onResume(){
        start();
        super.onResume();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        android.hardware.Sensor mySensor = event.sensor;
        if (mySensor.getType() == android.hardware.Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                float speed = Math.abs(x + y + z - last_x - last_y - last_z)/ diffTime * 10000;

                if (speed > SHAKE_THRESHOLD) {
                    prueba();
                }

                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
    }


    private void uploadProductsExample(){
        String[] names = new String[]{"Gonzalo","Ugo sin h","Nani","Kiwi"};
        String[] farmers = new String[]{"22 de noviembre","20 de octubre","15 de octubre","10 de octubre"};
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
       Button paymentButtonJ = (Button) findViewById(R.id.enviarButton);
        paymentButtonJ.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                startActivity(new Intent(MisCompras.this,Detalles.class));
               //
            }
        });
    }

    private void configureDropdowns() {
        titleDetails = findViewById(R.id.enviarButton);
        listDetails = findViewById(R.id.detallesOptions);

        titleDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listDetails.getVisibility() == View.VISIBLE) {
                    listDetails.setVisibility(View.GONE);
                    titleDetails.setBackgroundResource(R.drawable.buttonfield);
                } else {
                    listDetails.setVisibility(View.VISIBLE);
                    titleDetails.setBackgroundResource(R.drawable.buttonfieldselect);
                }
            }
        });
    }

    private void configurePayment() {
        // PSE
        @SuppressLint("WrongViewCast") ImageView pseOpt = (ImageView) findViewById(R.id.imagenhist);
        pseOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openPse = new Intent("android.intent.action.VIEW", Uri.parse("https://www.pse.com.co"));
                startActivity(openPse);
            }
        });
    }

    private void configurePayment2() {
        ImageButton imageView = (ImageButton) findViewById(R.id.detallesButton);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/watch?v=ynBUlxsy8nQ"));
                startActivity(intent);
            }
        });
    }

    private void prueba(){
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/watch?v=ynBUlxsy8nQ"));
        startActivity(intent);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}