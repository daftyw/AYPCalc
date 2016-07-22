package com.augmentis.ayp.calculator;

import java.text.DecimalFormat;

/**
 * Created by Rawin on 22-Jul-16.
 */
public class Calculator {

    String screenBuffer;
    String primaryScreen;
    String secondaryScreen;
    CalculationStack calculationStack;
    DecimalFormat decimalFormat;
    boolean pressingOperator;

    protected Calculator () {
        calculationStack = new CalculationStack();
        secondaryScreen = "";
        decimalFormat = new DecimalFormat("0.#########");
        primaryScreen = "0";
        pressingOperator = false;
        screenBuffer = "";
    }

    public void pressNumber(String numberText) {
        screenBuffer += numberText;

        primaryScreen = String.valueOf(Integer.parseInt(screenBuffer));
        pressingOperator = false;
    }

    public void pressOperator(String operatorText) {
        if(pressingOperator) {
            // add to stack
            calculationStack.add(operatorText);

            // replace
            int len = secondaryScreen.length();
            String oldParse = secondaryScreen.substring(0, len - 1 );
            secondaryScreen = oldParse + operatorText;

        } else {
            float f = Float.valueOf(primaryScreen);
            calculationStack.add(Float.valueOf(primaryScreen));
            calculationStack.add(operatorText);

            if (secondaryScreen.length() > 0) {
                secondaryScreen += " ";
            }

            secondaryScreen += decimalFormat.format(f) + " " + operatorText;
            primaryScreen = decimalFormat.format(calculationStack.getResult());
            screenBuffer = "";
            pressingOperator = true;
        }
    }

    public void pressEqual() {
        if(!screenBuffer.equals("")) {
            calculationStack.add(Float.valueOf(screenBuffer));
        }

        primaryScreen = decimalFormat.format(calculationStack.getResult());
        secondaryScreen = "";
        calculationStack.clear();
    }

    public void pressClear() {
        calculationStack.clear();
        primaryScreen = "0";
        secondaryScreen = "";
        screenBuffer = "";
    }

    public String getPrimaryScreen() {
        return primaryScreen;
    }

    public String getSecondaryScreen() {
        return secondaryScreen;
    }
}
