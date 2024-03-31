package com.example.androidprojectcollection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorExercise extends AppCompatActivity {
    private TextView recall;
    private TextView result;
    private boolean decimalAdded = false; // Flag to track if decimal has been added

    private CalculatorExerciseObject calculatorExerciseObject;
    private String checkLast; // Declare checkLast variable
    private boolean checkDec; // Declare checkDec variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);

        recall = findViewById(R.id.Rev);
        result = findViewById(R.id.Result);

        // Instantiate the CalculatorExerciseObject
        calculatorExerciseObject = new CalculatorExerciseObject(this);

        // Add button click listeners
        Button btn0 = findViewById(R.id.num0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recall.append("0");
                calculatorExerciseObject.updateResult();
            }
        });

        Button btn1 = findViewById(R.id.num1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recall.append("1");
                calculatorExerciseObject.updateResult();
            }
        });

        Button btn2 = findViewById(R.id.num2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recall.append("2");
                calculatorExerciseObject.updateResult();
            }
        });

        Button btn3 = findViewById(R.id.num3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recall.append("3");
                calculatorExerciseObject.updateResult();
            }
        });

        Button btn4 = findViewById(R.id.num4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recall.append("4");
                calculatorExerciseObject.updateResult();
            }
        });

        Button btn5 = findViewById(R.id.num5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recall.append("5");
                calculatorExerciseObject.updateResult();
            }
        });

        Button btn6 = findViewById(R.id.num6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recall.append("6");
                calculatorExerciseObject.updateResult();
            }
        });

        Button btn7 = findViewById(R.id.num7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recall.append("7");
                calculatorExerciseObject.updateResult();
            }
        });

        Button btn8 = findViewById(R.id.num8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recall.append("8");
                calculatorExerciseObject.updateResult();
            }
        });

        Button btn9 = findViewById(R.id.num9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recall.append("9");
                calculatorExerciseObject.updateResult();
            }
        });

        Button btnPlus = findViewById(R.id.opPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = recall.getText().toString();
                if (text.isEmpty()) {
                    // If recall is empty, just append '-'.
//                    recall.append("+");

                } else {
                    char lastChar = text.charAt(text.length() - 1);
                    if (isOperator(lastChar)) {
                        // If last character is an operator, replace it with '-'.
                        recall.setText(text.substring(0, text.length() - 1) + "+");
                    } else {
                        // Otherwise, just append '-'.
                        recall.append("+");
                    }
                }
                calculatorExerciseObject.updateResult();
            }
        });

        Button btnMinus = findViewById(R.id.opMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = recall.getText().toString();
                if (text.isEmpty()) {
                    // If recall is empty, just append '-'.
//                    recall.append("-");
                } else {
                    char lastChar = text.charAt(text.length() - 1);
                    if (isOperator(lastChar)) {
                        // If last character is an operator, replace it with '-'.
                        recall.setText(text.substring(0, text.length() - 1) + "-");
                    } else {
                        // Otherwise, just append '-'.
                        recall.append("-");
                    }
                }
                calculatorExerciseObject.updateResult();
            }
        });

        Button btnMult = findViewById(R.id.opMult);
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = recall.getText().toString();
                if (text.isEmpty()) {
                    // If recall is empty, just append '-'.
//                    recall.append("*");
                } else {
                    char lastChar = text.charAt(text.length() - 1);
                    if (isOperator(lastChar)) {
                        // If last character is an operator, replace it with '-'.
                        recall.setText(text.substring(0, text.length() - 1) + "x");
                    } else {
                        // Otherwise, just append '-'.
                        recall.append("x");
                    }
                }
                calculatorExerciseObject.updateResult();
            }
        });

        Button btnDiv = findViewById(R.id.opDiv);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = recall.getText().toString();
                if (text.isEmpty()) {
                    // If recall is empty, just append '-'.
//                    recall.append("-");
                } else {
                    char lastChar = text.charAt(text.length() - 1);
                    if (isOperator(lastChar)) {
                        // If last character is an operator, replace it with '-'.
                        recall.setText(text.substring(0, text.length() - 1) + "/");
                    } else {
                        // Otherwise, just append '-'.
                        recall.append("/");
                    }
                }
                calculatorExerciseObject.updateResult();
            }
        });

        Button btnDec = findViewById(R.id.decimal);
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!decimalAdded) {
                    recall.append(".");
                    decimalAdded = true;
                } else {
                    String currentExpression = recall.getText().toString();
                    if (currentExpression.endsWith(".")) {
                        // Remove the last character (the decimal point)
                        recall.setText(currentExpression.substring(0, currentExpression.length() - 1));
                        decimalAdded = false;
                    }
                }
                calculatorExerciseObject.updateResult();
            }
        });

        Button btnEq = findViewById(R.id.Equals);
        btnEq.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            String buttonText = button.getText().toString();
            if (buttonText.equals("=")) {
                String expression = recall.getText().toString();
                try {
                    double res = calculatorExerciseObject.evaluateExpression(expression);
                    String formattedResult = calculatorExerciseObject.formatResult(res);
                    recall.setText("");
                    result.setText(formattedResult);
                    decimalAdded = false; // Reset flag after result
                } catch (Exception e) {
                    result.setText("Invalid");
                    decimalAdded = false; // Reset flag if expression is invalid
                }
            } else {
                recall.append(buttonText);
                calculatorExerciseObject.updateResult();
            }
        }
    };

    // Add getter methods for recall and result TextViews
    public TextView getRecall() {
        return recall;
    }

    public TextView getResult() {
        return result;
    }
    public boolean isOperator(char a)
    {
        return  a == '*' || a == '-' || a == '/' || a == '+';
    }
}
