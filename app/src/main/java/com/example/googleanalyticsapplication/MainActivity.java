package com.example.googleanalyticsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        uiTracking2();

        uiTracking();

        shareImg();

        selectEventLog();

        userInterests("White");

    }

    private void shareImg(){
        //code for sharing
        //........

        shareEventLog("flowers", "whats app");
    }

    private void shareEventLog(String img_name, String share_to){
        Bundle bundle = new Bundle();
        bundle.putString("img_name", img_name);
        bundle.putString("share_to", share_to);

        mFirebaseAnalytics.logEvent("share_img", bundle);
    }

    private void selectEventLog(){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1234");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Burger");
        bundle.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Fast Food");

        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle);

    }

    private void uiTracking2(){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity");
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, "main activity");

        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
    }

    private void uiTracking(){
        mFirebaseAnalytics.setCurrentScreen(this, "third_ui", null);
    }





    private void userInterests(String color){
        mFirebaseAnalytics.setUserProperty("interests_color", color);
        //mFirebaseAnalytics.getFirebaseInstanceId();
    }
}