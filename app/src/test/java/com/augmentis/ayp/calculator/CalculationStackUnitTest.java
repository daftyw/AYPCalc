package com.augmentis.ayp.calculator;

import android.animation.FloatArrayEvaluator;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Rawin on 22-Jul-16.
 */
public class CalculationStackUnitTest {
    @Test
    public void test_1_add_1_eq_2() {
        CalculationStack calculationStack = new CalculationStack();

        calculationStack.add(1);
        calculationStack.add("+");
        calculationStack.add(1);

        float result = calculationStack.getResult();

        assertEquals(Float.valueOf(2f), Float.valueOf(result));
    }

    @Test
    public void test_1_sub_1_eq_0() {
        CalculationStack calculationStack = new CalculationStack();

        calculationStack.add(1);
        calculationStack.add("-");
        calculationStack.add(1);

        float result = calculationStack.getResult();

        assertEquals(Float.valueOf(0), Float.valueOf(result));
    }

    @Test
    public void test_1_sub_add_1_eq_2() {
        CalculationStack calculationStack = new CalculationStack();

        calculationStack.add(1);
        calculationStack.add("-");
        calculationStack.add("+");
        calculationStack.add(1);

        float result = calculationStack.getResult();

        assertEquals(Float.valueOf(2), Float.valueOf(result));
    }


    @Test
    public void test_1_sub_add_multiply_1_eq_1() {
        CalculationStack calculationStack = new CalculationStack();

        calculationStack.add(1);
        calculationStack.add("-");
        calculationStack.add("+");
        calculationStack.add("*");
        calculationStack.add(1);

        float result = calculationStack.getResult();

        assertEquals(Float.valueOf(1), Float.valueOf(result));
    }

    @Test
    public void test_5_sub_3_add_7_multiply_8_eq_72() {
        CalculationStack calculationStack = new CalculationStack();

        calculationStack.add(5);
        calculationStack.add("-");
        calculationStack.add(3);
        calculationStack.add("+");
        calculationStack.add(7);
        calculationStack.add("*");
        calculationStack.add(8);

        float result = calculationStack.getResult();

        assertEquals(Float.valueOf(72), Float.valueOf(result));
    }

    @Test
    public void test_5_sub_3_add_7_multiply_eq_9() {
        CalculationStack calculationStack = new CalculationStack();

        calculationStack.add(5);
        calculationStack.add("-");
        calculationStack.add(3);
        calculationStack.add("+");
        calculationStack.add(7);
        calculationStack.add("*");

        float result = calculationStack.getResult();

        assertEquals(Float.valueOf(9), Float.valueOf(result));
    }

    @Test
    public void test_5_result_5() {
        CalculationStack calculationStack = new CalculationStack();

        calculationStack.add(5);

        float result = calculationStack.getResult();

        assertEquals(Float.valueOf(5), Float.valueOf(result));
    }

    @Test
    public void test_5_add_result_5() {
        CalculationStack calculationStack = new CalculationStack();

        calculationStack.add(5);
        calculationStack.add("+");

        float result = calculationStack.getResult();

        assertEquals(Float.valueOf(5), Float.valueOf(result));
    }

    @Test
    public void test_clear() {
        CalculationStack calculationStack = new CalculationStack();
        calculationStack.add(2);
        calculationStack.clear();

        float result = calculationStack.getResult();

        assertEquals(Float.valueOf(0), Float.valueOf(result));
    }
}
