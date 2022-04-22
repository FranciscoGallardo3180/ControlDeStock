package com.example.controldestock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void ingresarProducto(View vista){
        Intent i = new Intent(this,Formulario.class);
        startActivity(i);
    }
    public void leerCodigo(View vista){
        Intent i = new Intent(this,leerCodigo.class);
        startActivity(i);
    }
}