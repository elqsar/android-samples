package cz.boris.demo.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.ServiceAction;

/**
 * Created by Boris Musatov on 1.3.14.
 */
@EIntentService
public class SimpleService extends IntentService {

    private static final String TAG = "SampleService";

    @ServiceAction
    public void Action() {
        Log.d(TAG, "Service was called from");
    }

    public SimpleService() {
        super("Simple Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent.getAction().equals("Action")) {
            try {
                Log.d(TAG, "working on...");
            } catch (Exception e) {

            }
        }
    }
}
