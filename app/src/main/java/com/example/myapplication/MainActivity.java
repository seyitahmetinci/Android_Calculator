package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_0, bt_1, bt_2, bt_3, bt_4, bt_5, bt_6, bt_7, bt_8, bt_9, bt_C, bt_reminder, bt_multiply, bt_subtr, bt_add, bt_divide, bt_dot, bt_equal;

    EditText editTextResult;

    String selectedOperation = "";

    Double input1 = 0.0, input2 = 0.0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextResult = findViewById(R.id.editTextResult);

        bt_0 = findViewById(R.id.button_0);
        bt_1 = findViewById(R.id.button_1);
        bt_2 = findViewById(R.id.button_2);
        bt_3 = findViewById(R.id.button_3);
        bt_4 = findViewById(R.id.button_4);
        bt_5 = findViewById(R.id.button_5);
        bt_6 = findViewById(R.id.button_6);
        bt_7 = findViewById(R.id.button_7);
        bt_8 = findViewById(R.id.button_8);
        bt_9 = findViewById(R.id.button_9);

        bt_C = findViewById(R.id.button_C);

        bt_reminder = findViewById(R.id.buttonMod);
        bt_multiply = findViewById(R.id.buttonmultiply);
        bt_subtr = findViewById(R.id.buttonsubtr);
        bt_add = findViewById(R.id.buttonplus);
        bt_divide = findViewById(R.id.buttondivision);
        bt_dot = findViewById(R.id.buttonDot);
        bt_equal = findViewById(R.id.buttonEqual);

        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_0.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);

        bt_reminder.setOnClickListener(this);
        bt_multiply.setOnClickListener(this);
        bt_subtr.setOnClickListener(this);
        bt_add.setOnClickListener(this);
        bt_divide.setOnClickListener(this);
        bt_dot.setOnClickListener(this);
        bt_equal.setOnClickListener(this);
        bt_C.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_0:
                if (!editTextResult.getText().toString().equals("0")) {
                    editTextResult.setText(editTextResult.getText().toString() + "0");
                }
                break;
            case R.id.button_1:
                editTextResult.setText(editTextResult.getText().toString() + "1");
                break;
            case R.id.button_2:
                editTextResult.setText(editTextResult.getText().toString() + "2");
                break;
            case R.id.button_3:
                editTextResult.setText(editTextResult.getText().toString() + "3");
                break;
            case R.id.button_4:
                editTextResult.setText(editTextResult.getText().toString() + "4");
                break;
            case R.id.button_5:
                editTextResult.setText(editTextResult.getText().toString() + "5");
                break;
            case R.id.button_6:
                editTextResult.setText(editTextResult.getText().toString() + "6");
                break;
            case R.id.button_7:
                editTextResult.setText(editTextResult.getText().toString() + "7");
                break;
            case R.id.button_8:
                editTextResult.setText(editTextResult.getText().toString() + "8");
                break;
            case R.id.button_9:
                editTextResult.setText(editTextResult.getText().toString() + "9");
                break;
            case R.id.button_C:
                editTextResult.setText("");
                input1 = 0.0;
                input2 = 0.0;
                selectedOperation = "";
                break;
            case R.id.buttonDot:
                if (editTextResult.getText().length() > 0 && !editTextResult.getText().toString().contains(",")) {
                    editTextResult.setText(editTextResult.getText().toString() + ".");
                }
                break;

            case R.id.buttonplus:
                if (!editTextResult.getText().toString().isEmpty()) {
                    selectedOperation = "+";
                    input1 = Double.parseDouble(editTextResult.getText().toString());
                    editTextResult.setText("");
                }
                break;
            case R.id.buttonsubtr:
                if (!editTextResult.getText().toString().isEmpty()) {
                    selectedOperation = "-";
                    input1 = Double.parseDouble(editTextResult.getText().toString());
                    editTextResult.setText("");
                }
                break;
            case R.id.buttonmultiply:
                if (!editTextResult.getText().toString().isEmpty()) {
                    selectedOperation = "*";
                    input1 = Double.parseDouble(editTextResult.getText().toString());
                    editTextResult.setText("");
                }
                break;
            case R.id.buttondivision:
                if (!editTextResult.getText().toString().isEmpty()) {
                    selectedOperation = "/";
                    input1 = Double.parseDouble(editTextResult.getText().toString());
                    editTextResult.setText("");
                }
                break;
            case R.id.buttonMod:
                if (!editTextResult.getText().toString().isEmpty()) {
                    selectedOperation = "%";
                    input1 = Double.parseDouble(editTextResult.getText().toString());
                    editTextResult.setText("");
                }
                break;
            case R.id.buttonEqual:
                if (!selectedOperation.equals("")) {
                    input2 = Double.parseDouble(editTextResult.getText().toString());
                    editTextResult.setText(calculate());
                    input1 = 0.0;
                    input2 = 0.0;
                    selectedOperation = "";
                }
                break;
        }
    }

    private String calculate() {
        double result = 0.0;
        switch (selectedOperation) {
            case "+":
                result = input1 + input2;
                break;
            case "-":
                result = input1 - input2;
                break;
            case "*":
                result = input1 * input2;
                break;
            case "/":
                result = input1 / input2;
                break;
            case "%":
                result = input1 % input2;
                break;
        }

        if (result % 1 == 0) {
            return String.format("%d", (int) result);
        }
        return String.format("%.2f", result);
    }
}
