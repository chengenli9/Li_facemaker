package com.example.li_facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Face.java
 *
 * @author !!! Chengen Li!!!
 * @version !!! 02/15/2024 !!!
 *
 * --------------------------
 *
 **/

public class Face extends SurfaceView {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;

    Paint facePaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();

    Paint nosePaint = new Paint();
    Paint mouthPaint = new Paint();






    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);
        //randomizes the variables
        randomize();

        facePaint.setColor(0xFFFFFACD);

        setBackgroundColor(Color.WHITE);

    }

    /**
     * randomize()
     *
     * converts the color instance variables into random colors
     *
     * used color method to turn Color into int
     * Color.argb(int alpha, int red, int green, int, blue);
     *
     * --------------------------
     *
     **/
    public void randomize() {
        Random random = new Random();

        int random_rgb = random.nextInt(256);

        skinColor = Color.argb(255, random_rgb, random_rgb, random_rgb);
        eyeColor = Color.argb(255, random_rgb, random_rgb, random_rgb);
        hairColor = Color.argb(255, random_rgb, random_rgb, random_rgb);


        hairStyle = random.nextInt(6); //5 hairstyles including 'none'
    }

    //onDraw method
    public void onDraw(Canvas canvas) {

        canvas.drawCircle(500, 500, 100, facePaint);
    }

    public int getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(int skinColor) {
        this.skinColor = skinColor;
    }

    public int getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(int eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getHairColor() {
        return hairColor;
    }

    public void setHairColor(int hairColor) {
        this.hairColor = hairColor;
    }

    public int getHairStyle() {
        return hairStyle;
    }

    public void setHairStyle(int hairStyle) {
        this.hairStyle = hairStyle;
    }
}

