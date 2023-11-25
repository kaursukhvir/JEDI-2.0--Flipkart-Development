package com.flipkart.bean;

public class Admin extends User {

    public Admin() {
        super("0","flipfitAdmin", "admin@flipfit.com", "ff.admin", Role.ADMIN);
    }
}
