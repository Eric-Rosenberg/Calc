package com.example.tony.Week2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import android.widget.TextView;


public class Calculator extends ActionBarActivity implements View.OnClickListener
{
    private TextView result;
    private RadioGroup rGroup;
    private EditText getNum;
    private Button b1, b2, b3,b4,b5,b6,b7,b8,b9,b0,cls;
    private ImageButton change;
    private String number1 = "";
    private String currentNumber = "";
    private String number2 = "";
    private String operation = "";
    private Button plus;
    private boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        result = (TextView)findViewById(R.id.result);

        // This will find the buttons
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        b9 = (Button)findViewById(R.id.button9);
        b0 = (Button)findViewById(R.id.button0);
        cls = (Button)findViewById(R.id.buttonCls);
        plus = (Button)findViewById(R.id.buttonPlus);

        change = (ImageButton)findViewById(R.id.change);

        //This will find the number to be converted
        getNum = (EditText) findViewById(R.id.getNum);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        cls.setOnClickListener(this);
        plus.setOnClickListener(this);

        change.setOnClickListener(this);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button: setText(currentNumber,'1');
                break;
            case R.id.button2: setText(currentNumber,'2');
                break;
            case R.id.button3: setText(currentNumber,'3');
                break;
            case R.id.button4: setText(currentNumber,'4');
                break;
            case R.id.button5: setText(currentNumber,'5');
                break;
            case R.id.button6: setText(currentNumber,'6');
                break;
            case R.id.button7: setText(currentNumber,'7');
                break;
            case R.id.button8: setText(currentNumber,'8');
                break;
            case R.id.button9: setText(currentNumber,'9');
                break;
            case R.id.button0: setText(currentNumber,'0');
                break;
            case R.id.buttonCls: getNum.setText("");
                number1 = "";
                number2 = "";
                currentNumber = "";
                operation = "";
                result.setText("");
                break;
            case R.id.buttonPlus: operation(v);
                currentNumber = "";
                break;
            case R.id.change: Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                break;
        }
    }
    private void operation(View v){
        switch (v.getId()){
            case R.id.buttonPlus:
                operation = "+";
                break;
        }
        if(first){
            first = !first;
            currentNumber = number1;
            Log.d("MAIN","number 2");
        }
        else
            first = !first;
            Log.d("MAIN","number 1");
            currentNumber = number2;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setText(String input, char x){
        if(first) {
            number1 = input + x;
            currentNumber = input + x;
        }
        if(!first) {
            number2 = input + x;
            currentNumber = input + x;
        }
        getNum.setText(currentNumber);
        if(!number1.equals("") && !number2.equals("")) {
            Integer res = convertNum(number1) + convertNum(number2);
            result.setText(res.toString());
        }
    }
    Integer convertNum(String number){
        return Integer.valueOf(number);
    }
}
