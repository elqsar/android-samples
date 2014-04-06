package cz.boris.demo.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.ServiceAction;

import java.util.concurrent.TimeUnit;

/**
 * Created by Boris Musatov on 1.3.14.
 */
@EIntentService
public class SimpleService extends IntentService {

    private static final String TAG = "SampleService";

    @ServiceAction
    public void Action() {
        Log.d(TAG, "Service was called");
    }

    public SimpleService() {
        super("Simple Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {

        }
    }
}
