package co.edu.javeriana.acm.modernartui;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

/**
 * Created by JuanPablo on 12/10/16.
 */

public class RectangleOneFragment extends View {

    private Paint mPaintRect1;
    private Paint mPaintRect2;
    private Paint mPaintRect3;
    private Paint mPaintRect4;
    private Paint mPaintRect5;
    private Rect mRect1;
    private Rect mRect2;
    private Rect mRect3;
    private Rect mRect4;
    private Rect mRect5;

    public RectangleOneFragment (Context context) {
        super(context);
        init(null,0);
    }

    public RectangleOneFragment (Context context, AttributeSet attrs) {
        super(context,attrs);
        init(attrs,0);
    }

    public RectangleOneFragment (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(null,defStyle);
    }

    private void init (AttributeSet attrs, int defStyle) {
        mPaintRect1 = new Paint();
        mPaintRect2 = new Paint();
        mPaintRect3 = new Paint();
        mPaintRect4 = new Paint();
        mPaintRect5 = new Paint();

        mPaintRect1.setColor(Color.rgb(0,136,203));
        mPaintRect2.setColor(Color.rgb(163,0,92));
        mPaintRect3.setColor(Color.rgb(200,0,0));
        mPaintRect4.setColor(Color.rgb(42,139,0));
        mPaintRect5.setColor(Color.rgb(255,255,255));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawARGB(255,0,0,0);

        int margin = canvas.getWidth() / 50;
        int floorPadding = canvas.getHeight() / 20;

        mRect1 = new Rect();
        mRect1.set(0,0,canvas.getWidth()/3, canvas.getHeight()/2);

        mRect2 = new Rect();
        mRect2.set((canvas.getWidth()/3) + margin,0, canvas.getWidth() , canvas.getHeight()/4);

        mRect3 = new Rect();
        mRect3.set(0, canvas.getHeight()/2 + margin,canvas.getWidth()/3, canvas.getHeight() - floorPadding);

        mRect4 = new Rect();
        mRect4.set((canvas.getWidth()/3) + margin, canvas.getHeight()/4 + margin, canvas.getWidth() , canvas.getHeight() / 3);

        mRect5 = new Rect();
        mRect5.set((canvas.getWidth()/3) + margin, canvas.getHeight()/3 + margin, canvas.getWidth() , canvas.getHeight() - floorPadding);

        canvas.drawRect(mRect1,mPaintRect1);
        canvas.drawRect(mRect2,mPaintRect2);
        canvas.drawRect(mRect3,mPaintRect3);
        canvas.drawRect(mRect4,mPaintRect4);
        canvas.drawRect(mRect5,mPaintRect5);
    }

    public ColorController getInstaceOfCollorController() {
        return new ColorController();
    }

    private class ColorController implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            double increase = 255.0 * (Double.valueOf(i) / 100.00);

            mPaintRect5.setColor(Color.rgb(255-i,255-i,255-i));
            i = Double.valueOf(increase).intValue();
            mPaintRect1.setColor(Color.rgb(i,136,203));
            mPaintRect2.setColor(Color.rgb(163,i,92));
            mPaintRect3.setColor(Color.rgb(200,i,i));
            mPaintRect4.setColor(Color.rgb(42,139,i));

            Log.d("TAG", String.valueOf(i));
            invalidate();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
