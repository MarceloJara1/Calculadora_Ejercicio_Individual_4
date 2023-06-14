package com.example.ejercicio_individual_4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat



/*
*   Los principales cambios con respecto a java son la declaracion de variables, el como se crean
*   las funciones, para comprobar que un valor no es nulo se utiliza !! y para llamar a las variables
*   usamos $
*
* */
class MainActivity : AppCompatActivity() {
    var calc: calculadora? = null
    lateinit var numero_1: EditText
    lateinit var numero_2: EditText
    lateinit var buttonSumar: Button
    lateinit var buttonRestar: Button
    lateinit var buttonMultiplicar: Button
    lateinit var buttonDividir: Button
    lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtener referencias desde los editText
        numero_1 = findViewById<View>(R.id.inputPrimerNumero) as EditText
        numero_2 = findViewById<View>(R.id.inputSegundoNumero) as EditText
        buttonSumar = findViewById<View>(R.id.buttonSum) as Button
        buttonRestar = findViewById<View>(R.id.buttonRes) as Button
        buttonMultiplicar = findViewById<View>(R.id.buttonMul) as Button
        buttonDividir = findViewById<View>(R.id.buttonDiv) as Button
        txtResultado = findViewById<View>(R.id.txtResultado) as TextView
        //Crear instancia en la clase calculadora
        calc = calculadora(numero_1, numero_2)

        //Configurar clickListener para los botones

        //Sumar
        buttonSumar!!.setOnClickListener {
            if (calc!!.validarCampos()) {
                //Obtener valores de los editText
                val numero1 = calc!!.obtenerNumero1()
                val numero2 = calc!!.obtenerNumero2()


                //Realizamos la operacion y mostramos el resultado
                val resultado = calc!!.sumar()
                txtResultado!!.text = "$numero1 + $numero2 = $resultado"
            } else {
                Toast.makeText(this@MainActivity, "Por favor, ingrese los dos números", Toast.LENGTH_SHORT).show()
            }
        }

        //Restar
        buttonRestar!!.setOnClickListener {
            if (calc!!.validarCampos()) {
                val numero1 = calc!!.obtenerNumero1()
                val numero2 = calc!!.obtenerNumero2()
                val resultado = calc!!.restar()
                txtResultado!!.text = "$numero1 - $numero2 = $resultado"
            } else {
                Toast.makeText(this@MainActivity, "Por favor, ingrese los dos números", Toast.LENGTH_SHORT).show()
            }
        }

        //Multiplicar
        buttonMultiplicar!!.setOnClickListener {
            if (calc!!.validarCampos()) {
                val numero1 = calc!!.obtenerNumero1()
                val numero2 = calc!!.obtenerNumero2()
                val resultado = calc!!.multiplicar()
                txtResultado!!.text = "$numero1 * $numero2 = $resultado"
            } else {
                Toast.makeText(this@MainActivity, "Por favor, ingrese los dos números", Toast.LENGTH_SHORT).show()
            }
        }

        //Dividir
        buttonDividir!!.setOnClickListener {
            if (calc!!.validarCampos()) {
                val numero1 = calc!!.obtenerNumero1()
                val numero2 = calc!!.obtenerNumero2()
                try {
                    val resultado = calc!!.dividir()
                    val decimalFormat = DecimalFormat("0.00")
                    txtResultado!!.text = numero1.toString() + " / " + numero2 + " = " + decimalFormat.format(resultado)
                } catch (e: ArithmeticException) {
                    Toast.makeText(this@MainActivity, "Error: " + e.message, Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "Por favor, ingrese los dos números", Toast.LENGTH_SHORT).show()
            }
        }

        //Boton salir
        val buttonSalir = findViewById<Button>(R.id.buttonSalir)
        buttonSalir.setOnClickListener {
            finish() // Cierra la aplicacion si no hay mas actividades en la pila.
        }
    }
}