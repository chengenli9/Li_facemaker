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

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1;
    SeekBar seekBar2;
    SeekBar seekBar3;
    TextView tvOne;
    TextView tvTwo;
    TextView tvThree;

    Button randomFace;

    Face faceView;

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //seekbar for red
        seekBar1 = findViewById(R.id.red_seekBar);
        //seekbar for blue;
        seekBar2 = findViewById(R.id.green_seekBar);
        //seekbar for green;
        seekBar3 = findViewById(R.id.blue_seekBar);

        //references the textview
        tvOne = findViewById(R.id.numRed);
        tvTwo = findViewById(R.id.numBlue);
        tvThree = findViewById(R.id.numGreen);


        randomFace = findViewById(R.id.random_face);

        faceView = findViewById(R.id.face_window);

        radioGroup = findViewById(R.id.radio_group);


        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                tvOne.setVisibility(View.VISIBLE);

                //sets the text based on progress value
                tvOne.setText(progress + "");

                if (radioGroup.getCheckedRadioButtonId() == R.id.hair_button) {
                    faceView.setHairColor(Color.rgb(progress, seekBar2.getProgress(), seekBar3.getProgress()));

                } else if (radioGroup.getCheckedRadioButtonId() == R.id.eye_button) {
                    faceView.setEyeColor(Color.rgb(progress, seekBar2.getProgress(), seekBar3.getProgress()));
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.skin_button) {
                    faceView.setSkinColor(Color.rgb(progress, seekBar2.getProgress(), seekBar3.getProgress()));
                }
                faceView.invalidate(); // face redraws itself

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

                if (radioGroup.getCheckedRadioButtonId() == R.id.hair_button) {
                    faceView.setHairColor(Color.rgb(seekBar1.getProgress(), progress, seekBar3.getProgress()));
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.eye_button) {
                    faceView.setEyeColor(Color.rgb(seekBar1.getProgress(), progress, seekBar3.getProgress()));
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.skin_button) {
                    faceView.setSkinColor(Color.rgb(seekBar1.getProgress(), progress, seekBar3.getProgress()));
                }
                faceView.invalidate(); // face redraws itself
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

                if (radioGroup.getCheckedRadioButtonId() == R.id.hair_button) {
                    faceView.setHairColor(Color.rgb(seekBar1.getProgress(), seekBar2.getProgress(), progress));
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.eye_button) {
                    faceView.setEyeColor(Color.rgb(seekBar1.getProgress(), seekBar2.getProgress(), progress));
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.skin_button) {
                    faceView.setSkinColor(Color.rgb(seekBar1.getProgress(), seekBar2.getProgress(), progress));
                }
                faceView.invalidate(); // face redraws itself
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

        Spinner spinner = findViewById(R.id.HairStyles);

        //create the arrayList for the spinner
        ArrayList<String> styles = new ArrayList<>();

        //add strings to arrayList
        styles.add("Bald");
        styles.add("Bowl");
        styles.add("Buzz");
        styles.add("Middle Part");
        styles.add("MoHawk");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, styles);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);


        // Set the randomly selected item as the selected item in the spinner
        spinner.setSelection(faceView.hairStyle);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Selected Item: " + item, Toast.LENGTH_SHORT).show();
                faceView.setHairStyle(i);
                faceView.invalidate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        randomFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random ran = new Random();
                int ranHair = ran.nextInt(styles.size());
                spinner.setSelection(ranHair);
                faceView.randomize();
                faceView.invalidate();

            }
        });

        // Set up the RadioGroup for hair, eyes, and skin RadioButtons
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Check which RadioButton is selected and update SeekBars accordingly
                if (checkedId == R.id.hair_button) {
                    updateSeekBars(faceView.getHairColor());
                }
                if (checkedId == R.id.eye_button) {
                    updateSeekBars(faceView.getEyeColor());
                }
                if (checkedId == R.id.skin_button) {
                    updateSeekBars(faceView.getSkinColor());
                }
            }
        });



    }

    private void updateSeekBars(int color) {
        seekBar1.setProgress(Color.red(color));
        seekBar2.setProgress(Color.green(color));
        seekBar3.setProgress(Color.blue(color));
    }




}




