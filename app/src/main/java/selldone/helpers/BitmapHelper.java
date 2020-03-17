package selldone.helpers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class BitmapHelper {
    public static Bitmap getBitmapFromVector(Drawable drawable) {
        return getBitmapFromVector(drawable, 1);
    }

    public static Bitmap getBitmapFromVector(Drawable drawable, int factor_IntrinsicSize) {
        try {

            Bitmap bitmap;
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth() * factor_IntrinsicSize, drawable.getIntrinsicHeight() * factor_IntrinsicSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }
}
