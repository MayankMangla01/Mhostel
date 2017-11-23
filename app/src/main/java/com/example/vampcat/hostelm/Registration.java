package com.example.vampcat.hostelm;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Vampcat on 17 November.
 */

public class Registration extends Activity {
    private Firebase mRootRef;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        mRootRef = new Firebase("https://hostel-m-5fc38.firebaseio.com/Users")
    }

    public void onRegister(View v)
    {
        if(v.getId() == R.id.Rregister)
        {
            EditText name = (EditText)findViewById(R.id.Rname);
            EditText rollno = (EditText)findViewById(R.id.Rrollnumber);
            EditText email = (EditText)findViewById(R.id.Remail);
            EditText pass = (EditText)findViewById(R.id.Rpassword);
            EditText cpass = (EditText)findViewById(R.id.Rconfirmpassword);

            String sname = name.getText().toString();
            String srollno = rollno.getText().toString();
            String semail = email.getText().toString();
            String spass = pass.getText().toString();
            String scpass = cpass.getText().toString();

            if(!spass.equals(scpass))
            {
                //pop up msg
                Toast tpass = Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT);
                tpass.show();
            }

            Firebase childRef = mRootRef.child("xName");
            childRef.setValue(sname);

        }
    }

}

