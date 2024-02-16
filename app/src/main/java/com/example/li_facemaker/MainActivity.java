package com.example.li_facemaker;

/**
 * MainActivity.java
 *
 * @author !!! Chengen Li!!!
 * @version !!! 02/15/2024 !!!
 *
 * --------------------------
 *
 **/


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1;
    SeekBar seekBar2;
    SeekBar seekBar3;
    TextView tvOne;
    TextView tvTwo;
    TextView tvThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //seekbar for red
        seekBar1 = findViewById(R.id.red_seekBar);
        //seekbar for blue;
        seekBar2 = findViewById(R.id.blue_seekBar);
        //seekbar for green;
        seekBar3 = findViewById(R.id.green_seekBar);

        //references the textview
        tvOne = findViewById(R.id.numRed);
        tvTwo = findViewById(R.id.numBlue);
        tvThree = findViewById(R.id.numGreen);


        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                tvOne.setVisibility(View.VISIBLE);

                //sets the text based on progress value
                tvOne.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                tvTwo.setVisibility(View.VISIBLE);
                tvTwo.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                tvThree.setVisibility(View.VISIBLE);
                tvThree.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //code to implement spinner was borrowed from:
        //https://www.youtube.com/watch?v=4ogzfAipGS8

        Spinner spinner = findViewById(R.id.action_bar_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected Item: " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //create the arrayList for the spinner
        ArrayList<String> arrayList = new ArrayList<>();

        //add strings to arrayList
        arrayList.add("None Selected");
        arrayList.add("Middle Part");
        arrayList.add("Fringe");
        arrayList.add("Brush Back");
        arrayList.add("Bowl Cut");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);
    }
}
