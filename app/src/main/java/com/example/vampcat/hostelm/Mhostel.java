package com.example.vampcat.hostelm;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Vampcat on 23 November.
 */

public class Mhostel extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
