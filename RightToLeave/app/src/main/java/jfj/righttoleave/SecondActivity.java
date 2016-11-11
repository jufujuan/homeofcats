package jfj.righttoleave;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

public class SecondActivity extends AppCompatActivity {
    private LinearLayout ll;
    private float mXDown;
    private float mXMove;
    private VelocityTracker mVelocityTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ll = (LinearLayout) findViewById(R.id.ll2);
        ll.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mVelocityTracker = VelocityTracker.obtain();
                mVelocityTracker.addMovement(motionEvent);
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mXDown = motionEvent.getRawX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mXMove = motionEvent.getRawX();
                        int distanceX= (int) (mXDown-mXDown);
                        int xPeed=getScroll();
                        if (distanceX>200&&xPeed>200){
                            overridePendingTransition(R.anim.in_from_left,R.anim.out_to_left);
                            finish();
                        }
                        break;
                }
                return false;
            }
        });
    }

    private int getScroll() {
        mVelocityTracker.computeCurrentVelocity(1000);
        int ve= (int) mVelocityTracker.getXVelocity();
        return Math.abs(ve);
    }
}
