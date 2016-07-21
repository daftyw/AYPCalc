package com.augmentis.ayp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    private static final String TAG = "Calc_Act";
    int[] numberIds = new int[] {
            R.id.numberButton0,
            R.id.numberButton1,
            R.id.numberButton2,
            R.id.numberButton3,
            R.id.numberButton4,
            R.id.numberButton5,
            R.id.numberButton6,
            R.id.numberButton7,
            R.id.numberButton8,
            R.id.numberButton9,
    };

    int[] operatorIds = new int[] {
            R.id.addButton,
            R.id.subButton,
            R.id.divideButton,
            R.id.multiplyButton
    };


    Button equalButton;
    Button clearButton;

    TextView primaryScreen;
    TextView secondaryScreen;

    int currentNumber;
    int tod;

    String primaryBuffer;
    String secondaryBuffer;
    String currentOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        currentNumber = 0;
        primaryBuffer = String.valueOf(currentNumber);   // <-- Convert int to String
        secondaryBuffer = "";
        bindScreens();
        bindButtons(); // bind buttons
        updateUI();
    }

    private void bindScreens() {
        primaryScreen = (TextView) findViewById(R.id.primary_text);
        secondaryScreen = (TextView) findViewById(R.id.secondary_text);
    }

    Button[] numberButtons ;
    Button[] operatorButtons ;
    boolean resetBuffer = false;

    private void bindButtons() {
        int l = numberIds.length;
        numberButtons = new Button[l];
        for (int i = 0; i < l; i++) {
            numberButtons[i] = (Button) findViewById(numberIds[i]);

            numberButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button thisButton = (Button) v;

                    setNumber(thisButton.getText());
                    updateUI();
                }
            });
        }

        l = operatorIds.length;
        operatorButtons = new Button[l];
        for (int i = 0; i < l; i++) {
            operatorButtons[i] = (Button) findViewById(operatorIds[i]);

            operatorButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button thisButton = (Button) view;

                    setOperator(thisButton.getText());
                    updateUI();
                }
            });
        }

        equalButton = (Button) findViewById(R.id.equalButton);
        equalButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                calcResult();
                updateUI();
            }
        });
        clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                clear();
                updateUI();
            }
        });
    }

    private void setOperator(CharSequence operator) {
        Log.d(TAG, "Got " + operator);

        int tempBuffer = Integer.valueOf(primaryBuffer);
        int result = 0;

        if( currentNumber != 0 ) {

            if (currentOperator.equals("+")) {
                result = currentNumber + tempBuffer;
            } else if (currentOperator.equals("-")) {
                result = currentNumber - tempBuffer;
            } else if (currentOperator.equals("/")) {
                result = currentNumber / tempBuffer;
            } else if (currentOperator.equals("*")) {
                result = currentNumber * tempBuffer;
            }

            currentNumber = result;
            currentOperator = operator.toString();

            // display
            secondaryBuffer += " " + tempBuffer + " " + currentOperator;

        } else {
            currentNumber = tempBuffer;
            currentOperator = operator.toString();

            // display
            secondaryBuffer = currentNumber + " " + currentOperator;
        }

        resetBuffer = true;
        Log.d(TAG, "currentNumber = " + currentNumber);
    }

    private void setNumber(CharSequence number) {
        Log.d(TAG, "Got " + number);

        if(primaryBuffer.equals("0")) {
            primaryBuffer = "";
        }

        if(resetBuffer) {
            primaryBuffer = "";
            resetBuffer = false;
        }

        primaryBuffer = primaryBuffer + number;
    }

    private void clear() {
        Log.d(TAG, "Clear !!");

        currentNumber = 0;
        primaryBuffer = String.valueOf(currentNumber);
        secondaryBuffer = "";
    }

    /**
     *
     */
    private void calcResult() {
        Log.d(TAG, "Calculates !!");

        int result = 0;

        if(currentOperator.equals("+")) {
            result = currentNumber + Integer.valueOf(primaryBuffer);
        } else if(currentOperator.equals("-")) {
            result = currentNumber - Integer.valueOf(primaryBuffer);
        } else if(currentOperator.equals("/")) {
            result = currentNumber / Integer.valueOf(primaryBuffer);
        } else if(currentOperator.equals("*")) {
            result = currentNumber * Integer.valueOf(primaryBuffer);
        }

        currentNumber = 0;
        primaryBuffer = String.valueOf(result);
        secondaryBuffer = "";
    }

    private void updateUI() {
        Log.d(TAG, "Update UI");
        Log.d(TAG, "Primary = " + primaryBuffer + ", Secondary = " + secondaryBuffer);

        primaryScreen.setText(primaryBuffer);
        secondaryScreen.setText(secondaryBuffer);
    }
}
