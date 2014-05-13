package cz.boris.demo.activity;

import android.app.Activity;
import android.os.Bundle;

import org.androidannotations.annotations.EActivity;

import cz.boris.demo.R;
import cz.boris.demo.fragment.TopicFragment;

/**
 * Created by Boris Musatov on 1.3.14.
 */
@EActivity(R.layout.fragment_container)
public class FragmentActivity extends BaseActivity {

    public static Class<? extends Activity> get() {
        return FragmentActivity_.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TopicFragment fragment = TopicFragment.newInstance(new Bundle());
        getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        getActionBar().setTitle("Simple Loader");
    }
}
