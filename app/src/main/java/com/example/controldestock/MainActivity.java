package com.example.controldestock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText txtEmail;
    private TextInputEditText txtPass;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.textInputCorreo);
        txtPass = findViewById(R.id.textInputPassword);
        btnLogin =  findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if(validarEmail(txtEmail) && validarPassword(txtPass) ==true){
                    goToMenu();
                }

            }

        });

    }
    private void goToMenu(){
        Intent i = new Intent(this,Menu.class);
        startActivity(i);
    }

    private boolean  validarEmail(TextInputEditText txtEmail){
        String emailInput = txtEmail.getText().toString();
        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            Toast.makeText(this, "correo valido", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            Toast.makeText(this, "Correo Invalido", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean validarPassword(TextInputEditText txtPass) {
        String passInput = txtPass.getText().toString();
        if (passInput.isEmpty()) {
            Toast.makeText(this, "Campo no debe estar vacio", Toast.LENGTH_SHORT).show();
            return false;
        } else if (passInput.length() < 5) {
            Toast.makeText(this, "la contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }


}