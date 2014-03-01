package cz.boris.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
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
        paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        path = new Path();
        matrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(80, 102, 204, 255);
        path.reset();
        path.addRect(300, 150, 450, 200, Path.Direction.CW);
        path.addRect(350, 100, 400, 250, Path.Direction.CW);
        paint.setColor(Color.GREEN);
        canvas.drawPath(path, paint);
        matrix.reset();
        matrix.setTranslate(300, 200);
        path.transform(matrix);
        paint.setColor(Color.BLUE);
        canvas.drawPath(path, paint);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(300, 100, 5, paint);
    }
}
