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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener
{
    private TextView result;
    private RadioButton button1,button2,button3, checkedRadioButton;
    private EditText getNum;
    private ImageButton change;
    private String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Button b1, b2, b3,b4,b5,b6,b7,b8,b9,b0,cls,del;
        ImageButton change;
        RadioGroup rGroup;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        del = (Button)findViewById(R.id.buttonBksp);

        change = (ImageButton)findViewById(R.id.change);

        // This will get the radiogroup
        rGroup = (RadioGroup)findViewById(R.id.group);
        // This will get the radiobutton in the radiogroup that is checked
        checkedRadioButton = (RadioButton)rGroup.findViewById(rGroup.getCheckedRadioButtonId());
        // This will find the remaining button id's
        button1 = (RadioButton)findViewById(R.id.radioButton);
        button2 = (RadioButton)findViewById(R.id.radioButton2);
        button3 = (RadioButton)findViewById(R.id.radioButton3);
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
        del.setOnClickListener(this);

        change.setOnClickListener(this);

        // This overrides the radiogroup onCheckListener
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup rGroup, int checkedId)
            {
                // This will get the radiobutton that has changed in its check state
                checkedRadioButton = (RadioButton)rGroup.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked)
                {
                    if(button1 == checkedRadioButton){
                        convertMethod(1);
                    }
                    else if(button2 == checkedRadioButton){
                        convertMethod(2);
                    }
                    else if(button3 == checkedRadioButton){
                        convertMethod(3);
                    }
                }
                else
                    result.setText("ERROR");
            }
        });


    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button: setText(text,1);
                break;
            case R.id.button2: setText(text,2);
                break;
            case R.id.button3: setText(text,3);
                break;
            case R.id.button4: setText(text,4);
                break;
            case R.id.button5: setText(text,5);
                break;
            case R.id.button6: setText(text,6);
                break;
            case R.id.button7: setText(text,7);
                break;
            case R.id.button8: setText(text,8);
                break;
            case R.id.button9: setText(text,9);
                break;
            case R.id.button0: setText(text,0);
                break;
            case R.id.buttonCls: getNum.setText("");
                text = "";
                result.setText("");
                break;
            case R.id.change: Intent i = new Intent(MainActivity.this,Calculator.class);
                startActivity(i);
                break;
            case R.id.buttonBksp:
                if(getNum.getText().toString().equals(""))
                    ;
                else {
                    getNum.setText(getNum.getText().toString().substring(0, getNum.length() - 1));
                    text = getNum.getText().toString();

                    if (button1 == checkedRadioButton) {
                        convertMethod(1);
                    } else if (button2 == checkedRadioButton) {
                        convertMethod(2);
                    } else if (button3 == checkedRadioButton) {
                        convertMethod(3);
                    }
                }
                break;
        }
    }

    public void setText(String input, int x){
        text = input + x;
        getNum.setText(text);


        if(button1 == checkedRadioButton){
            convertMethod(1);
        }
        else if(button2 == checkedRadioButton){
            convertMethod(2);
        }
        else if(button3 == checkedRadioButton){
            convertMethod(3);
        }
        else
            Log.d("MAIN","HERE");
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

    public void convertMethod(int method)
    {
        EditText getNum = (EditText) findViewById(R.id.getNum);
        String value = getNum.getText().toString();
        double n;

        if(value.matches(""))
            result.setText(R.string.error);
        else {
            if (method == 1) {
                double bytesCalc;
                n = Double.parseDouble(value);
                bytesCalc = n * .125;
                result.setText(String.valueOf(bytesCalc +  " " + getString(R.string.bytes)));
            } else if (method == 2) {
                double kiloCalc;
                n = Double.parseDouble(value);
                kiloCalc = n * .000125;
                result.setText(String.valueOf(kiloCalc + " " + getString(R.string.kilo)));
            } else if (method == 3) {
                double megaCalc;
                n = Double.parseDouble(value);
                megaCalc = n * .000000125;
                result.setText(String.valueOf(megaCalc + " " + getString(R.string.mega)));
            }
        }
    }
}
