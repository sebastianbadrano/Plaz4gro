package com.example.plaz4gro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class InicioSesion extends AppCompatActivity {

    //UI Views
    private TextView authStatusTv;
    private Button authBtn;
    private EditText Correo;
    private EditText Password;
    private FirebaseAuth mAuth;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_sesion);

        Correo = findViewById(R.id.ingrCorreo);
        Password = findViewById(R.id.ingrContr);

        mAuth = FirebaseAuth.getInstance();
        configureopcion1();
        configureopcion2();
        configureopcion3();

        // Obtain the FirebaseAnalytics instance.
        //init UI views
        authStatusTv = findViewById(R.id.authStatusTv);
        authBtn = findViewById(R.id.authBtn);
        
        //init Biometric
        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(InicioSesion.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                authStatusTv.setText("Error de Autenticación: "+errString);
                Toast.makeText(InicioSesion.this, "Error de Autenticación: "+errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                authStatusTv.setText("Autenticación Exitosa");
                Toast.makeText(InicioSesion.this, "Autenticación Exitosa", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(InicioSesion.this, Home.class));
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                authStatusTv.setText("Autenticación Fallida");
                Toast.makeText(InicioSesion.this, "Autenticación Fallida", Toast.LENGTH_SHORT).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("Autenticación Biometrica").setSubtitle("Login usando huella").setNegativeButtonText("Salir").build();

        authBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);

            }
        });

    }

    private void configureopcion1()
    {
        Button btnopcion1 = (Button) findViewById(R.id.registrobtn);
        btnopcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InicioSesion.this, Registro.class));
            }
        });

    }

    private void configureopcion2()
    {
        Button btnIniciarSesiion = (Button) findViewById(R.id.iniciobtn);
        btnIniciarSesiion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String variable1 = Correo.getText().toString().trim();
                String variable2 = Password.getText().toString().trim();

                if(!variable1.isEmpty() && !variable2.isEmpty()){
                    verificarSiExiste(variable1, variable2);
                }
                else
                    Toast.makeText(InicioSesion.this, "Por favor rellene los campos", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void configureopcion3()
    {
        Button btnopcion3 = (Button) findViewById(R.id.olvidecontr_btn);
        btnopcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InicioSesion.this, CambioContrasena.class));
            }
        });
    }

    public void verificarSiExiste(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            if (user.isEmailVerified()){
                                Toast.makeText(InicioSesion.this, "Has iniciado sesion", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(InicioSesion.this, Home.class));
                            }
                            else{
                                Toast.makeText(InicioSesion.this, "Correo no verificado, ingrese al link que se envio a su email para verificarlo", Toast.LENGTH_SHORT).show();
                                FirebaseAuth.getInstance().signOut();
                            }

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(InicioSesion.this, "El correo o la contrasenia no son correctos.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                    private void updateUI(FirebaseUser currentUser) {
                        Log.i("user", " "+currentUser);
                    }
                });

    }

}