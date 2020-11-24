package com.example.plaz4gro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    private EditText editTextCorreo;
    private EditText editTextPassword ;
    private EditText editTextUsuario;
    private EditText editTextRePassword;
    private EditText editTextCelular;
    private EditText editTextDireccion;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        editTextCorreo = findViewById(R.id.registCorreo);
        editTextPassword = findViewById(R.id.registContrasena);
        editTextUsuario = findViewById(R.id.registUsuario);
        editTextRePassword = findViewById(R.id.registConfContr);
        editTextCelular = findViewById(R.id.registCelular);
        editTextDireccion = findViewById(R.id.registDireccion);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        onStart();
        sendToDB();
        laFotico();

    }

    private void laFotico(){
        Button laFotico = (Button) findViewById(R.id.btnTomarFoto);
        laFotico.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registro.this, actividad_Camara.class));
            }
        });
    }



    private void alertaSend(){
        new AlertDialog.Builder(this).setTitle("Notificación").setMessage("Se envió un código a su correo, por favor verifique e ingréselo a la aplicación ")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Registro.this,Registro.class));
                    }
                }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeContextMenu();
            }
        }).setCancelable(false).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        Log.i("user", " "+currentUser);
    }

    public void sendToDB(){
        Button send = findViewById(R.id.registrobtn);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Correo = editTextCorreo.getText().toString().trim();
                String Password = editTextPassword.getText().toString().trim();
                String Repassword = editTextRePassword.getText().toString();
                String Usuario = editTextUsuario.getText().toString().trim();
                String Celular = editTextCelular.getText().toString();
                String Direccion = editTextDireccion.getText().toString();

                if(!Correo.isEmpty() && !Password.isEmpty()){
                    if(Password.length() > 5){
                        if(Password.equals(Repassword)){
                            createUserWithEmailAndPassword(Correo, Password, Usuario, Correo, Password, Celular, Direccion);
                        }
                        else{
                            Toast.makeText(Registro.this, "Lo sentimos, la contra no coincide con la confirmacion", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        Toast.makeText(Registro.this, "Lo sentimos, por cuestiones de seguridad la contrasenia debe ser mayor a 6 digitos", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Registro.this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void createUserWithEmailAndPassword(String email, String password, final String Usuario, final String Correo, final String Password, final String Celular, final String Direccion){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            regist_btnsend(Usuario, Correo, Password, Celular, Direccion);
                            Log.d("TAG", "createUserWithEmail:success");
                            Toast.makeText(Registro.this, "El registro fue exitoso", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            user.sendEmailVerification();
                            updateUI(user);
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(Registro.this, InicioSesion.class));
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Registro.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
    private void regist_btnsend(String Usuario, String Correo, String Password, String Celular, String Direccion){
        String id = mAuth.getCurrentUser().getUid();
        Map<String, Object> map = new HashMap<>();
        map.put("ID_AUTH", id);
        map.put("Usuario", Usuario);
        map.put("Correo", Correo);
        map.put("Password", Password);
        map.put("Celular", Celular);
        map.put("Direccion", Direccion);
        mDatabase.child("Usuarios").push().setValue(map);
    }


}