package com.example.vampcat.hostelm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Vampcat on 17 November.
 */
public class ForgotPassword extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);
    }
    public void onVerify(View v)
    {
        if(v.getId() == R.id.verify)
        {
            EditText email = (EditText)findViewById(R.id.ETemail);
            EditText pass = (EditText)findViewById(R.id.ETnewpassword);
            EditText cpass = (EditText)findViewById(R.id.ETconfirmpassword);


            String semail = email.getText().toString();
            String spass = pass.getText().toString();
            String scpass = cpass.getText().toString();

            if(!spass.equals(scpass))
            {
                // popup msg
                Toast tpass = Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_LONG);
                tpass.show();
            }
        }

    }
}