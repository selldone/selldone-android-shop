package selldone.ui.gesture;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

public class SwipeConstraintLayout extends ConstraintLayout {
    View inActiveCardView = null;
    Rect rect = new Rect();
    private GestureDetector mGestureDetector;

    public SwipeConstraintLayout(Context context) {
        super(context);
    }

    public SwipeConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        mGestureDetector = gestureDetector;
    }

    public void setInActiveCardView(View inActiveCardView) {
        this.inActiveCardView = inActiveCardView;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //
        if (inActiveCardView != null) {
            inActiveCardView.getHitRect(rect);
            if (rect.contains((int) ev.getX(), (int) ev.getY())) {
                return true;
            }
        }

        return super.onInterceptTouchEvent(ev);

    }
}