package com.flipkart.client;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.business.CustomerService;
import com.flipkart.utils.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.flipkart.client.MainApplicationClient.scanner;
import static com.flipkart.constant.Constants.INVALID_CHOICE_ERROR;
import static com.flipkart.constant.Constants.PREVIOUS_MENU_MESSAGE;

public class CustomerClient {
    private CustomerService customerService  =  new CustomerService();


    public boolean customerLogin(String userName, String password) {
//        System.out.println("HELLO in customer"); -- BAD
        if (customerService.isUserValid(userName, password)) {
            System.out.println("Successfully logged in");
            customerClientMainPage(userName);
        } else {
            System.out.println("UserName or password doesn't match");
            return false;
        }
        return true;
    }

    public void register(String userId){
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your Phone Number");
        String phoneNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        customerService.registerCustomer(userName,password,email,phoneNumber,cardNumber);
        customerClientMainPage(userName);
    }

    private void viewMyProfile(String userName){
        customerService.viewMyProfile(userName);
    }

    private void bookSlotSubMenu(String userName){
//        Get Location for filter
        System.out.println("Provide Location to search :");
        String location = scanner.next();
        List<GymCentre> centreListByLocation = customerService.getAllGymCenterDetailsByCity(location);
        util.printList(centreListByLocation); // Print All Centres
//        Select Gym Centre
        System.out.print("Choose a gymCentre ID to proceed:");
        String chosenGym = scanner.next();
//        Select Date
        System.out.print("Enter Date (dd/MM/yyyy): ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(scanner.next());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
//        Choose Slot
        System.out.println("Choose from the Below Slots");
        List<Slot> availableSlots = customerService.getAvailableSlots(chosenGym,date);
        util.printList(availableSlots);
        System.out.println("Enter SlotID");
        String slotID = scanner.next();
//      Select Slot to book
        customerService.bookSlot(userName,date,slotID);

    }

    private void getbookingsSubMenu(String userName){
        System.out.println("Bookings : ");
        customerService.getCustomerBookings(userName);

    }

    private void cancelBookingSubMenu(String userName){
        System.out.println("Select the Booking you want to cancel: ");
        customerService.getCustomerBookings(userName);
        String bookingId = scanner.next();
        customerService.cancelBookingbyID(bookingId);

    }

    public void customerClientMainPage(String userName) {
        System.out.println("WELCOME "+userName+" !!\n What you what to do");
        while(true){
            System.out.println("1. View My Profile \n2. Book a slot in a Gym \n3. View Bookings\n4. Cancel Bookings\n5. Go Back to previous menu");
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    customerService.viewMyProfile(userName);
                    break;
                case 2:
                    bookSlotSubMenu(userName);
                    break;
                case 3:
                    getbookingsSubMenu(userName);
                    break;
                case 4:
                    cancelBookingSubMenu(userName);
                    break;
                case 5:
                    System.out.println(PREVIOUS_MENU_MESSAGE);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }
    }

}
