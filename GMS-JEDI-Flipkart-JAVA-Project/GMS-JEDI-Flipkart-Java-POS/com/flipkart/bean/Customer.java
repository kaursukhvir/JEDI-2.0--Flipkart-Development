package com.flipkart.bean;

public class Customer extends User{

    private String customerPhone;
    private String customerEmail;

    public Customer(String userName,String customerPhone, String customerEmail) {
        super(userName);
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }



}
