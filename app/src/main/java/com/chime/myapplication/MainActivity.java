package com.chime.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private TextView dollarInfo;
    private TextView textButton;
    private int moneyCounter = 0;
    private final int[] arrayOfInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dollarInfo = findViewById(R.id.moneyCount);
        textButton = findViewById(R.id.congratText);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void increaseMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        dollarInfo.setText(String.valueOf(numberFormat.format(moneyCounter)));
        for (int increaseAmount : arrayOfInt) {
            if (moneyCounter == (10000) * increaseAmount) {
                Snackbar.make(view, "Congratulations!", Snackbar.LENGTH_LONG).show();
                Log.d("CONGRATULATIONS", "increaseMoney: congratulations");
                dollarInfo.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.purple));
            } else if(moneyCounter == 20000) {
                String sayCongrats = "Wow Congrats!";
                textButton.setText(sayCongrats);
            } else if(moneyCounter == 30000) {
                dollarInfo.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.green));
                String richClick = "You're now rich";
                textButton.setText(richClick);
            } else {
                textButton.setText("");
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void moneyInfo(View view) {
        moneyCounter = 0;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        dollarInfo.setText(String.valueOf(numberFormat.format(moneyCounter)));


        Snackbar.make(view, R.string.app_info, Snackbar.LENGTH_LONG)
                .setAction("More", view1 -> Log.d("MIR", "onClick: Done"))
                .show();
        textButton.setText("");
    }
}