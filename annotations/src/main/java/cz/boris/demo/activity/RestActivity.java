package cz.boris.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

import cz.boris.demo.R;
import cz.boris.demo.data.User;
import cz.boris.demo.network.SimpleRestClient;

/**
 * Created by Boris Musatov on 3.3.14.
 */
@EActivity(R.layout.fragment_container)
@OptionsMenu(R.menu.main)
public class RestActivity extends BaseActivity {

    public static Class<? extends Activity> get() {
        return RestActivity_.class;
    }

    @RestService
    SimpleRestClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    @Background
    public void fetch() {
        User user = client.getUser("elqsar");
        Log.d("Rest Call", user.email);
        Log.d("Rest Call", user.name);
        Log.d("Rest Call", user.company);
        Log.d("Rest Call", user.location);
        Log.d("Rest Call", String.valueOf(user.publicRepos));
    }

    @UiThread
    public void updateUI(User user) {
        
    }

}
