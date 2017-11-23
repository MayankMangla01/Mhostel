package com.example.vampcat.hostelm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView fp ;
    EditText userName ;
    EditText password ;
    String sUserName ;
    String sPassword ;
    ProgressDialog progressDialog;
    Boolean EditTextEmptyCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mAuth = FirebaseAuth.getInstance();
        fp = (TextView) findViewById(R.id.TVforgotpassword);
        userName = (EditText) findViewById(R.id.ETusername);
        password = (EditText) findViewById(R.id.ETpassword);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String resetemail = userName.getText().toString().trim();
                //    progressDialog.setMessage("Please Wait");

                // Showing progressDialog.
                //    progressDialog.show();
                mAuth.sendPasswordResetEmail(resetemail)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    //    progressDialog.dismiss();

                                    Toast.makeText(LoginPage.this, "Reset password mail sent", Toast.LENGTH_LONG).show();
                                    password.setText("");
                                }
                            }
                        });
            }
        });
    }
    // Creating method to check EditText is empty or not.
    public void CheckEditTextIsEmptyOrNot(){

        Log.d("test","verify");

        // Getting value form Email's EditText and fill into EmailHolder string variable.
        sUserName = userName.getText().toString().trim();

        // Getting value form Password's EditText and fill into PasswordHolder string variable.
        sPassword = password.getText().toString().trim();

        // Checking Both EditText is empty or not.
        if(TextUtils.isEmpty(sUserName) || TextUtils.isEmpty(sPassword))
        {

            // If any of EditText is empty then set value as false.
            EditTextEmptyCheck = false;

        }
        else {

            // If any of EditText is empty then set value as true.
            EditTextEmptyCheck = true ;

        }

    }


    public void onLogin(View v) {
        if (v.getId() == R.id.Blogin) {

            sUserName = userName.getText().toString().trim();
            sPassword = password.getText().toString().trim();
            CheckEditTextIsEmptyOrNot();
            if(EditTextEmptyCheck) {

                mAuth.signInWithEmailAndPassword(sUserName, sPassword)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("email", "createUse rWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent i = new Intent(LoginPage.this, SuccessfulLogin.class);
                                    i.putExtra("username", sUserName);
                                    startActivity(i);
                                    //updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("email", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(LoginPage.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    // updateUI(null);
                                }

                                // ...
                            }
                        });
            }
            else{

                // If  EditTextEmptyCheck == false then toast display on screen.
                Toast.makeText(LoginPage.this, "Please Fill All the Fields", Toast.LENGTH_LONG).show();
            }

            //if(v.getId() == R.id.TVforgotpassword)


            //Intent i =  new Intent(this, ForgotPassword.class);

            // startActivity(i);

        }
        if (v.getId() == R.id.TVregister) {
            Intent i = new Intent(this, Registration.class);
            startActivity(i);
        }
    }

}
