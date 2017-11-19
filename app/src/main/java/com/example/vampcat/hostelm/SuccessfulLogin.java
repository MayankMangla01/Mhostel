package com.example.vampcat.hostelm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Vampcat on 15 November.
 */

public class SuccessfulLogin extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.successfullogin);
        String Username = getIntent().getStringExtra("username");

        TextView tv = findViewById(R.id.TVusername);
        tv.setText(Username);
    }

    public void onSL(View v)
    {
        if(v.getId() == R.id.Bcomplaints)
        {
            Intent i = new Intent(SuccessfulLogin.this,Complaints.class );
            startActivity(i);
        }
        if(v.getId() == R.id.Bnoti)
        {
          Intent i = new Intent(this, Notifications.class);
          startActivity(i);
        }
        if(v.getId() == R.id.Bmmenu)
        {
            Intent i = new Intent(this, MessMenu.class);
            startActivity(i);
        }

    }

}
