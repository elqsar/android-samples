package cz.boris.demo.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Boris Musatov on 1.3.14.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }
}
