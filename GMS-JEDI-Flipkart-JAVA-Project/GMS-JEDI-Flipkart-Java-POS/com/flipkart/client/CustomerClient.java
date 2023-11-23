package com.flipkart.client;

import com.flipkart.business.CustomerService;

import static com.flipkart.client.MainApplicationClient.scanner;
import static com.flipkart.constant.Constants.INVALID_CHOICE_ERROR;
import static com.flipkart.constant.Constants.PREVIOUS_MENU;

public class CustomerClient {
    private CustomerService customerService  =  new CustomerService();

    private void bookSlotSubMenu(){
        System.out.println("Provide Location to search :");
        String location = scanner.next();
        customerService.getAllGymCenterDetailsByLocation(location);
//        User Screen will have all the centres listed
    }

    private void bookingsSubMenu(){
        System.out.println("Bookings : ");
        customerService.getCustomerBookings();

    }

    private void cancelBookingSubMenu(){
        System.out.println("Select the Booking you want to cancel: ");
        customerService.getCustomerBookings();
        int indexOfBookingToRemove = scanner.nextInt();
        customerService.cancelBookingbyID();

    }

    public void customerClientMainPage() {

        while(true){
            System.out.println("1. Book a slot in a Gym \n2. View Bookings\n3. Cancel Bookings\n4. Go Back to previous menu");
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    bookSlotSubMenu();
                    break;
                case 2:
                    bookingsSubMenu();
                    break;
                case 3:
                    cancelBookingSubMenu();
                    break;
                case 4:
                    System.out.println(PREVIOUS_MENU);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }
    }

}
