
package com.example.mvvmsample.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

import com.example.mvvmsample.AppClass;
import com.example.mvvmsample.data.DataManager;
import com.example.mvvmsample.di.component.DaggerServiceComponent;

import javax.inject.Inject;


public class SyncService extends Service {

    private static final String TAG = "SyncService";

    Messenger messenger = new Messenger(new InComingHandler());


    @Inject
    DataManager mDataManager;


    public static Intent getStartIntent(Context context) {
        return new Intent(context, SyncService.class);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SyncService.class);
        context.startService(starter);
    }

    public static void stop(Context context) {
        context.stopService(new Intent(context, SyncService.class));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerServiceComponent.builder()
                .applicationComponent(((AppClass) getApplication()).getComponent())
                .build().inject(this);
//        component.inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("onHandleIntent", "  onStartCommand >>>> ");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    for (int i = 0; i < 10; i++) {
//                        Log.d("onHandleIntent", "  onStartCommand >>>> " + i);
//                        Thread.sleep(1000);
//                        Intent intent = new Intent("ACTION");
//                        intent.putExtra("message", "This is my message!");
//                        LocalBroadcastManager.getInstance(SyncService.this).sendBroadcast(intent);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        stopSelf();


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("onHandleIntent", "  onDestroy >>>> ");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    public class InComingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 1:
                    Toast.makeText(getApplicationContext(), " case 1", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(getApplicationContext(), " default ", Toast.LENGTH_SHORT).show();
            }
            super.handleMessage(msg);
        }
    }

    public String getOffer() {
        return "Offer released";
    }


}
