package com.git.samplealpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class SignUpActivity extends Activity {


    EditText name, mail, password, phone;
    Button submit;
    TextView warn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupscreen);
        name = (EditText) findViewById(R.id.name);
        mail = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        phone = (EditText) findViewById(R.id.contact);
        submit = (Button) findViewById(R.id.submit);
        warn=(TextView)findViewById(R.id.error);
    }

    public void submit(View v) {
        String nam = name.getText().toString();
        String email = mail.getText().toString();
        String pwd = password.getText().toString();
        String phn = phone.getText().toString();


        /**
         * validate email and contact details and move to login acticity
         */
        if (isNameValid(nam)&& isValidEmail(email) && isPasswordValid(pwd) && isPhonenumberValid(phn)
                ) {
                        //all are valid details, store all these details
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));

        } else {
            warn.setText("Enter Valid Details!!");

                    }
    }

    public boolean isPhonenumberValid(CharSequence target) {

        if (TextUtils.isEmpty(target)) {
            phone.setError("This field cannot be empty!");
            return false;
        } else if (!(phone.getText().toString().length() == 10)) {
            phone.setError("Invalid number");
            return false;
        } else return true;


    }

    public boolean isNameValid(CharSequence target) {

        if (TextUtils.isEmpty(target)) {
            name.setError("This field cannot be empty!");
            return false;
        } else if (!(name.getText().toString().length() >=4)) {
            name.setError("name should be atleast 4 characters");
            return false;
        } else return true;


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

        else         if (!(password.getText().toString().length() > 4)) {
            password.setError("password should be atleast 4 characters");
            return false;
        }
        else
            return true;

    }

}