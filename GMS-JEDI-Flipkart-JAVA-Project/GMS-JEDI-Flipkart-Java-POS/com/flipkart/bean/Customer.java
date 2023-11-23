package com.flipkart.bean;

public class Customer extends User{

    private String customerPhone;
    private String cardDetails;

    public Customer(String userName, String email, String password, Role role, String customerPhone, String cardDetails) {
        super(userName, email, password, role);
        this.customerPhone = customerPhone;
        this.cardDetails = cardDetails;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCardDetails() { return cardDetails; }

    public void setCardDetails(String cardDetails) { this.cardDetails = cardDetails; }
}
