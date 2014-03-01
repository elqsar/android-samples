package cz.boris.demo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import cz.boris.demo.annotations.R;

/**
 * Created by musatov on 28.2.14.
 */
@EViewGroup(R.layout.image_with_title)
public class PhotoView extends RelativeLayout {

    @ViewById(R.id.photo)
    ImageView photo;
    @ViewById(R.id.photo_title)
    TextView photoTitle;
    @ViewById(R.id.take_photo)
    Button takePhoto;

    public PhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


}
