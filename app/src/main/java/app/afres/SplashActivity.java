package app.afres;

import com.viksaa.sssplash.lib.activity.AwesomeSplash;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;
/**
 * Created by mrarifin on 18/07/2018.
 */

public class SplashActivity extends AwesomeSplash {
    @Override
    public void initSplash(ConfigSplash configSplash){
    ActionBar actionBar= getSupportActionBar();
    actionBar.hide();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //menambahan background
        configSplash.setBackgroundColor(R.color.putih);
        configSplash.setAnimCircularRevealDuration(4000);
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
        configSplash.setRevealFlagX(Flags.REVEAL_BOTTOM);
        //menambahkan logo
        configSplash.setLogoSplash(R.drawable.logo);
        configSplash.setAnimLogoSplashDuration(3000);
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);

        configSplash.setTitleSplash("MA NURUL IMAN SEKINCAU");
        configSplash.setTitleTextColor(R.color.greenn);
        configSplash.setTitleTextSize(25f);
        configSplash.setAnimTitleDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.FadeOut);
    }

    @Override
    public void animationsFinished() {
        finish();
        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
    }

}


