package com.augmentis.ayp.calculator;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    private static final String TAG = "Calc_Act";
    private static final String CALC = "ayp.CALC";
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

    Calculator calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        if(savedInstanceState != null) {
            calc = (Calculator) savedInstanceState.getSerializable(CALC);
        } else {
            calc = new Calculator();
        }

        bindScreens();
        bindButtons(); // bind buttons
        updateUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable(CALC, calc);
    }

    private void bindScreens() {
        primaryScreen = (TextView) findViewById(R.id.primary_text);
        secondaryScreen = (TextView) findViewById(R.id.secondary_text);
    }

    Button[] numberButtons ;
    Button[] operatorButtons ;

    private void bindButtons() {
        int l = numberIds.length;
        numberButtons = new Button[l];
        for (int i = 0; i < l; i++) {
            numberButtons[i] = (Button) findViewById(numberIds[i]);

            numberButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button thisButton = (Button) v;

                    calc.pressNumber(thisButton.getText().toString());
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

                    calc.pressOperator(thisButton.getText().toString());
                    updateUI();
                }
            });
        }

        equalButton = (Button) findViewById(R.id.equalButton);
        equalButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                calc.pressEqual();
                updateUI();
            }
        });
        clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clear !!");
                calc.pressClear();
                updateUI();
            }
        });
    }

    private void updateUI() {
        primaryScreen.setText(calc.getPrimaryScreen());
        secondaryScreen.setText(calc.getSecondaryScreen());
    }
}
