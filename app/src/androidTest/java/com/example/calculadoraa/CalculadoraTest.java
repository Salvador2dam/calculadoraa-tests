package com.example.calculadoraa;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

    private Calculadora calculadora;

    @Before
    public void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void testAdd2Operands() {
        int total = calculadora.calculate("5 + 3");
        assertEquals("5 + 3 should be 8", 8, total);
    }

    @Test
    public void testAdd3Operands() {
        int total = calculadora.calculate("4 + 3 + 1");
        assertEquals("4 + 3 + 1 should be 8", 8, total);
    }

    @Test
    public void testMult2Operands() {
        int total = calculadora.calculate("4 * 2");
        assertEquals("4 * 2 should be 8", 8, total);
    }

    @Test
    public void testComplexOperations() {
        int total1 = calculadora.calculate("2 * 3");
        assertEquals("2 * 3 should be 6", 6, total1);

        int total2 = calculadora.calculate("1 * 2 * 8");
        assertEquals("1 * 2 * 8 should be 16", 16, total2);

        int total3 = calculadora.calculate("2 * 2 + 3");
        assertEquals("2 * 2 + 3 should be 7", 7, total3);

        int total4 = calculadora.calculate("3 + 2 * 2");
        assertEquals("3 + 2 * 2 should be 7", 7, total4);

        int total5 = calculadora.calculate("3 + 2 * 2 + 4");
        assertEquals("3 + 2 * 2 + 4 should be 11", 11, total5);
    }
}
