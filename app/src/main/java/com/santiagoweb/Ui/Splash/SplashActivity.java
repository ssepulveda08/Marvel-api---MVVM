package com.santiagoweb.Ui.Splash;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.santiagoweb.Ui.OperationActivity;
import com.santiagoweb.R;

public class SplashActivity extends AppCompatActivity implements SplashView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        changeActivity();
    }

    @Override
    public void dataChange() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void changeActivity() {
        new Handler().postDelayed(() ->{
            Intent startIntent = new Intent(this, OperationActivity.class);
            startActivity(startIntent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            //finish();
        }, 4500);
    }

    @Override
    public void onMessage(String msg) {

    }
}
