package com.flipkart.bean;

public class Customer extends User{

    private String customerPhone;
    private String cardDetails;

    public Customer(String userName,String customerPhone, String cardDetails) {
        super(userName);
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
