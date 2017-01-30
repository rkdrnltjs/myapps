package com.example.kks.realm;

import io.realm.RealmObject;

/**
 * Created by KKS on 2017-01-20.
 */

public class Boostcamp extends RealmObject {


    private String name;
    private String city;
    private int contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}
