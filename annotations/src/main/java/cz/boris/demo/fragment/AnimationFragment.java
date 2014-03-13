package cz.boris.demo.fragment;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import cz.boris.demo.R;

@EFragment(R.layout.animation_fragment)
public class AnimationFragment extends Fragment {

    @ViewById(R.id.details)
    TextView details;
    @ViewById(R.id.drawConteiner)
    LinearLayout container;

    public static AnimationFragment newInstance() {
        return new AnimationFragment_();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @AfterViews
    public void initUI() {
        container.addView(new DrawView(getActivity()));
    }

    @Click(R.id.title_one)
    public void showHide() {
        if(details.getAlpha() == 0) {
            details.animate().alpha(100);
        } else {
            details.animate().alpha(0);
        }
    }

    class DrawView extends View {

        Paint paint;
        Rect rect;

        public DrawView(Context context) {
            super(context);
            rect = new Rect(100, 200, 200, 500);
            paint = new Paint();
            setBackgroundColor(Color.WHITE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(rect, paint);
        }
    }
}