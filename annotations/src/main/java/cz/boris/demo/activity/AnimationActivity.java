package cz.boris.demo.activity;

import android.app.Activity;
import android.os.Bundle;

import org.androidannotations.annotations.EActivity;

import cz.boris.demo.R;
import cz.boris.demo.fragment.AnimationFragment;

/**
 * Created by Boris Musatov on 13.3.14.
 */
@EActivity(R.layout.fragment_container)
public class AnimationActivity extends BaseActivity {

    public static Class<? extends Activity> get() {
        return AnimationActivity_.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnimationFragment fragment = AnimationFragment.newInstance();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();

    }
}
