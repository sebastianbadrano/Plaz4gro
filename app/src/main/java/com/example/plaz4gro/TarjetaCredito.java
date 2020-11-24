package com.example.plaz4gro;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.IpSecManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class TarjetaCredito extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //private boolean hasFlash = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarjeta_credito);

        configureLists();

        Button payment = findViewById(R.id.payButton);
        payment.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                torch(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        torch(false);
                    }
                }, 400);
            }
        });

        /*
        hasFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasFlash) {
                    try {
                        activateLantern();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(TarjetaCredito.this,"No se encontró una linterna disponible",Toast.LENGTH_SHORT).show();
                }
            }
        });
        */
    }
    private void torch(boolean b) {
        try {
            CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
            String cameraid = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraid,b);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    /*
    private void activateLantern() throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraId, true);
    }
    */


    private void configureLists() {
        Spinner idTypes = findViewById(R.id.idType);
        Spinner months = findViewById(R.id.month);
        Spinner years = findViewById(R.id.year);
        Spinner cuotas = findViewById(R.id.cuotas);

        ArrayAdapter<CharSequence> adapterDocumentType = ArrayAdapter.createFromResource(this, R.array.field_documentTypeDrop, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterMonth = ArrayAdapter.createFromResource(this, R.array.field_monthDrop, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterYear = ArrayAdapter.createFromResource(this, R.array.field_yearDrop, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterCuotas = ArrayAdapter.createFromResource(this, R.array.field_duesDrop, android.R.layout.simple_spinner_item);

        adapterDocumentType.setDropDownViewResource(R.layout.spinner_dropdown_item);
        adapterMonth.setDropDownViewResource(R.layout.spinner_dropdown_item);
        adapterYear.setDropDownViewResource(R.layout.spinner_dropdown_item);
        adapterCuotas.setDropDownViewResource(R.layout.spinner_dropdown_item);

        idTypes.setAdapter(adapterDocumentType);
        months.setAdapter(adapterMonth);
        years.setAdapter(adapterYear);
        cuotas.setAdapter(adapterCuotas);

        idTypes.setOnItemSelectedListener(this);
        months.setOnItemSelectedListener(this);
        years.setOnItemSelectedListener(this);
        cuotas.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
        String text = parent.getItemAtPosition(position).toString();
        if (!(text.equals("-Tipo-") || text.equals("-Mes-") || text.equals("-Año-") || text.equals("-Cuotas-"))) {
            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}