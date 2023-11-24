package com.flipkart.bean;

public class Admin extends User {

    public Admin() {
        super("flipfitAdmin", "admin@flipfit.com", "ff.admin", Role.ADMIN);
    }
}
