package com.example.ejercicio_individual_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private calculadora calc;
    private EditText numero_1;
    private EditText numero_2;
    private Button buttonSumar;
    private Button buttonRestar;
    private Button buttonMultiplicar;
    private Button buttonDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtener referencias desde los editText
        EditText numero_1 = (EditText) findViewById(R.id.inputPrimerNumero);
        EditText numero_2 = (EditText) findViewById(R.id.inputSegundoNumero);
        buttonSumar = (Button) findViewById(R.id.buttonSum);
        buttonRestar = (Button)findViewById(R.id.buttonRes);
        buttonMultiplicar = (Button)findViewById(R.id.buttonMul);
        buttonDividir = (Button) findViewById(R.id.buttonDiv);

        //Crear instancia en la clase calculadora
        calc = new calculadora(numero_1, numero_2);

        //Configurar clickListener para los botones

        //Sumar
        buttonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calc.validarCampos()) {
                    //Obtener valores de los editText
                    int numero1 = calc.obtenerNumero1();
                    int numero2 = calc.obtenerNumero2();


                    //Realizamos la operacion y mostramos el resultado
                    int resultado = calc.sumar();
                    Toast.makeText(MainActivity.this, "El resultado de la suma es: " + resultado, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Por favor, ingrese los dos números", Toast.LENGTH_SHORT).show();
                }
        }
        });

        //Restar
        buttonRestar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calc.validarCampos()) {
                    int numero1 = calc.obtenerNumero1();
                    int numero2 = calc.obtenerNumero2();

                    int resultado = calc.restar();
                    Toast.makeText(MainActivity.this, "El resultado de la resta es: " + resultado, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Por favor, ingrese los dos números", Toast.LENGTH_SHORT).show();
                }
        }
        }));

        //Multiplicar
        buttonMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calc.validarCampos()) {
                    int numero1 = calc.obtenerNumero1();
                    int numero2 = calc.obtenerNumero2();

                    int resultado = calc.multiplicar();
                    Toast.makeText(MainActivity.this, "El resultado de la multiplicación es: " + resultado, Toast.LENGTH_SHORT).show();
                }else {
                        Toast.makeText(MainActivity.this, "Por favor, ingrese los dos números", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        //Dividir
        buttonDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calc.validarCampos()) {
                    int numero1 = calc.obtenerNumero1();
                    int numero2 = calc.obtenerNumero2();

                    try {
                        double resultado = calc.dividir();
                        Toast.makeText(MainActivity.this, "El resultado de la división es: " + resultado, Toast.LENGTH_SHORT).show();
                    } catch (ArithmeticException e) {
                        Toast.makeText(MainActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, ingrese los dos números", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Boton salir
        Button buttonSalir = findViewById(R.id.buttonSalir);

        buttonSalir.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               finish(); // Cierra la aplicacion si no hay mas actividades en la pila.
           }
        });
    }
}