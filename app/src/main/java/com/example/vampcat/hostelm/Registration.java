package com.example.vampcat.hostelm;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Vampcat on 17 November.
 */

public class Registration extends Activity {
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        mAuth = FirebaseAuth.getInstance();
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

            mAuth.createUserWithEmailAndPassword(semail, spass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                // Sign in success, update UI with the signed-in user's information
//                                Log.d(TAG, "createUse rWithEmail:success");
//                                FirebaseUser user = mAuth.getCurrentUser();
//                                updateUI(user);
//                            } else {
//                                // If sign in fails, display a message to the user.
//                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                                Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                        Toast.LENGTH_SHORT).show();
//                                updateUI(null);
//                            }

                            // ...
                        }
                    });


        }
    }

}

