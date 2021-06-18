package com.example.velocity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button NxtPage , NxtPage2;


    Button ansBtn;
    TextView showAns;
    EditText getVal;
    double lornz_factor, vel;
    double c= 3 * Math.pow(10,8) ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ansBtn= (Button) findViewById(R.id.ansBtn);
        showAns= (TextView) findViewById(R.id.showAns);
        getVal= (EditText) findViewById(R.id.getVal);



        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getVal.getText().toString().isEmpty()){
                    showAns.setText(("Plese give some value"));
                }

                else{
                    vel = Double.parseDouble(String.valueOf(getVal.getText()));

                    if(vel>c){
                        showAns.setText("Invalid speed value");
                        Toast.makeText(MainActivity.this, "Invalid input value", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        lornz_factor = c / (Math.sqrt(Math.pow(c, 2) - Math.pow(vel, 2)));
                        showAns.setText(String.valueOf(lornz_factor) + " is the Lorentz factor");
                    }
                }
            }
        });


        NxtPage = (Button) findViewById(R.id.NxtPage);
        NxtPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        NxtPage2 = (Button) findViewById(R.id.NxtPage2);
        NxtPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });


    }
    /* ## Creating the new mthd Activity2 ## */
    public void openActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

}