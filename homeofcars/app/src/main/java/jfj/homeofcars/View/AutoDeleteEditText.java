package jfj.homeofcars.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

import jfj.homeofcars.R;

/**
 * 自定义带删除按钮的EditText
 */
public class AutoDeleteEditText extends EditText implements OnFocusChangeListener {

    private Boolean hasFocus;
    private Drawable mClearDrawable;//输入框的右侧的删除按钮
    private Paint mPaint;

    public AutoDeleteEditText(Context context) {
        super(context);
        initDatas();
    }

    public AutoDeleteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDatas();
    }

    public AutoDeleteEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDatas();
    }

    /**
     * 初始化各种数据
     */
    private void initDatas() {
        mPaint=new Paint();
        mPaint.setStyle(Style.STROKE);
        mPaint.setColor(Color.BLACK);
        //获取editText的DrawableRight,假设没有设置我们就是用默认的图片,获取图片的顺序是左上右下(0,1,2,3)
        mClearDrawable = getCompoundDrawables()[2];
        if (mClearDrawable == null) {
            mClearDrawable = getResources().getDrawable(R.mipmap.ahlib_close_activity);
        }
        //getIntrinsicWidth()和getIntrinsicHeight()返回mClearDrawable的宽高是dp为单位
        mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(), mClearDrawable.getIntrinsicHeight());
        //默认设置隐藏的图标
        setClearIconVisible(false);
        //设置焦点改变的监听
        setOnFocusChangeListener(this);
        //设置输入框里面内容发生改变的监听
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (hasFocus) {
                    setClearIconVisible(charSequence.length() > 0);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    /* @说明：isInnerWidth, isInnerHeight为ture，触摸点在删除图标之内，则视为点击了删除图标
         * event.getX() 获取相对应自身左上角的X坐标
         * event.getY() 获取相对应自身左上角的Y坐标
         * getWidth() 获取控件的宽度
         * getHeight() 获取控件的高度
         * getTotalPaddingRight() 获取删除图标左边缘到控件右边缘的距离
         * getPaddingRight() 获取删除图标右边缘到控件右边缘的距离
         * isInnerWidth:
         *  getWidth() - getTotalPaddingRight() 计算删除图标左边缘到控件左边缘的距离
         *  getWidth() - getPaddingRight() 计算删除图标右边缘到控件左边缘的距离
         * isInnerHeight:
         *  distance 删除图标顶部边缘到控件顶部边缘的距离
         *  distance + height 删除图标底部边缘到控件顶部边缘的距离
         */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (getCompoundDrawables()[2] != null) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                Rect rect = getCompoundDrawables()[2].getBounds();
                int height = rect.height();
                int distance = (getHeight() - height) / 2;
                boolean isInnerWidth = x > (getWidth() - getTotalPaddingRight()) && x < (getWidth() - getPaddingRight());
                boolean isInnerHeight = y > distance && y < (distance + height);
                if (isInnerWidth && isInnerHeight) {
                    this.setText("");
                }
            }
        }
        return super.onTouchEvent(event);
    }


    /**
     * 设置默认隐藏的图标
     *
     * @param visible
     */
    private void setClearIconVisible(Boolean visible) {
        Drawable right = visible ? mClearDrawable : null;
        setCompoundDrawables(getCompoundDrawables()[0],
                getCompoundDrawables()[1],
                right,
                getCompoundDrawables()[3]);
    }


    /**
     * 设置当焦点改变的监听
     * 输入长度为零,隐藏删除图标,否则,显示删除图标
     *
     * @param view
     * @param b
     */
    @Override
    public void onFocusChange(View view, boolean b) {
        this.hasFocus = b;
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,getHeight()-1,getWidth()-1,getHeight()-1,mPaint);
    }
}
