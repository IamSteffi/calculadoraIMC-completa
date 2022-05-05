package com.example.operaciones2;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Salud extends AppCompatActivity {
    EditText etNombre, etPeso, etAltura;
    Button btnCalcular, btnLimpiar;
    RadioButton rbVaron, rbMujer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);

        etNombre = (EditText) findViewById(R.id.txtNombre);
        etPeso = (EditText) findViewById(R.id.txtPeso);
        etAltura = (EditText) findViewById(R.id.txtAltura);
        btnCalcular = (Button) findViewById(R.id.bCalcular);
        btnLimpiar = (Button) findViewById(R.id.bLimpiar);
        rbVaron = (RadioButton) findViewById(R.id.rHombre);
        rbMujer = (RadioButton) findViewById(R.id.rMujer);


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Limpiar();
            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString();
                Double altura = Double.valueOf(etAltura.getText().toString());
                Double peso = Double.valueOf(etPeso.getText().toString());
                double IMC = Math.round(peso / Math.pow(altura,2));

                Intent receta = new Intent (Salud.this, Receta.class);
                receta.putExtra("nombre",nombre);
                receta.putExtra("altura",altura);
                receta.putExtra("peso",peso);
                receta.putExtra("IMC",IMC);
                receta.putExtra("mensaje",MensajeIMC(IMC));
                receta.putExtra("recomendacion",RecomendacionIMC(IMC));
                startActivity(receta);
            }
        });
    }

    private void Limpiar() {
        etNombre.setText("");
        etAltura.setText("");
        etPeso.setText("");
    }
    private String MensajeIMC (double IMC){
        String mensaje = "";
        if (IMC <16)
            mensaje = "Bajo peso muy grave";
        else if (IMC >=16 & IMC <=16.99)
            mensaje = "Peso bajo grave";
        else if (IMC >=17 & IMC <=18.49)
            mensaje = "Bajo peso";
        else if (IMC >=18.50 & IMC <=24.99)
            mensaje = "Peso normal";
        else if (IMC >=25 & IMC <=29.99)
            mensaje = "Sobre peso";
        else if (IMC >=30 & IMC <=34.99)
            mensaje = "Obesidad grado I";
        else if (IMC >=35 & IMC <=39.99)
            mensaje = "Obesidad grado II";
        else
            mensaje = "Obesidad grado III";
        return mensaje;
    }
    private String RecomendacionIMC (double IMC){
        String mensaje = "";
        if (IMC <16)
            mensaje = "Basa tus comidas en carbohidratos con almidon, como pan, pasta, arroz o papas con cascara. \n" +
                    "Elige varriedades integrales siempre que sea posible. Puede haber riesgos de salud asociados a un IMC bajo, tales como anemia, osteoporosis, un sistema inmune debilitado y problemas de fertilidad.";
        else if (IMC >=16 & IMC <=16.99)
            mensaje = "Las personas con un bajo peso tienden a estar muy cansadas y con tendencia al agotamiento. La falta de nutrientes también puede agotar el sistema inmunológico, haciendote mucho más susceptible a las enfermedades e infecciones.\n" +
                    "El bajo consumo de hierro puede provocar anemia, transportamos menos oxígeno en la sangre, y se aumentan los sentimientos de agotamiento y se reducen las funciones en los órganos. Las vitaminas A y C son de particular importancia para la salud y tener un peso bajo puede significar que no tienes las reservas necesarias para prevenir enfermedades como el resfriado común o el cáncer. \n" +
                    "Tener un mal sistema inmunológico puede hacer que tu cuerpo le sea más difícil combatir los virus que contribuyen a desarrollar enfermedades.";
        else if (IMC >=17 & IMC <=18.49)
            mensaje = "Los tratamientos convencionales para el aumento de peso dependen en gran medida de la causa de la pérdida de peso. Para ayudar a comenzar la restauración de nutrientes en las personas delgadas, alta en calorías, suplementos nutricionales de vitaminas compactas son a menudo utilizadas pararevitalizar el cuerpo.\n" +
                    " Si hay un trastorno psicológico detrás de la pérdida de peso, como la anorexia o la bulimia, el asesoramiento puede ayudar a volver a un peso saludable.";
        else if (IMC >=18.50 & IMC <=24.99)
            mensaje = "Mantener la rutina de las comidas, elegir comida baja en grasas, caminar para perder peso, leer las etiquetas de lo que comemos, vigilar el tamaño de las raciones, levantarse de la mesa, pensar antes de beber, tomarnos nuestro tiempo, y no olvidar las 5 raciones diarias de fruta y verdura.";
        else if (IMC >=25 & IMC <=29.99)
            mensaje = "Sabemos que el exceso de peso es perjudicial para la salud, pero no todo está perdido y la solución, en la mayoría de los casos, está al alcance de la mano. La buena noticia es que estas enfermedades se pueden prevenir a través de unos hábitos de vida saludable, como son la alimentación y realizar ejercicio de forma regular.";
        else if (IMC >=30 & IMC <=34.99)
            mensaje = "La alimentación debe ser variada, equilibrada, suficiente y placentera.\n" +
                    "Planifique las comidas del día con antelación para disponer siempre de alimentos saludables listos para consumir.\n" +
                    "Consuma frutas y verduras de temporada, enteras y al menos dos veces al día.\n" +
                    "Incluya las legumbres semanalmente más de 4 veces a la semana.\n" +
                    "Aumente el consumo de pescado fresco (blanco y azul), y deje las conservas para momentos puntuales\n" +
                    "Mantenga un ritmo de ingesta a lo largo del día para llegar saciado a las comidas principales.\n" +
                    "Planifique las comidas y cenas con antelación para que siempre disponga de alimentos saludables listos para consumir.\n" +
                    "Organice el menú semanal dando prioridad a los alimentos de temporada.\n" +
                    "Equilibre su plato entre proteínas, hidratos de carbono y verduras.\n" +
                    "Aumente la frecuencia de consumo semanal de legumbres como fuente de hidratos de carbono.";
        else if (IMC >=35 & IMC <=39.99)
            mensaje = "Priorice el pescado (blanco y azul) frente a la carne blanca o roja.\n" +
                    "Asegure el consumo diario de frutas y verduras para mejorar el tránsito intestinal.\n" +
                    "Beba agua diariamente y no la sustituya por refrescos aunque sean light o zero.\n" +
                    "Controle las cantidades en general y si se excede intente compensar en la siguiente ingesta o en días posteriores.\n" +
                    "Realice ejercicio físico con una frecuencia mínima de 3 veces a la semana.\n" +
                    "Coma sentado, despacio y masticando muy bien los alimentos. De bocados pequeños con pequeñas cantidades.\n" +
                    "Entre bocado y bocado, deje los cubiertos sobre la mesa.\n" +
                    "Coma en un lugar concreto, no coma caminando en lugares improvisados o de paso \n" +
                    "Los dulces y los snacks salados son alimentos de consumo ocasional por lo que no están prohibidos, sino limitados.\n" +
                    "Coma sentado, despacio y mastique muy bien los alimentos.\n" +
                    "Coma en un lugar concreto, no coma caminando en lugares improvisados o de paso.\n" +
                    "Mientras coma no lea ni vea la televisión.";
        else
            mensaje = "La mejor forma para cambiar algunos de tus hábitos y emprender un nuevo estilo de vida es, simplemente negarte al sedentarismo\n" +
                    "Para ponerse en marcha no es necesario que la actividad física sea un deporte: se trata simplemente de que nos mantenga activos\n" +
                    "Lo más adecuado es empezar por una actividad que se adapte a tu estilo de vida (nada más sencillo, por ejemplo, que prescindir un poco del mando a distancia, utilizar menos los ascensores, salir a pasear a menudo, etc.)\n" +
                    "Recuerda que la mejor actividad física es aquella que puedes incorporar a tu vida diaria y convertirla en un hábit. \n" +
                    "Es fundamental limitar el uso de las grasas; hoy día, la grasa que empleamos principalmente es el aceite de oliva (piensa que es como usar tocino, engorda lo mismo o más que él, tanto en crudo como en caliente; aunque sea más cardiosaludable, es una grasa pura como el tocino, manteca etc.)\n" +
                    "No te saltes las comidas porque después tendrás más hambre en la siguiente\n" +
                    "Es conveniente que bebas una gran cantidad de agua también fuera de las comidas (6 a 8 vasos al día)\n" +
                    "No utilices azúcar para endulzar de forma habitual, es preferible utilizar sacarina o aspartamo";
        return mensaje;
    }
    private void CalcularIMC() {
        String nombre = etNombre.getText().toString();
        Double altura = Double.valueOf(etAltura.getText().toString());
        Double peso = Double.valueOf(etPeso.getText().toString());
        double IMC = peso / Math.pow(altura,2);

        /*Toast.makeText(this, "Tu IMC es" + String.format("%.2f", IMC) + MensajeIMC(IMC), Toast.LENGTH_LONG).show();
        if(rbMujer.isChecked() == true)
            Toast.makeText(this, "Eres Mujer", Toast.LENGTH_LONG).show();
        else if(rbVaron.isChecked() == true)
            Toast.makeText(this, "Eres Varon", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "No eligio gènero", Toast.LENGTH_LONG).show();*/


    }






}