package com.example.ejercicio_individual_4;

import android.text.TextUtils;
import android.widget.EditText;

public class calculadora {
    private EditText numero_1;
    private EditText numero_2;


    public calculadora(EditText numero_1, EditText numero_2){
        this.numero_1 = numero_1;
        this.numero_2 = numero_2;
    }

    public int obtenerNumero1(){
        String strNumero1 = numero_1.getText().toString();
        return Integer.parseInt(strNumero1);
    }

    public int obtenerNumero2(){
        String strNumero2 = numero_2.getText().toString();
        return Integer.parseInt(strNumero2);
    }

    public int sumar(){
        int numero1 = obtenerNumero1();
        int numero2 = obtenerNumero2();
        return numero1 + numero2;
    }

    public int restar(){
        int numero1 = obtenerNumero1();
        int numero2 = obtenerNumero2();
        return numero1 - numero2;
    }

    public int multiplicar(){
        int numero1 = obtenerNumero1();
        int numero2 = obtenerNumero2();
        return numero1 * numero2;
    }

    public double dividir(){
        int numero1 = obtenerNumero1();
        int numero2 = obtenerNumero2();
        if (numero2 == 0){
            throw new ArithmeticException("No se puede dividir entre 0");
        }
        return (double) numero1 / numero2;
    }

    //Validar datos
    public boolean validarCampos(){
        String strNumero1 = numero_1.getText().toString();
        String strNumero2 = numero_2.getText().toString();

        return !TextUtils.isEmpty(strNumero1) && !TextUtils.isEmpty(strNumero2);
    }

}
