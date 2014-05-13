package cz.boris.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

import org.androidannotations.annotations.EView;

/**
 * Created by Boris Musatov on 1.3.14.
 */
@EView
public class DrawView extends View {

    Paint paint;
    Path path;
    Matrix matrix;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(1);
        paint.setColor(Color.parseColor("#A9A9A9"));
        paint.setStyle(Paint.Style.STROKE);
        path = new Path();
        matrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(255, 255, 255, 255);
        path.reset();
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
        Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setColor(Color.parseColor("#AA00E0"));
        paint1.setStrokeWidth(10);
        canvas.drawRect(100, 100, 150, 200, paint1);
        paint1.setColor(Color.parseColor("#EEEEEE"));
        canvas.drawRect(100,200,150,300, paint1);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.setIntrinsicHeight(2);
        shapeDrawable.setIntrinsicWidth(200);
        shapeDrawable.getPaint().setColor(Color.GREEN);
        shapeDrawable.draw(canvas);
//        for (int i = 25; i < 500; i += 25) {
//            canvas.drawLine(0, 0 + i, 500, 0 + i, paint);
//        }

    }
}
