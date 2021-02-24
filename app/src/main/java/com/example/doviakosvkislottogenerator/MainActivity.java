package com.example.doviakosvkislottogenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    private EditText InputText;
    private Button generate;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputText = findViewById(R.id.IntputText);
        generate = findViewById(R.id.generate);
        result = findViewById(R.id.result);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BigInteger number = BigInteger.valueOf (Integer.parseInt(InputText.getText().toString()));
                    BigInteger countingMethod = couting(number);
                    result.setText("Sugeneruotas atsakymas: "+ number +" yra \n "+ String.valueOf(countingMethod));
                } catch (NumberFormatException ignored){

                }
            }
        });
    }

    private BigInteger couting(BigInteger number) {
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        BigInteger c;
        if (number.equals(zero)){
            return zero;
        }else if (number.equals(one)){
            return one;
        }
        for (int i = 2; i <= number.intValue(); i++){
            c = zero.add(one);
            zero = one;
            one = c;
        }
        return one;
    }
}