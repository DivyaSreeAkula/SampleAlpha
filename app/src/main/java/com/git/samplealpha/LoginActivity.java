package com.git.samplealpha;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;
public class LoginActivity extends AppCompatActivity {
    public EditText mail;
    EditText password;
    Button signin, signup, skip;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);
        mail = (AutoCompleteTextView) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.email_sign_in_button);
        signup = (Button) findViewById(R.id.email_sign_up_button);
        skip = (Button) findViewById(R.id.email_skip_button);
    }


    /**
     * onclicking on signup button awakes
     * signup activity method
     *
     * @param v
     */
    public void signup(View v) {
        //moves to signup activity
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }


    /**
     * onclicking on signin button awakes
     * signin activity method
     *
     * @param v
     */

    public void signin(View v) {
//on entering a valid email id
        if (isValidEmail(mail.getText().toString()) && isPasswordValid(password.getText().toString())) {
            //check whether the entered email id and password is regestered or not
        } else {
            // display invalid email id or invalid password
        }

    }


    /**
     * onclicking on skip button awakes
     *
     * @param v
     */
    public void skip(View v) {

        startActivity(new Intent(LoginActivity.this, SkipActivity.class));

    }

    //to check the validity of the email
    public boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            mail.setError("This field cannot be empty!");
            return false;
        }
        else if (android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches())
            return true;
        else {
            mail.setError("Invalid mail!");
            return false;
        }

    }

    //to check validity of the password
    public boolean isPasswordValid(CharSequence target) {

        if (TextUtils.isEmpty(target)) {
            password.setError("This field cannot be empty!");
            return false;}

        else         if (!(password.getText().toString().length() >=4)) {
            password.setError("password should be atleast 4 characters");
            return false;
        }
        else
            return true;

    }
}


