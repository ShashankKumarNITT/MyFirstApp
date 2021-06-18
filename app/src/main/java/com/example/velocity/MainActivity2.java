package com.example.velocity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    Button ansBtn;
    TextView showAns;
    EditText getVal, getVal2;
    double lornz_factor, vel, given_lornz;
    double c = 3 * Math.pow(10, 8);
    LinearLayout Layout;
    Vibrator vibrator ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ansBtn = (Button) findViewById(R.id.ansBtn);
        showAns = (TextView) findViewById(R.id.showAns);
        getVal = (EditText) findViewById(R.id.getVal);
        getVal2 = (EditText) findViewById(R.id.getVal2);
        Layout= findViewById(R.id.Layout);
        vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);


        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getVal.getText().toString().isEmpty() || getVal2.getText().toString().isEmpty()){
                    showAns.setText("Please provide both inputs");
                }

                else {
                    vel = Double.parseDouble(String.valueOf(getVal.getText()));
                    given_lornz = Double.parseDouble(String.valueOf(getVal2.getText()));
                    lornz_factor = c / (Math.sqrt(Math.pow(c, 2) - Math.pow(vel, 2)));

                    if (given_lornz == lornz_factor){
                        showAns.setText("Yes, the lorentz value entered is correct.\nIts value is : \n"+ String.valueOf(lornz_factor));
                        Layout.setBackgroundColor(Color.GREEN);
                    }
                    else {
                        showAns.setText("NO \n"+String.valueOf(lornz_factor)+ "\n is the correct value of lorentz factor. ");

                        Layout.setBackgroundColor(Color.RED);
                        vibrator.vibrate(1000);

                    }
                }
            }
        });
    }
}