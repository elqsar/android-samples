package cz.boris.demo.service;

import android.app.IntentService;
import android.content.Intent;

import java.util.concurrent.TimeUnit;

/**
 * Created by Boris Musatov on 1.3.14.
 */
public class SimpleService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
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
