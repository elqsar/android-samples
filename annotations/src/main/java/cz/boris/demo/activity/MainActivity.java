package cz.boris.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.ColorRes;

import cz.boris.demo.R;

/**
 * Created by Boris Musatov on 1.3.14.
 */

@EActivity(R.layout.main_page)
@OptionsMenu(R.menu.main)
public class MainActivity extends BaseActivity {

    public static Class<? extends Activity> get() {
        return MainActivity_.class;
    }

    public static final int TAKE_PHOTO_REQUEST = 2000;

    @ViewById(R.id.home_text)
    TextView homeText;
    @ViewById(R.id.main_page_container)
    RelativeLayout mainPageContainer;
    @ViewById(R.id.take_photo)
    Button takePhoto;
    @ViewById(R.id.photo)
    ImageView photo;
    @ViewById(R.id.next_page)
    Button nextPage;

    @ColorRes(R.color.mainColor)
    int mainColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    public void setupUI() {
        homeText.setText("Hello from Annotated Activity");
        mainPageContainer.setBackgroundColor(mainColor);
    }

    @Click
    public void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, TAKE_PHOTO_REQUEST);
        }
    }

    @Click(R.id.next_page)
    public void nextPage() {
        Intent intent = new Intent(this, DrawingActivity_.class);
        startActivity(intent);
    }

    @OnActivityResult(TAKE_PHOTO_REQUEST)
    public void putPhoto(int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            photo.setImageBitmap(bitmap);
        }
    }

    @Click(R.id.home_text)
    public void showMessage() {
        Toast.makeText(this, "Just simple click!", Toast.LENGTH_SHORT).show();
    }

    @OptionsItem(R.id.action_settings)
    public boolean settings() {
        Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();
        return true;
    }
}
