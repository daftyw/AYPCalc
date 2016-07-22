package com.augmentis.ayp.calculator;

/**
 * Created by Rawin on 22-Jul-16.
 */
public class Calculator {

    String temp = "";
    int mainNumber = 0;
    String currentOperator;
    int result;
    String primaryScreen;
    String secondaryScreen;
    int operatorCount = 0;

    public void pressNumber(String numberText) {
        temp += numberText;

        primaryScreen = String.valueOf(Integer.parseInt(temp));
    }

    public void pressOperator(String operatorText) {
        if(operatorCount == 0) {
            mainNumber = Integer.valueOf(temp);
            currentOperator = operatorText;

            primaryScreen = temp;
            temp = "";
            secondaryScreen = mainNumber + " " + operatorText;

        } else {
            int tod=0;
            int temp = Integer.valueOf(this.temp);
            if (currentOperator.equals("+")) {
                tod = mainNumber + temp;
            } else if (currentOperator.equals("-")) {
                tod = mainNumber - temp;
            } else if (currentOperator.equals("/")) {
                tod = mainNumber / temp;
            } else if (currentOperator.equals("*")) {
                tod = mainNumber * temp;
            }

            mainNumber = tod;
            this.temp = "";
            currentOperator = operatorText;

        }

        operatorCount++;
    }

    public void pressEqual() {
        int temp = Integer.valueOf(this.temp);

        if (currentOperator.equals("+")) {
            result = mainNumber + temp;
        } else if (currentOperator.equals("-")) {
            result = mainNumber - temp;
        } else if (currentOperator.equals("/")) {
            result = mainNumber / temp;
        } else if (currentOperator.equals("*")) {
            result = mainNumber * temp;
        }

        operatorCount= 0;

    }

    public int getResult() {
        return result;
    }

    public String getPrimaryScreen() {
        return primaryScreen;
    }

    public String getSecondaryScreen() {
        return secondaryScreen;
    }
}
