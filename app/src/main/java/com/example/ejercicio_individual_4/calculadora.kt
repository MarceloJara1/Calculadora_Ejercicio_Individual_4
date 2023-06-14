package com.example.ejercicio_individual_4

import android.text.TextUtils
import android.widget.EditText

class calculadora(private val numero_1: EditText, private val numero_2: EditText) {
    fun obtenerNumero1(): Int {
        val strNumero1 = numero_1.text.toString()
        return strNumero1.toInt()
    }

    fun obtenerNumero2(): Int {
        val strNumero2 = numero_2.text.toString()
        return strNumero2.toInt()
    }

    fun sumar(): Int {
        val numero1 = obtenerNumero1()
        val numero2 = obtenerNumero2()
        return numero1 + numero2
    }

    fun restar(): Int {
        val numero1 = obtenerNumero1()
        val numero2 = obtenerNumero2()
        return numero1 - numero2
    }

    fun multiplicar(): Int {
        val numero1 = obtenerNumero1()
        val numero2 = obtenerNumero2()
        return numero1 * numero2
    }

    fun dividir(): Double {
        val numero1 = obtenerNumero1()
        val numero2 = obtenerNumero2()
        if (numero2 == 0) {
            throw ArithmeticException("No se puede dividir entre 0")
        }
        return numero1.toDouble() / numero2
    }

    //Validar datos
    fun validarCampos(): Boolean {
        val strNumero1 = numero_1.text.toString()
        val strNumero2 = numero_2.text.toString()
        return !TextUtils.isEmpty(strNumero1) && !TextUtils.isEmpty(strNumero2)
    }
}