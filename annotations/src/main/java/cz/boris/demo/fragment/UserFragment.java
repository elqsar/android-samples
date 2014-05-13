package cz.boris.demo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import cz.boris.demo.R;

/**
 * Created by Boris Musatov on 13.5.2014.
 */
@EFragment(R.layout.user_fragment)
public class UserFragment extends Fragment {

    @ViewById(R.id.userContainer)
    LinearLayout userContainer;

    public static UserFragment newInstance(Bundle bundle) {
        UserFragment fragment = new UserFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @AfterViews
    public void prepareView() {

    }
}
