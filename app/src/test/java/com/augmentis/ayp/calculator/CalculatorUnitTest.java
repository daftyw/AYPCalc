package com.augmentis.ayp.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class CalculatorUnitTest {
    @Test
    public void test_1_add_1_equals_2() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("1");
        calculator.pressOperator("+");
        calculator.pressNumber("1");
        calculator.pressEqual();
        int calculatorResult = calculator.getResult();

        assertEquals(2, calculatorResult);
    }

    @Test
    public void test_101_add_11_equals_112() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("1");
        calculator.pressNumber("0");
        calculator.pressNumber("1");
        calculator.pressOperator("+");
        calculator.pressNumber("1");
        calculator.pressNumber("1");
        calculator.pressEqual();
        int calculatorResult = calculator.getResult();

        assertEquals(112, calculatorResult);
    }

    @Test
    public void test_100_multiply_10_equals_1000() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("1");
        calculator.pressNumber("0");
        calculator.pressNumber("0");
        calculator.pressOperator("*");
        calculator.pressNumber("1");
        calculator.pressNumber("0");
        calculator.pressEqual();
        int calculatorResult = calculator.getResult();

        assertEquals(1000, calculatorResult);
    }

    @Test
    public void test_100_sub_10_equals_90() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("1");
        calculator.pressNumber("0");
        calculator.pressNumber("0");
        calculator.pressOperator("-");
        calculator.pressNumber("1");
        calculator.pressNumber("0");
        calculator.pressEqual();
        int calculatorResult = calculator.getResult();

        assertEquals(90, calculatorResult);
    }

    @Test
    public void test_100_divide_10_equals_10() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("1");
        calculator.pressNumber("0");
        calculator.pressNumber("0");
        calculator.pressOperator("/");
        calculator.pressNumber("1");
        calculator.pressNumber("0");
        calculator.pressEqual();
        int calculatorResult = calculator.getResult();

        assertEquals(10, calculatorResult);
    }

    @Test
    public void test_1_add_1_show_second_screen_correct() {
        Calculator calculator = new Calculator();

        calculator.pressNumber("1");
        calculator.pressOperator("+");
        String primaryScreen = calculator.getPrimaryScreen();
        String secondaryScreen = calculator.getSecondaryScreen();

        assertEquals("1", primaryScreen);
        assertEquals("1 +", secondaryScreen);
    }


    @Test
    public void test_100_sub_10_sub_10_equals_80() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("1");
        calculator.pressNumber("0");
        calculator.pressNumber("0");
        calculator.pressOperator("-");
        calculator.pressNumber("1");
        calculator.pressNumber("0");
        calculator.pressOperator("-");
        calculator.pressNumber("1");
        calculator.pressNumber("0");
        calculator.pressEqual();
        int calculatorResult = calculator.getResult();

        assertEquals(80, calculatorResult);
    }

    @Test
    public void test_011_add_1_equals_12() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("0");
        calculator.pressNumber("1");
        calculator.pressNumber("1");
        calculator.pressOperator("+");
        calculator.pressNumber("1");
        calculator.pressEqual();

        int result = calculator.getResult();
        assertEquals(12, result);
    }

    @Test
    public void test_011_add_1_primaryScreen_11() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("0");
        calculator.pressNumber("1");
        calculator.pressNumber("1");

        String result = calculator.getPrimaryScreen();
        assertEquals("11", result);
    }
}