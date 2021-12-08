package com.example.Testeando.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Testeando.R;


public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 3000;

    ImageView backgroundImage;
    TextView tvsplash;
    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        backgroundImage = findViewById(R.id.gifImageView);
        tvsplash = findViewById(R.id.tvsplash);

        //animaciones
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //seteo de animaciones
        backgroundImage.setAnimation(sideAnim);
        tvsplash.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);*/

                ActivityOptions options = ActivityOptions.makeCustomAnimation(SplashScreen.this, R.anim.fadein, R.anim.fadeout);
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(intent, options.toBundle());
                finish();

            }
        }, SPLASH_TIMER);

    }


}

