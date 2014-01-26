package in.cix.appsite;



import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {
	
    private long splashTime = 1500;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashscreen);
        
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent homeIntent = new Intent().setClass(SplashActivity.this, AppSiteHome.class);
                startActivity(homeIntent);
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, splashTime);
    }
}
