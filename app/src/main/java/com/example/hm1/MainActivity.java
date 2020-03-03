package com.example.hm1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    private Button signUpButton = null;
    private Button loginButton = null;
    private EditText userNameText = null;
    private EditText passwordText = null;
    private HashMap<String, User> users = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a new user
        addUser(new User("Admin", "password", "admin@gmail.com", "1234567890"));

        signUpButton = (Button) findViewById(R.id.signUPButton);
        loginButton = (Button) findViewById(R.id.loginInButton);
        userNameText = (EditText) findViewById(R.id.user_name);
        passwordText = (EditText) findViewById(R.id.Password);

        //check to make sure that user name is not the same

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                // checks login credentials
                String password = passwordText.getText().toString();
                String userName = userNameText.getText().toString();

                if (users.containsKey(userName))
                {
                    User u = users.get(userName);
                    String inputPW = u.getPassword();

                    if (!inputPW.equals(password))
                    {
                        Toast message = Toast.makeText(getApplicationContext(), "Incorrect Password", Toast.LENGTH_LONG);
                        message.show();
                    }
                    else
                    {
                        Intent i = new Intent(getApplicationContext(), Profile.class);
                        i.putExtra("user name", userName);
                        startActivity(i);
                    }
                }

                else
                {
                    Toast message = Toast.makeText(getApplicationContext(), "Username does not exist", Toast.LENGTH_LONG);
                    message.show();
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivityForResult(i, 2);
            }
        });
    }

    protected void onActivityResult(int reqCode, int resultCode, Intent i)
    {
        // Check which request we're responding to
        if (reqCode == 2)
        {
            // Make sure the request was successful
            if (resultCode == RESULT_OK)
            {
                addUser((User)i.getSerializableExtra("userObject"));
            }
        }
    }

    public void addUser(User u)
    {
        users.put(u.getUserName(), u);
    }
}