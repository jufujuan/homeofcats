package jfj.homeofcars.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 带边框的Imageview
 */
public class BorderImageView extends ImageView{
    private int borderColor = Color.BLACK;//边框颜色
    private int borderWidth=2;//边框宽度
    private Paint mPaint;//画笔
    public BorderImageView(Context context) {
        super(context);
    }

    public BorderImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BorderImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置边框颜色
     * @param color
     */
    protected void setBorderColor(int color){
        borderColor =color;
    }
    protected void setBorderWidth(int width){
        borderWidth=width;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect=canvas.getClipBounds();
        mPaint=new Paint();
        mPaint.setColor(borderColor);
        mPaint.setStyle(Style.STROKE);
        mPaint.setStrokeWidth(borderWidth);
        canvas.drawRect(rect,mPaint);

    }
}
