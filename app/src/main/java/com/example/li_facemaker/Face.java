package com.example.li_facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.shapes.OvalShape;
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

        setHairStyle(hairStyle);

        facePaint.setColor(skinColor);
        hairPaint.setColor(hairColor);
        eyePaint.setColor(eyeColor);

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

        int random_num1 = random.nextInt(256);
        int random_num2 = random.nextInt(256);
        int random_num3 = random.nextInt(256);

        skinColor = Color.argb(255, random_num1, random_num2, random_num3);
        eyeColor = Color.argb(255, random_num2, random_num3, random_num1);
        hairColor = Color.argb(255, random_num3, random_num1, random_num2);


        hairStyle = random.nextInt(6); //5 hairstyles including 'none'
    }

    //onDraw method
    public void onDraw(Canvas canvas) {

        float sv_width = canvas.getWidth();
        float sv_height = canvas.getHeight();

        float centerX = canvas.getWidth() / 2;
        float centerY = canvas.getHeight() / 2;

        RectF face_ref = new RectF(centerX - 200, centerY - 250, centerX + 200, centerY + 250);
        RectF bowlcut = new RectF(centerX - 200, centerY - 250, centerX + 200, centerY + 100);
        RectF midPartRight = new RectF(centerX - 180, centerY - 300, centerX + 250, centerY + 100);
        RectF midPartLeft = new RectF(centerX - 250, centerY - 300, centerX + 180, centerY + 100);


        //face
        canvas.drawOval(face_ref, facePaint);
        //left eye
        canvas.drawCircle(centerX - 80, centerY - 10, 30, eyePaint);
        //right eye
        canvas.drawCircle(centerX + 80, centerY - 10, 30, eyePaint);

        //left ear
        canvas.drawCircle(centerX - 210, centerY , 35, facePaint);
        //right ear
        canvas.drawCircle(centerX + 210, centerY, 35, facePaint);

        //mouth
        canvas.drawRect(centerX, centerY, centerX, centerY, mouthPaint);

        if (hairStyle == 1) {
            canvas.drawArc(bowlcut, 0, -180, true, hairPaint);
        } else if (hairStyle == 2) {
            //buzz
            canvas.drawArc(bowlcut, 0, -180, true, hairPaint);
            canvas.drawOval(centerX - 200, centerY - 100, centerX - 150, centerY - 20, hairPaint);
            canvas.drawOval(centerX + 200, centerY - 100, centerX + 150, centerY - 20, hairPaint);
        } else if (hairStyle == 3) {
            //middle part
            canvas.drawArc(midPartRight, 30, -180, true, hairPaint);
            canvas.drawArc(midPartLeft, -30, -180, true, hairPaint);
        } else if (hairStyle == 4) {
            //MoHawk
            canvas.drawOval(centerX - 20, centerY - 300, centerX + 20, centerY - 120, hairPaint);
        }
        //eyes


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

