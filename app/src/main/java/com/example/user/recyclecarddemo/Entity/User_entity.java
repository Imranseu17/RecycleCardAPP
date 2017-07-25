package com.example.user.recyclecarddemo.Entity;

import java.io.Serializable;

/**
 * Created by User on 7/18/2017.
 */

public class User_entity implements Serializable  {
    private String personName;


    public User_entity(String cse) {
        this.personName = cse;

    }

    public String getPersonName() {
        return personName;
    }


    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
