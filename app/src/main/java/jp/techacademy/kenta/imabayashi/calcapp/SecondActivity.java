package jp.techacademy.kenta.imabayashi.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double value1 = intent.getDoubleExtra("calc_num", 0);

        Log.d("DEBUG", String.valueOf(value1));

        TextView textview = (TextView) findViewById(R.id.textview);
        textview.setText(String.valueOf(value1));

    }
}
