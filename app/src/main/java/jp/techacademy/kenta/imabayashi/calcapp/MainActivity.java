package jp.techacademy.kenta.imabayashi.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;
    TextView textView1;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    double num1;
    double num2;
    private double calc_num;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ここでTextのオブジェクト作る意味とは？
        //Text1の取得
        editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setOnClickListener(this);

        //Text2の取得
        editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setOnClickListener(this);

        //Button1の取得
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        //Button2の取得
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        //Button3の取得
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        //Button4の取得
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try{
            if(v.getId() == R.id.button1) {
                parseNum();
                calc_num = num1 + num2;
                fire_intent();
            }else if(v.getId() == R.id.button2){
                parseNum();
                calc_num = num1 - num2;
                fire_intent();
            }else if(v.getId() == R.id.button3){
                parseNum();
                calc_num = num1 * num2;
                fire_intent();
            }else if(v.getId() == R.id.button4) {
                parseNum();
                calc_num = num1 / num2;
                fire_intent();
            }
        }catch (NumberFormatException e) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            textView1.setText("数字をいれてね");
           }
        }

    private void parseNum(){
        num1 = parseDouble(editText1.getText().toString());
        num2 = parseDouble(editText2.getText().toString());
    }

    private void fire_intent(){
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("calc_num",calc_num);
        startActivity(intent);
    }
}
