package com.example.vampcat.hostelm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void onLogin(View v)
    {
        if(v.getId() == R.id.Blogin)
        {
            EditText userName = (EditText)findViewById(R.id.ETusername);
            String str = userName.getText().toString();
            Intent i = new Intent(LoginPage.this,SuccessfulLogin.class );
            i.putExtra("username",str);
            startActivity(i);
        }
        if(v.getId() == R.id.TVforgotpassword)
        {
            Intent i =  new Intent(this, ForgotPassword.class);
            startActivity(i);

        }
        if(v.getId() == R.id.TVregister)
        {
            Intent i =  new Intent(this, Registration.class);
            startActivity(i);
        }
    }
}
