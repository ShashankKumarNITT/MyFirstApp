package com.example.velocity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity3 extends AppCompatActivity {

    TextView showAns0;
    double phi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        showAns0= (TextView) findViewById(R.id.showAns0);
        content1();

    }
    public void content1(){
        Calendar cal = Calendar.getInstance();
        double hour24hrs = cal.get(Calendar.HOUR_OF_DAY);
        double hour12hrs = cal.get(Calendar.HOUR);
        double minutes = cal.get(Calendar.MINUTE);
        double seconds = cal.get(Calendar.SECOND);



        int i;
        double factorial;
        if(hour12hrs==0){
            factorial =1;
        }
        else {
            i = 1;
            factorial = 1;
            while (i <= hour12hrs) {
                factorial = factorial * i;
                i = i + 1;

            }
        }

        phi = factorial/(Math.pow(minutes,3)+Math.pow(seconds,1));
        showAns0.setText("Spi factor is: \n"+String.valueOf(phi) +" \nand the current time is : \n"+String.valueOf(hour12hrs)+": "+String.valueOf(minutes)+" :"+String.valueOf(seconds));

        refresh(1000);
    }



    private void refresh(int milliseconds){

        final Handler handler = new Handler();

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                content1();
            }
        };

        handler.postDelayed(runnable, milliseconds);
    }
}