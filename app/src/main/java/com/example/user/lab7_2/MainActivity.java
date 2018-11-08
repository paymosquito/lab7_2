package com.example.user.lab7_2;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.BitSet;

public class MainActivity extends AppCompatActivity {

    protected EditText tall;
    protected EditText weight;
    protected RadioButton boy;
    protected RadioButton girl;
    protected RadioGroup radioGroup;
    protected Button button;
    protected TextView standardWeight;
    protected TextView bodyFat;

    int gender = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        tall = findViewById(R.id.tall);
        weight = findViewById(R.id.weight);
        boy = findViewById(R.id.boy);
        girl = findViewById(R.id.girl);
        radioGroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);
        standardWeight = findViewById(R.id.standardWeight);
        bodyFat = findViewById(R.id.bodyFat);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.boy:
                        gender = 1;
                        break;
                    case R.id.girl:
                        gender = 2;
                        break;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                runAsyncTask();
            }
        });
    }
    private  void runAsyncTask(){
        new AsyncTask<Void, Integer, Boolean>(){
            private ProgressDialog dialog = new ProgressDialog(MainActivity.this);
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                dialog.setMessage("計算中...");
                dialog.setCancelable(false);
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.show();
            }
        }
    }

}
