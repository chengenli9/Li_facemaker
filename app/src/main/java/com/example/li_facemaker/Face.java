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

    //values for changing rgb of different parts of the face
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;

    //create new Paint objects for coloring shapes
    Paint facePaint = new Paint();
    Paint eyePaint = new Paint();
    Paint eyeWhite = new Paint();
    Paint hairPaint = new Paint();

    Paint nosePaint = new Paint();
    Paint mouthPaint = new Paint();
    



    //face constructor
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);

        //creates random face when page is refreshed or opened
        randomize();
        //shows that is being created on the screen
        setWillNotDraw(false);


        //sets the hairStyle so it knows which hair style to draw on the head
        setHairStyle(hairStyle);

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
        //sets the color for Paint
        facePaint.setColor(skinColor);
        hairPaint.setColor(hairColor);
        eyePaint.setColor(eyeColor);

        eyeWhite.setColor(Color.WHITE);
        mouthPaint.setColor(Color.WHITE);
        setBackgroundColor(Color.WHITE);

        //get the full width and height of the surfaceView
        float sv_width = canvas.getWidth();
        float sv_height = canvas.getHeight();

        //center point of the SurfaceView
        float centerX = canvas.getWidth() / 2;
        float centerY = canvas.getHeight() / 2;

        //RectF for drawing Arcs, used as reference
        RectF face_ref = new RectF(centerX - 200, centerY - 250, centerX + 200, centerY + 250);
        RectF bowlcut = new RectF(centerX - 200, centerY - 250, centerX + 200, centerY + 100);
        RectF midPartRight = new RectF(centerX - 180, centerY - 300, centerX + 250, centerY + 100);
        RectF midPartLeft = new RectF(centerX - 250, centerY - 300, centerX + 180, centerY + 100);


        //draw face
        canvas.drawOval(face_ref, facePaint);

        //draw left eye
        canvas.drawOval(centerX - 120, centerY - 40, centerX - 55, centerY + 10, eyeWhite);
        canvas.drawCircle(centerX - 80, centerY - 10, 20, eyePaint);
        //draw right eye
        canvas.drawOval(centerX + 120, centerY - 40, centerX + 55, centerY + 10, eyeWhite);
        canvas.drawCircle(centerX + 80, centerY - 10, 20, eyePaint);

        //draw left ear
        canvas.drawCircle(centerX - 200, centerY , 40, facePaint);
        //draw right ear
        canvas.drawCircle(centerX + 200, centerY, 40, facePaint);

        //draw mouth
        RectF mouth = new RectF(centerX - 80, centerY + 50, centerX + 80, centerY+ 150);
        canvas.drawArc(mouth, 0, 180, true, mouthPaint);

        //draw nose
        RectF nose = new RectF(centerX - 15, centerY, centerX + 15, centerY + 100);
        canvas.drawArc(nose, 0, -180, true, mouthPaint);

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



    }

    //helper methods:
    public int getSkinColor() {

        return this.skinColor;
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
        return this.hairColor;
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

