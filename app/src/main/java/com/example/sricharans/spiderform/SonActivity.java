package com.example.sricharans.spiderform;

/**
 * Created by Srikanth S on 6/8/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class SonActivity extends MainActivity{
    TextView response;
    TextView timestamp;
    Button btn;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.son);
        response = (TextView)findViewById(R.id.response);
        timestamp = (TextView)findViewById(R.id.timestamp);
        String name = getIntent().getStringExtra("NAME");
        response.setText("Thanks for the response, "+name);
        String mytime = java.text.DateFormat.getTimeInstance().format(Calendar.getInstance().getTime());
        timestamp.setText(mytime);}
    public void OnBtnClick(View v){
        Intent mainactintent = new Intent(mCon,MainActivity.class);
        startActivity(mainactintent);
    }

    }

