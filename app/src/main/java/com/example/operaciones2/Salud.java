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
            mensaje = "Las personas con un bajo peso tienden a estar muy cansadas y con tendencia al agotamiento. La falta de nutrientes tambi??n puede agotar el sistema inmunol??gico, haciendote mucho m??s susceptible a las enfermedades e infecciones.\n" +
                    "El bajo consumo de hierro puede provocar anemia, transportamos menos ox??geno en la sangre, y se aumentan los sentimientos de agotamiento y se reducen las funciones en los ??rganos. Las vitaminas A y C son de particular importancia para la salud y tener un peso bajo puede significar que no tienes las reservas necesarias para prevenir enfermedades como el resfriado com??n o el c??ncer. \n" +
                    "Tener un mal sistema inmunol??gico puede hacer que tu cuerpo le sea m??s dif??cil combatir los virus que contribuyen a desarrollar enfermedades.";
        else if (IMC >=17 & IMC <=18.49)
            mensaje = "Los tratamientos convencionales para el aumento de peso dependen en gran medida de la causa de la p??rdida de peso. Para ayudar a comenzar la restauraci??n de nutrientes en las personas delgadas, alta en calor??as, suplementos nutricionales de vitaminas compactas son a menudo utilizadas pararevitalizar el cuerpo.\n" +
                    " Si hay un trastorno psicol??gico detr??s de la p??rdida de peso, como la anorexia o la bulimia, el asesoramiento puede ayudar a volver a un peso saludable.";
        else if (IMC >=18.50 & IMC <=24.99)
            mensaje = "Mantener la rutina de las comidas, elegir comida baja en grasas, caminar para perder peso, leer las etiquetas de lo que comemos, vigilar el tama??o de las raciones, levantarse de la mesa, pensar antes de beber, tomarnos nuestro tiempo, y no olvidar las 5 raciones diarias de fruta y verdura.";
        else if (IMC >=25 & IMC <=29.99)
            mensaje = "Sabemos que el exceso de peso es perjudicial para la salud, pero no todo est?? perdido y la soluci??n, en la mayor??a de los casos, est?? al alcance de la mano. La buena noticia es que estas enfermedades se pueden prevenir a trav??s de unos h??bitos de vida saludable, como son la alimentaci??n y realizar ejercicio de forma regular.";
        else if (IMC >=30 & IMC <=34.99)
            mensaje = "La alimentaci??n debe ser variada, equilibrada, suficiente y placentera.\n" +
                    "Planifique las comidas del d??a con antelaci??n para disponer siempre de alimentos saludables listos para consumir.\n" +
                    "Consuma frutas y verduras de temporada, enteras y al menos dos veces al d??a.\n" +
                    "Incluya las legumbres semanalmente m??s de 4 veces a la semana.\n" +
                    "Aumente el consumo de pescado fresco (blanco y azul), y deje las conservas para momentos puntuales\n" +
                    "Mantenga un ritmo de ingesta a lo largo del d??a para llegar saciado a las comidas principales.\n" +
                    "Planifique las comidas y cenas con antelaci??n para que siempre disponga de alimentos saludables listos para consumir.\n" +
                    "Organice el men?? semanal dando prioridad a los alimentos de temporada.\n" +
                    "Equilibre su plato entre prote??nas, hidratos de carbono y verduras.\n" +
                    "Aumente la frecuencia de consumo semanal de legumbres como fuente de hidratos de carbono.";
        else if (IMC >=35 & IMC <=39.99)
            mensaje = "Priorice el pescado (blanco y azul) frente a la carne blanca o roja.\n" +
                    "Asegure el consumo diario de frutas y verduras para mejorar el tr??nsito intestinal.\n" +
                    "Beba agua diariamente y no la sustituya por refrescos aunque sean light o zero.\n" +
                    "Controle las cantidades en general y si se excede intente compensar en la siguiente ingesta o en d??as posteriores.\n" +
                    "Realice ejercicio f??sico con una frecuencia m??nima de 3 veces a la semana.\n" +
                    "Coma sentado, despacio y masticando muy bien los alimentos. De bocados peque??os con peque??as cantidades.\n" +
                    "Entre bocado y bocado, deje los cubiertos sobre la mesa.\n" +
                    "Coma en un lugar concreto, no coma caminando en lugares improvisados o de paso \n" +
                    "Los dulces y los snacks salados son alimentos de consumo ocasional por lo que no est??n prohibidos, sino limitados.\n" +
                    "Coma sentado, despacio y mastique muy bien los alimentos.\n" +
                    "Coma en un lugar concreto, no coma caminando en lugares improvisados o de paso.\n" +
                    "Mientras coma no lea ni vea la televisi??n.";
        else
            mensaje = "La mejor forma para cambiar algunos de tus h??bitos y emprender un nuevo estilo de vida es, simplemente negarte al sedentarismo\n" +
                    "Para ponerse en marcha no es necesario que la actividad f??sica sea un deporte: se trata simplemente de que nos mantenga activos\n" +
                    "Lo m??s adecuado es empezar por una actividad que se adapte a tu estilo de vida (nada m??s sencillo, por ejemplo, que prescindir un poco del mando a distancia, utilizar menos los ascensores, salir a pasear a menudo, etc.)\n" +
                    "Recuerda que la mejor actividad f??sica es aquella que puedes incorporar a tu vida diaria y convertirla en un h??bit. \n" +
                    "Es fundamental limitar el uso de las grasas; hoy d??a, la grasa que empleamos principalmente es el aceite de oliva (piensa que es como usar tocino, engorda lo mismo o m??s que ??l, tanto en crudo como en caliente; aunque sea m??s cardiosaludable, es una grasa pura como el tocino, manteca etc.)\n" +
                    "No te saltes las comidas porque despu??s tendr??s m??s hambre en la siguiente\n" +
                    "Es conveniente que bebas una gran cantidad de agua tambi??n fuera de las comidas (6 a 8 vasos al d??a)\n" +
                    "No utilices az??car para endulzar de forma habitual, es preferible utilizar sacarina o aspartamo";
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
            Toast.makeText(this, "No eligio g??nero", Toast.LENGTH_LONG).show();*/


    }






}