package cz.boris.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Boris Musatov on 18.4.2014.
 */
public class StrippedLinearLayout extends LinearLayout {

    private Paint paint;

    public StrippedLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(1);
        paint.setColor(Color.parseColor("#A9A9A9"));
        paint.setStyle(Paint.Style.STROKE);
    }

    public StrippedLinearLayout(Context context) {
        this(context, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawGrid(canvas);
    }

    private void drawGrid(Canvas canvas) {
        for (int i = 30; i < 510; i += 30) {
            if(i % 90 == 0) {
                paint.setStrokeWidth(2);
                paint.setColor(Color.parseColor("#000000"));
                canvas.drawLine(0, 0 + i, getWidth(), 0 + i, paint);
                paint.setStrokeWidth(1);
                paint.setColor(Color.parseColor("#A9A9A9"));
            } else {
                canvas.drawLine(0, 0 + i, getWidth(), 0 + i, paint);
            }
        }
    }
}
