package com.example.calculadoraa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText resultadoPanel;
    private StringBuilder cadenaEntrada = new StringBuilder();
    private Calculadora calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultadoPanel = findViewById(R.id.resultadoPanel);
        calculator = new Calculadora();

        inicializarBotonesNumeros();
        inicializarBotonesOperaciones();
    }

    private void inicializarBotonesNumeros() {
        Button[] botonesNumeros = new Button[]{
                findViewById(R.id.boton0),
                findViewById(R.id.boton1),
                findViewById(R.id.boton2),
                findViewById(R.id.boton3),
                findViewById(R.id.boton4),
                findViewById(R.id.boton5),
                findViewById(R.id.boton6),
                findViewById(R.id.boton7),
                findViewById(R.id.boton8),
                findViewById(R.id.boton9)
        };

        for (Button boton : botonesNumeros) {
            boton.setOnClickListener(v -> {
                cadenaEntrada.append(boton.getText());
                resultadoPanel.setText(cadenaEntrada.toString());
            });
        }
    }

    private void inicializarBotonesOperaciones() {
        findViewById(R.id.botonSumar).setOnClickListener(v -> agregarOperacion("+"));
        findViewById(R.id.botonMenos).setOnClickListener(v -> agregarOperacion("-"));
        findViewById(R.id.botonMultiplicar).setOnClickListener(v -> agregarOperacion("*"));
        findViewById(R.id.botonDivide).setOnClickListener(v -> agregarOperacion("/"));
        findViewById(R.id.botonLimpiar).setOnClickListener(v -> limpiarEntrada());
        findViewById(R.id.botonIgual).setOnClickListener(v -> calcularYMostrarResultado());
    }

    private void agregarOperacion(String operacion) {
        cadenaEntrada.append(" ").append(operacion).append(" ");
        resultadoPanel.setText(cadenaEntrada.toString());
    }

    private void limpiarEntrada() {
        cadenaEntrada.setLength(0);
        resultadoPanel.setText("");
    }

    private void calcularYMostrarResultado() {
        int resultado = calculator.calculate(cadenaEntrada.toString());
        resultadoPanel.setText(String.valueOf(resultado));
        cadenaEntrada.setLength(0);
    }
}
