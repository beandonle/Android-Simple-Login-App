package com.example.hm1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Patterns;
import java.util.HashMap;

import android.os.Bundle;

public class SignUp extends AppCompatActivity
{
    private EditText userName = null;
    private EditText password = null;
    private EditText rePassword = null;
    private EditText email = null;
    private EditText phone = null;
    private Button registerButton = null;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userName = findViewById(R.id.UserName);
        password = findViewById(R.id.Password);
        rePassword = findViewById(R.id.RePassword);
        email = findViewById(R.id.Email);
        phone = findViewById(R.id.PhoneNum);
        registerButton = findViewById(R.id.SignUpButton);

        registerButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                // create String of account credentials
                String name = userName.getText().toString();
                String pw = password.getText().toString();
                String rePW = rePassword.getText().toString();
                String e_mail = email.getText().toString();
                String phoneNum = phone.getText().toString();

                // flag values to make sure valid credentials were entered
                int nameFlag = 0;
                int pwFlag = 0;
                int emailFlag = 0;
                int phoneNumFlag = 0;

                // check userName was entered
                if (!name.isEmpty() && !name.equals(userName)) // check to make sure user name has not been taken
                {
                    nameFlag = 1;
                }
                else if(name.equals(userName))
                {
                    Toast.makeText(getApplicationContext(), "User name has been taken", Toast.LENGTH_LONG).show();
                }

                // checks to make sure the password and reentered password are the same
                if (pw.equals(rePW)) {
                    pwFlag = 1;
                }

                // check to make sure a valid email was entered
                if (!emailFormat(e_mail)) {
                    Toast.makeText(getApplicationContext(), "Invalid email", Toast.LENGTH_LONG).show();
                }
                else {
                    emailFlag = 1;
                }

                // check to make sure valid email was entered
                if (phoneNum.length() == 10) {
                    phoneNumFlag = 1;
                }

                if (nameFlag == 1 && pwFlag == 1 && emailFlag == 1 && phoneNumFlag == 1)
                {
                    Intent result = new Intent();
                    result.putExtra("userObject", new User(name, pw, e_mail, phoneNum));
                    setResult(Activity.RESULT_OK, result);
                    finish();
                }
                else
                {
                    if (nameFlag == 0)
                    {
                        Toast.makeText(getApplicationContext(), "Enter a user name", Toast.LENGTH_LONG).show();
                    }
                    if (pwFlag == 0)
                    {
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
                    }
                    if (emailFlag == 0)
                    {
                        Toast.makeText(getApplicationContext(), "Enter a valid email address", Toast.LENGTH_LONG).show();
                    }
                    if (phoneNumFlag == 0)
                    {
                        Toast.makeText(getApplicationContext(), "Invalid phone number", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    boolean emailFormat(CharSequence email)
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}


