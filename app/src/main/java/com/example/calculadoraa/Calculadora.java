package com.example.calculadoraa;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Calculator se encarga de realizar las operaciones aritméticas.
 * Soporta operaciones básicas como suma, resta, multiplicación y división.
 * Esta clase no tiene interacción con la interfaz de usuario.
 *
 * @version 1.0.0
 * @since 1.0.0
 * @author Salva
 */
public class Calculadora {

    /**
     * Realiza el cálculo basado en una cadena de entrada.
     *
     * @param input la cadena de entrada que contiene los números y operadores.
     * @return el resultado del cálculo o -1 si hay un error.
     */
    public int calculate(String input) {
        String[] partes = input.split(" ");
        if (partes.length < 3 || partes.length % 2 == 0) {
            return -1;
        }

        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        try {
            numbers.add(Integer.parseInt(partes[0]));

            for (int i = 1; i < partes.length; i += 2) {
                operators.add(partes[i]);
                numbers.add(Integer.parseInt(partes[i + 1]));
            }

            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i).equals("*") || operators.get(i).equals("/")) {
                    int num1 = numbers.get(i);
                    int num2 = numbers.get(i + 1);
                    int result;

                    if (operators.get(i).equals("*")) {
                        result = num1 * num2;
                    } else {
                        if (num2 == 0) {
                            return -1;
                        }
                        result = num1 / num2;
                    }

                    numbers.set(i, result);
                    numbers.remove(i + 1);
                    operators.remove(i);
                    i--;
                }
            }

            int resultado = numbers.get(0);
            for (int i = 0; i < operators.size(); i++) {
                String operador = operators.get(i);
                int num = numbers.get(i + 1);

                if (operador.equals("+")) {
                    resultado += num;
                } else if (operador.equals("-")) {
                    resultado -= num;
                }
            }

            return resultado;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
