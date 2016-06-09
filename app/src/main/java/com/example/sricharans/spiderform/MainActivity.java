package com.example.sricharans.spiderform;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int tronix = 0;
    private static final int appdev = 1;
    private static final int webdev = 2;
    private static final int algos = 3;
    EditText Name;
    EditText Rollno;
    Spinner dept;
    CheckBox[] profsel = new CheckBox[4];
    Switch mentor;
    Context mCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.name);
        Rollno = (EditText) findViewById(R.id.rollno);
        dept = (Spinner) findViewById(R.id.dept);
        profsel[tronix] = (CheckBox) findViewById(R.id.tronix);
        profsel[appdev] = (CheckBox) findViewById(R.id.appdev);
        profsel[webdev] = (CheckBox) findViewById(R.id.webdev);
        profsel[algos] = (CheckBox) findViewById(R.id.algos);
        mentor = (Switch) findViewById(R.id.switch1);
        mCon = this;
        List<String> categories = new ArrayList<String>();
        categories.add("CSE");
        categories.add("Civil");
        categories.add("ECE");
        categories.add("EEE");
        categories.add("ICE");
        categories.add("Mech");
        categories.add("MME");
        categories.add("Prod");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dept.setAdapter(dataAdapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

    }


    public void OnSubmitBtnClick(View v) {
        boolean isNameFilled = true;
        boolean isRollNoFilled = true;
        boolean isProfileFilled = true;

        if (Name.getText().toString().equals("")) {
            Toast.makeText(mCon, "Name field blank", Toast.LENGTH_SHORT).show();
            isNameFilled = false;
        }
        if (Rollno.getText().toString().equals("")) {
            Toast.makeText(mCon, "Roll number field blank", Toast.LENGTH_SHORT).show();
            isRollNoFilled = false;
        }
        if (!(profsel[tronix].isChecked()) && !(profsel[appdev].isChecked()) && !(profsel[webdev].isChecked()) && !(profsel[algos].isChecked())) {
            Toast.makeText(mCon, "Profile choice is mandatory", Toast.LENGTH_SHORT).show();
            isProfileFilled = false;
        }

        if (isNameFilled && isProfileFilled && isRollNoFilled) {

            Intent sonactintent = new Intent(mCon, SonActivity.class);
            sonactintent.putExtra("NAME", Name.getText().toString());
            startActivity(sonactintent);

        }
    }
}