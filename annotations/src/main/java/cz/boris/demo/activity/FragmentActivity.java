package cz.boris.demo.activity;

import android.os.Bundle;

import cz.boris.demo.R;
import cz.boris.demo.fragment.TopicFragment;

/**
 * Created by Boris Musatov on 1.3.14.
 */
public class FragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);
        TopicFragment fragment = TopicFragment.newInstance(new Bundle());
        getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        getActionBar().setTitle("Simple Loader");

    }
}
