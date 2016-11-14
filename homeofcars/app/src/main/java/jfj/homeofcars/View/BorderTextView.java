package jfj.homeofcars.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 带边框的textview
 */
public class BorderTextView extends TextView{
    private Paint mPaint;
    private int borderColor= Color.parseColor("#e6e6e6");
    private int borderWidth=2;
    public BorderTextView(Context context) {
        super(context);
    }

    public BorderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BorderTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }
    protected void setBorderColor(int color){
        borderColor =color;
    }
    protected void setBorderWidth(int width){
        borderWidth=width;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect=canvas.getClipBounds();//获取Canvas上截取的矩形
        mPaint=new Paint();
        mPaint.setColor(borderColor);
        mPaint.setStyle(Style.STROKE);
        mPaint.setStrokeWidth(borderWidth);
        canvas.drawRect(rect,mPaint);
    }
}
