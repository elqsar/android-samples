package cz.boris.demo.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;

import cz.boris.demo.R;

/**
 * Created by Boris Musatov on 1.3.14.
 */
@EActivity(R.layout.drawing_layout)
@OptionsMenu(R.menu.main)
public class DrawingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }
}
