package com.example.operaciones2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Receta extends AppCompatActivity {
    ViewFlipper v_flipper;
    TextView tvRecomendacion, tvNombre, tvIMC, tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);

        int images[] = {R.drawable.fliper1, R.drawable.fliper2, R.drawable.fliper3};
        v_flipper = findViewById(R.id.v_flipper);
        //creamos una sentencia para validacion
        for(int image: images){
            flipperImages(image);
        }
        
        //recibir datos
        recibirDatos();
    }

    private void recibirDatos() {
        //recibir datos
        Bundle extras =  getIntent().getExtras();
        String nombre = extras.getString("nombre");
        Double altura = extras.getDouble("altura");
        Double imc = extras.getDouble("IMC");
        Double peso = extras.getDouble("peso");
        String mensaje = extras.getString("mensaje");
        String recomendacion = extras.getString("recomendacion");

        tvRecomendacion = (TextView) findViewById(R.id.tvRecomendacion);
        tvNombre = (TextView) findViewById(R.id.txtNombre);
        tvIMC = (TextView) findViewById(R.id.txtIMC);
        tvMensaje = (TextView) findViewById(R.id.txtMensaje);

        tvNombre.setText("Hola "+nombre);
        tvIMC.setText("Tu IMC es de "+String.valueOf(imc));
        tvMensaje.setText(mensaje);
        tvRecomendacion.setText(recomendacion);


    }

    //creamos el metodo para el visor
    public void flipperImages(int image){
        ImageView imagenView = new ImageView(this);
        imagenView.setBackgroundResource(image);
        v_flipper.addView(imagenView);
        //duracion 1000=1seg
        v_flipper.setFlipInterval(2000);
        v_flipper.setAutoStart(true);
        //activamos la animacion
        v_flipper.setInAnimation(this, android.R.anim.slide_out_right);
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);


    }
}