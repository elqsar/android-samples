package cz.boris.demo.application;

import android.app.Application;

import org.androidannotations.annotations.EApplication;

/**
 * Created by Boris Musatov on 1.3.14.
 */

@EApplication
public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
