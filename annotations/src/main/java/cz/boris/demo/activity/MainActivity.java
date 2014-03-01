package cz.boris.demo.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.ColorRes;

import cz.boris.demo.R;

/**
 * Created by Boris Musatov on 1.3.14.
 */

@EActivity(R.layout.main_page)
public class MainActivity extends Activity {

    @ViewById(R.id.home_text)
    TextView homeText;
    @ViewById(R.id.main_page_container)
    RelativeLayout mainPageContainer;
    @ViewById(R.id.take_photo)
    Button takePhoto;
    @ViewById(R.id.photo)
    ImageView photo;

    @ColorRes(R.color.mainColor)
    int mainColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        View root = getWindow().getDecorView().getRootView();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
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
            startActivityForResult(intent, 2000);
        }
    }

    @OnActivityResult(2000)
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
