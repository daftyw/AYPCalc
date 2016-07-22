package com.augmentis.ayp.calculator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rawin on 22-Jul-16.
 */
public class CalculationStack implements Serializable {
    private List<CalculationObject> calculationObjectList;
    private float result;

    public CalculationStack() {
        calculationObjectList = new ArrayList<>();
    }

    public void add(float number) {
        calculationObjectList.add(new Number(number));
    }

    public float getResult() {
        calculate();
        return result;
    }

    private void calculate() {
        Operator lastOperator = null;

        for(CalculationObject o : calculationObjectList) {
            if(o instanceof Number) {
                if(lastOperator != null) {
                    result = operate(lastOperator, new Number(result), (Number) o);
                    lastOperator = null;
                } else {
                    result = ((Number) o).number;
                }
            } else if(o instanceof Operator) {
                lastOperator = (Operator) o;
            }
        }

    }

    private float operate(Operator o, Number n1, Number n2) {
        switch (o.operator) {
            case ADD: return n1.number + n2.number;
            case SUB: return n1.number - n2.number;
            case DIVIDE: return n1.number / n2.number;
            case MULTIPLY: return n1.number * n2.number;
        }
        throw new UnsupportedOperationException("Not supported other operator");
    }

    public void add(String operator) {
        int lastIndex = calculationObjectList.size() - 1;
        CalculationObject o = calculationObjectList.get(lastIndex);
        if(o instanceof Operator) {
            calculationObjectList.remove(lastIndex);
        }

        calculationObjectList.add(new Operator(operator));
    }

    public void clear() {
        result = 0;
        calculationObjectList.clear();
    }

    static class CalculationObject {

    }

    static class Number extends CalculationObject {
        float number;

        Number(float v) {
            number = v;
        }
    }

    public enum EnumOperator {
        ADD, SUB, DIVIDE, MULTIPLY;
    }
    static class Operator extends CalculationObject {
        EnumOperator operator;

        Operator(String o) {
            if("+".equals(o)) {
                operator = EnumOperator.ADD;
            }
            if("-".equals(o)) {
                operator = EnumOperator.SUB;
            }
            if("*".equals(o)) {
                operator = EnumOperator.MULTIPLY;
            }
            if("/".equals(o)) {
                operator = EnumOperator.DIVIDE;
            }
        }
    }

}
