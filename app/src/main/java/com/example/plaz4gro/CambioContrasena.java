package com.example.plaz4gro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.lang.UProperty;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class CambioContrasena extends AppCompatActivity {
    private EditText emailText;
    private FirebaseAuth mAuth;
    private ProgressDialog esperaAnimacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cambio_contrasena);
        emailText = findViewById(R.id.ingCorreo);
        mAuth = FirebaseAuth.getInstance();
        esperaAnimacion = new ProgressDialog(this);
        cambiocontr_btnsend();

    }

    private void cambiocontr_btnsend(){
        Button cambiocontrbtn = (Button) findViewById(R.id.cambiocontrbtn);
        cambiocontrbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String email = emailText.getText().toString().trim();
                if(!email.isEmpty()){
                    esperaAnimacion.setMessage("Validando");
                    esperaAnimacion.setCanceledOnTouchOutside(false);
                    esperaAnimacion.show();
                    cambiarContrasenia(email);
                    startActivity(new Intent(CambioContrasena.this, MainActivity.class));

                }
                else{
                Toast.makeText(CambioContrasena.this, "No ha ingresado ningun correo", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }
    public void cambiarContrasenia(String email){
        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CambioContrasena.this, "Se ha enviado un enlace a tu correo para reestablecer tu contrasenia.", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(CambioContrasena.this, "Este correo no se encuentra registrado en nuestra base de datos o ha ocurrido un error. verifica e intenta nuevamente", Toast.LENGTH_SHORT).show();
                }
                esperaAnimacion.dismiss();


            }
        });

    }

}