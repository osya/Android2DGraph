package com.vosipov.android_2d_graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by info_000 on 10-Mar-17.
 */

public class Draw2D extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path mPath = new Path();

    public Draw2D(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.BLUE);

        float prevX = 0;
        float prevY = 0;

        int x0 = canvas.getWidth()/2;
        int y0 = canvas.getHeight()/2;
        int numPoints = 600;
        for (int i=0; i<numPoints; i++)
        {
            double t = (double)i / numPoints * (12 * Math.PI);
            float x = (float)(x0 + 120 * Math.sin(t) * (Math.exp(Math.cos(t)) - 2 * Math.cos(4 * t) + Math.pow(Math.sin(t / 12), 5)));
            float y = (float)(y0 - 120 * Math.cos(t) * (Math.exp(Math.cos(t)) - 2 * Math.cos(4 * t) + Math.pow(Math.sin(t / 12), 5)));
            if (i > 0) {
                mPath.quadTo(prevX, prevY, x, y);
            }
            prevX = x;
            prevY = y;
            mPath.moveTo(x, y);
        }
        canvas.drawPath(mPath, mPaint);
    }
}
