package com.example.li_facemaker;

import android.graphics.Canvas;
import android.graphics.Color;

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

public class Face extends MainActivity {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;

    public Face() {
        //randomizes the variables
        randomize();

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

