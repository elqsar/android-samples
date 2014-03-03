package cz.boris.demo.activity;

import android.os.Bundle;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;

import cz.boris.demo.R;
import cz.boris.demo.fragment.MainMenuFragment;

/**
 * Created by Boris Musatov on 3.3.14.
 */
@EActivity(R.layout.fragment_container)
@OptionsMenu(R.menu.main)
public class MainMenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().add(R.id.fragment_container, MainMenuFragment.newInstance()).commit();
    }
}
