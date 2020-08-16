package com.example.examplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstvalue,secondvalue;
    Button add,sub,mul,div;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstvalue = findViewById(R.id.first_value);
        secondvalue =findViewById(R.id.second_value);
        add=findViewById(R.id.addition_button);
        sub=findViewById(R.id.subtraction_button);
        mul=findViewById(R.id.multiply_button);
        div=findViewById(R.id.division_button);
        answer=findViewById(R.id.answer_box);
    }
    public void doCalculation(View view){
        String firstValueString = firstvalue.getText().toString();
        String secondValueString = secondvalue.getText().toString();
        if (firstValueString.isEmpty() || secondValueString.isEmpty()){
            Toast.makeText(this, "Invalid Inputs", Toast.LENGTH_SHORT).show();
        }
        else {
            try {
                int firstValueInt = Integer.parseInt(firstValueString);
                int secondValueInt = Integer.parseInt(secondValueString);
                int answerInt = 0;
                switch (view.getId()){
                    case R.id.addition_button :
                        answerInt =firstValueInt + secondValueInt;
                        break;
                    case R.id.subtraction_button :
                        answerInt =firstValueInt - secondValueInt;
                        break;
                    case R.id.multiply_button :
                        answerInt =firstValueInt * secondValueInt;
                        break;
                    case R.id.division_button :
                        answerInt =firstValueInt / secondValueInt;
                        break;
                }
                String answerString = String.valueOf(answerInt);
                answer.setText("Answer is : " + answerString);
            }catch (Exception e) {
                Log.e("Calculation error",e.toString());
                Toast.makeText(this, "Don't Play with me", Toast.LENGTH_SHORT).show();
            }
        }
    }
}