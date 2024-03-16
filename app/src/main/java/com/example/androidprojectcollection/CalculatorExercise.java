// CalculatorExercise.java

package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.Stack;

public class CalculatorExercise extends AppCompatActivity {
    private TextView Recall;
    private TextView Result;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMult;
    private Button btnDiv;
    private Button btnDec;
    private Button btnEq;
    private Boolean numAv = false;

    CalculatorExerciseObject calculatorObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);

        Recall = findViewById(R.id.Rev);
        Result = findViewById(R.id.Result);
        btn0 = findViewById(R.id.num0);
        btn1 = findViewById(R.id.num1);
        btn2 = findViewById(R.id.num2);
        btn3 = findViewById(R.id.num3);
        btn4 = findViewById(R.id.num4);
        btn5 = findViewById(R.id.num5);
        btn6 = findViewById(R.id.num6);
        btn7 = findViewById(R.id.num7);
        btn8 = findViewById(R.id.num8);
        btn9 = findViewById(R.id.num9);
        btnPlus = findViewById(R.id.opPlus);
        btnMinus = findViewById(R.id.opMinus);
        btnMult = findViewById(R.id.opMult);
        btnDiv = findViewById(R.id.opDiv);
        btnDec = findViewById(R.id.decimal);
        btnEq = findViewById(R.id.Equals);

        calculatorObject = new CalculatorExerciseObject(this);

        // Remaining code...

        // You may add any other initialization or setup code here
    }

    // The rest of your methods go here...

    public TextView getRecall() {
        return Recall;
    }

    public TextView getResult() {
        return Result;
    }
    private double evaluateExpression (String expression){

        String[] tokens = expression.split("(?=[+\\-x/])|(?<=[+\\-x/])");


        double result = Double.parseDouble(tokens[0]);
        char operator = ' ';


        for (int i = 1; i < tokens.length; i++) {

            if (tokens[i].matches("[+\\-x/]")) {
                operator = tokens[i].charAt(0);
            } else {

                double operand = Double.parseDouble(tokens[i]);
                switch (operator) {
                    case '+':
                        result += operand;
                        break;
                    case '-':
                        result -= operand;
                        break;
                    case 'x':
                        result *= operand;
                        break;
                    case '/':

                        if (operand == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result /= operand;
                        break;
                }
            }
        }
        return result;
    }
    private String formatResult ( double result){
        // Check if the result has decimal places
        if (result == (long) result) {
            // If the result is an integer, remove the decimal part
            return String.format("%d", (long) result);
        } else {

            DecimalFormat decimalFormat = new DecimalFormat("#.##########");
            return decimalFormat.format(result);
        }
    }
    private void updateResult () {
        String expression = Recall.getText().toString();
        if (expression.contains("+") || expression.contains("-") || expression.contains("x") || expression.contains("/")) {
            try {
                double result = evaluateExpression(expression);
                String formattedResult = formatResult(result);
                Result.setText(formattedResult);
            } catch (Exception e) {
                Result.setText("");
            }
        } else {
            Result.setText("");
        }
    }

    private Double ActualResult (String expression){
        expression = expression.replaceAll("\\s+", "");


        String[] tokens = expression.split("(?<=[-+x/()])|(?=[-+x/()])");


        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();


        for (String token : tokens) {

            if (token.matches("[0-9]+")) {
                numbers.push(Double.parseDouble(token));
            } else if (token.equals("(")) {
                operators.push(token.charAt(0));
            } else if (token.equals(")")) {

                while (!operators.isEmpty() && operators.peek() != '(') {
                    evaluateOperator(numbers, operators);
                }
                operators.pop(); // Remove the '('
            } else {
                while (!operators.isEmpty() && Precedence(token.charAt(0), operators.peek())) {
                    evaluateOperator(numbers, operators);
                }
                operators.push(token.charAt(0));
            }
        }

        while (!operators.isEmpty()) {
            evaluateOperator(numbers, operators);
        }
        return numbers.pop();

    }
    private void evaluateOperator (Stack < Double > numbers, Stack < Character > operators){
        char operator = operators.pop();
        double num2 = numbers.pop();
        double num1 = numbers.pop();
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case 'x':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        numbers.push(result);
    }
    private boolean Precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 != 'x' && op1 != '/') || (op2 != '+' && op2 != '-');
    }
}