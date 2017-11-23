package com.example.vampcat.hostelm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mAuth = FirebaseAuth.getInstance();
    }

    public void onLogin(View v)
    {
        if(v.getId() == R.id.Blogin)
        {
            EditText userName = (EditText)findViewById(R.id.ETusername);
            EditText password = (EditText)findViewById(R.id.ETpassword);
            String sUserName = userName.getText().toString();
            String sPassword = password.getText().toString();
            Intent i = new Intent(LoginPage.this,SuccessfulLogin.class );
            i.putExtra("username",sUserName);
            startActivity(i);

            if(TextUtils.isEmpty(sUserName) || TextUtils.isEmpty(sPassword))

                mAuth.createUserWithEmailAndPassword(sUserName, sPassword)
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
