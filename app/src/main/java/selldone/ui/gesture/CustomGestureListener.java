package selldone.ui.gesture;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public abstract class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {

    private final View mView;

    public CustomGestureListener(View view) {
        mView = view;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        if (mView != null)
            mView.onTouchEvent(e);
        return super.onSingleTapConfirmed(e);
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        onTouch();
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        onDownCall(e);
        return super.onDown(e);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        onFlingCall(e1, e2, velocityX, velocityY);
        boolean action = false;


  /*      if (e1.getX() < e2.getX()) {
            action|=     onSwipeRight(velocityX);
        }

        if (e1.getX() > e2.getX()) {
            action|=     onSwipeLeft(velocityX);
        }

        if (e1.getY() > e2.getY()) {
            action|=     onSwipeUp(velocityY);
        }
        if (e1.getY() < e2.getY()) {
            action|=   onSwipeDown(velocityY);
        }*/

        if (velocityX > 0) {
            action |= onSwipeRight(Math.abs(velocityX));
        }

        if (velocityX < 0) {
            action |= onSwipeLeft(Math.abs(velocityX));
        }

        if (velocityY < 0) {
            action |= onSwipeUp(Math.abs(velocityY));
        }
        if (velocityY > 0) {
            action |= onSwipeDown(Math.abs(velocityY));
        }


        return action | onTouch();
    }

    public abstract void onDownCall(MotionEvent e);

    public abstract void onFlingCall(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY);

    public abstract boolean onSwipeRight(float velocityX);

    public abstract boolean onSwipeLeft(float velocityX);

    public abstract boolean onSwipeDown(float velocityY);

    public abstract boolean onSwipeUp(float velocityY);


    public abstract boolean onTouch();
}