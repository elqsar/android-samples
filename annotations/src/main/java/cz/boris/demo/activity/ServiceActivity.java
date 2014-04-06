package cz.boris.demo.activity;

import android.os.Bundle;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;

import cz.boris.demo.R;
import cz.boris.demo.service.SimpleService_;

/**
 * Created by Boris Musatov on 15.3.14.
 */
@EActivity(R.layout.fragment_container)
@OptionsMenu(R.menu.main)
public class ServiceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SimpleService_.intent(this).start();
    }
}
