package com.example.hm1;

import java.io.Serializable;
public class User implements Serializable
{
    String userName, password, email, phoneNum;

    User(String userName, String password, String email, String phoneNum)
    {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public String getPassword()
    {
        return this.password;
    }

}
