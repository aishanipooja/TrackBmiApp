package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText weight;
        EditText height;
        TextView txtDet,txtRes;
        Button result;
        Button reset;

        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        txtDet=findViewById(R.id.txtDet);
        txtRes=findViewById(R.id.txtRes);
        result=findViewById(R.id.result);
        reset=findViewById(R.id.reset);


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strweg=weight.getText().toString();
                String strhei=height.getText().toString();

                if(strweg.equals(""))
                {
                    weight.setError("Please Enter Your Weight");
                    weight.requestFocus();
                    return;
                }
                if(strhei.equals("")){
                    height.setError("Please Enter Your Height");
                    height.requestFocus();
                    return;
                }

                float weight = Float.parseFloat(strweg);
                float height = Float.parseFloat(strhei)/100;

                float bmiVlaue = BMICalculate(weight,height);

                txtDet.setText(interpreteBMI(bmiVlaue));
                txtRes.setText("BMI= "+bmiVlaue);




            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight.setText("");
                height.setText("");
                txtDet.setText("");
                txtRes.setText("");

            }
        });



    }
    public float BMICalculate (float weight,float height)
    {
       return weight/(height*height);
    }
    public String interpreteBMI(float bmiValue)
    {
        if(bmiValue<16)
        {
            return " OOPS !! Please Start Eating More You Are Severely Underweight";
        }
        else if(bmiValue<18.5)
        {
            return "Underweight, Please Take More Food";
        }
        else if(bmiValue<25)
        {
         return "Congratulations, You Are Absolutely Normal";
        }
        else if(bmiValue<30)
        {
            return "Overweight, Start Dieting!";
        }
        else
        {
            return "Obese, Start Working On Your Body";
        }
    }
}