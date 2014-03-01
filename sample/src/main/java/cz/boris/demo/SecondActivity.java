package cz.boris.demo;

import android.app.Activity;
import android.os.Bundle;

import cz.boris.demo.R;
import cz.boris.demo.fragment.MainFragment;

/**
 * Created by musatov on 23.2.14.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);
        getFragmentManager().beginTransaction().add(R.id.fragment_container, MainFragment.newInstance()).commit();
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("Main Activity");
    }
}
