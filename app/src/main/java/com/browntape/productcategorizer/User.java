package com.browntape.productcategorizer;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Srini on 11/5/16.
 */

@IgnoreExtraProperties
public class User {

    public String userid;
    public String username;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String userid, String username, String email) {
        this.userid = userid;
        this.username = username;
        this.email = email;
    }

}