package com.example.operaciones2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void salud(View view) {
        Intent salud = new Intent (MainActivity.this, Salud.class);
        startActivity(salud);
    }

    public void operaciones(View view) {
        Intent operaciones = new Intent (MainActivity.this, Operaciones.class);
        startActivity(operaciones);
    }

    public void salir(View view) {
        finish();
    }
}