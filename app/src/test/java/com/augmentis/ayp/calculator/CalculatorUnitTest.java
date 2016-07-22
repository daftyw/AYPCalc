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

        assertEquals("2", calculator.getPrimaryScreen());
        assertEquals("", calculator.getSecondaryScreen());
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

        assertEquals("101 +", calculator.getSecondaryScreen());

        calculator.pressEqual();

        assertEquals("112", calculator.getPrimaryScreen());
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

        assertEquals("100 *", calculator.getSecondaryScreen());
        calculator.pressEqual();
        assertEquals("1000", calculator.getPrimaryScreen());
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

        assertEquals("100 -", calculator.getSecondaryScreen());
        calculator.pressEqual();
        assertEquals("90", calculator.getPrimaryScreen());
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

        assertEquals("100 /", calculator.getSecondaryScreen());
        calculator.pressEqual();
        assertEquals("10", calculator.getPrimaryScreen());
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
        assertEquals("100 - 10 -", calculator.getSecondaryScreen());
        calculator.pressEqual();

        assertEquals("80", calculator.getPrimaryScreen());
    }

    @Test
    public void test_10_add_sub_1_equals_9() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("1");
        calculator.pressNumber("0");
        calculator.pressOperator("+");
        calculator.pressOperator("-");
        calculator.pressNumber("1");

        assertEquals("10 -", calculator.getSecondaryScreen());
        calculator.pressEqual();

        assertEquals("9", calculator.getPrimaryScreen());
    }

    @Test
    public void test_011_add_1_equals_12() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("0");
        calculator.pressNumber("1");
        calculator.pressNumber("1");
        calculator.pressOperator("+");
        calculator.pressNumber("1");

        assertEquals("11 +", calculator.getSecondaryScreen());
        calculator.pressEqual();

        assertEquals("12", calculator.getPrimaryScreen());
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

    @Test
    public void test_011_multiply_2_sub_3_sub_2_divide_2_result_11() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("0");
        calculator.pressNumber("1");
        calculator.pressNumber("1");
        calculator.pressOperator("*");
        calculator.pressNumber("2");
        calculator.pressOperator("-");
        calculator.pressNumber("3");
        calculator.pressOperator("-");
        calculator.pressNumber("2");
        calculator.pressOperator("/");
        calculator.pressNumber("2");

        String result = calculator.getPrimaryScreen();
        assertEquals("2", result);

        calculator.pressEqual();
        assertEquals("8.5", calculator.getPrimaryScreen());

    }

    @Test
    public void test_2_sub_clear() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("2");
        calculator.pressOperator("-");
        calculator.pressClear();

        assertEquals("0", calculator.getPrimaryScreen());
        assertEquals("", calculator.getSecondaryScreen());
    }

    @Test
    public void test_start_calc() {
        Calculator calculator = new Calculator();
        assertEquals("0", calculator.primaryScreen);
        assertEquals("", calculator.secondaryScreen);
    }

    @Test
    public void test_3_add_3_clear_3_add_5_equals_8() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("3");
        calculator.pressOperator("+");
        calculator.pressNumber("3");
        calculator.pressClear();

        assertEquals("0", calculator.primaryScreen);

        calculator.pressNumber("3");
        calculator.pressOperator("+");
        calculator.pressNumber("5");
        calculator.pressEqual();

        assertEquals("8", calculator.primaryScreen);
    }

    @Test
    public void test_7_divide_22_equals_0_dot_318181813() {
        Calculator calculator = new Calculator();
        calculator.pressNumber("7");
        calculator.pressOperator("/");
        calculator.pressNumber("22");

        assertEquals("0.318181813", calculator.primaryScreen);
    }


}
