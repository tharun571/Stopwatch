package com.example.stopwatch;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class Canvas extends View {

    float x1=500,y1=500,x2=50,y2=500;
    float a1=500,b1=250,a2=500,b2=70;


    public Canvas(Context context) {
        super(context);
        init(null);
    }

    public Canvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public Canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public Canvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    private void init(@Nullable AttributeSet set){




        a1=y1;
        b1=x1-250;


    }
    boolean start=false;

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);



        Paint paintclocklayout=new Paint(Paint.ANTI_ALIAS_FLAG);
        paintclocklayout.setColor(Color.parseColor("#000000"));
        paintclocklayout.setStrokeWidth(5);
        paintclocklayout.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(y1,x1,500,paintclocklayout);
        canvas.drawCircle(a1,b1,200,paintclocklayout);

        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#000000"));
        canvas.drawCircle(y1,x1,5,paint);
        canvas.drawCircle(a1,b1,5,paint);

        for(int i=1;i<=12;i++){
            canvas.drawText(""+i,500 + (float) (475 * Math.sin(Math.toRadians(i * 30))),500 - (float) (475 * Math.cos(Math.toRadians((i * 30)))),paint);
            canvas.drawText(""+i,500 + (float) (190 * Math.sin(Math.toRadians(i * 30))),250 - (float) (190 * Math.cos(Math.toRadians((i * 30)))),paint);
        }

        canvas.drawLine(y1,x1,y2,x2,paintclocklayout);
        canvas.drawLine(a1,b1,a2,b2,paintclocklayout);



    }
    int s=0;
    private void stopwatch(){

        if(start) {

            (new Thread(new Runnable() {

                @Override
                public void run() {
                    while (!Thread.interrupted())
                        try {
                            Thread.sleep(1000);
                            if (s == 60) {
                                a2 = 500 + (float) (180 * Math.sin(Math.toRadians(s * 6)));
                                b2 = 250 - (float) (180 * Math.cos(Math.toRadians(s * 6)));
                            }
                            Log.w("QWE", "QWE " + Math.cos(Math.toRadians(s * 6)));
                            x2 = 500 - (float) (450 * Math.cos(Math.toRadians(s * 6)));
                            y2 = 500 + (float) (450 * Math.sin(Math.toRadians(s * 6)));
                            s++;
                            postInvalidate();
                        } catch (InterruptedException e) {
                            // ooops
                        }
                }
            })).start();
        }

    }

    public void start(){
        start=true;
        stopwatch();


    }

    public void reset(){
        start=false;

        s=0;
        a2 = 500 + (float) (180 * Math.sin(Math.toRadians(s * 6)));
        b2 = 250 - (float) (180 * Math.cos(Math.toRadians(s * 6)));


    x2= 500-(float) (450*Math.cos(Math.toRadians(s*6)));
    y2= 500+(float) (450*Math.sin(Math.toRadians(s*6)));

    postInvalidate();


    }
}
