package com.example.arpit.sos;

/**
 * Created by arpit on 19/4/18.
 */

public class UserInformation {
    public String name,surname,knows_cpr;
    public int age;
    public float phone;

    public UserInformation(String name, String surname, String knows_cpr, int age, float phone) {
        this.name = name;
        this.surname = surname;
        this.knows_cpr = knows_cpr;
        this.age = age;
        this.phone = phone;
    }
}
