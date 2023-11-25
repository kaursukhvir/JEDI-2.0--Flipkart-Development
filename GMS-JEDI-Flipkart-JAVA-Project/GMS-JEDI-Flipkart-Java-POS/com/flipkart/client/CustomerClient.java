package com.flipkart.client;

import com.flipkart.DAO.CustomerDAO;
import com.flipkart.bean.Customer;
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
    private List<Customer> customerList = new CustomerDAO().getCustomerList();

    public boolean isUserValid(String userName, String password, List<Customer> customerList) {
        for(Customer c:customerList) {
            if (userName.equals(c.getUserName()) && password.equals(c.getPassword())) return true;
        }
        return false;
    }

    public boolean customerLogin(String userName, String password) {
        System.out.println("HELLO in customer");
        if (isUserValid(userName, password, customerList)) {
            System.out.println("Successfully logged in");
            customerClientMainPage();
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

        customerService.registerCustomer(userId, userName,password,email,phoneNumber,cardNumber);
        customerClientMainPage();
    }

    private void bookSlotSubMenu(){
        System.out.println("Provide Location to search :");
        String location = scanner.next();
        List<GymCentre> centreListByLocation = customerService.getAllGymCenterDetailsByLocation(location);

        util.printList(centreListByLocation);
        System.out.print("Choose a gymCentre ID to proceed:");
        String chosenGym = scanner.next();

        System.out.print("Enter Date (dd/MM/yyyy): ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(scanner.next());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Choose from the Below Slots");
        List<Slot> availableSlots = customerService.getAvailableSlots(chosenGym,date);
        util.printList(availableSlots);
        System.out.println("Enter SlotID");
        String slotID = scanner.next();

        customerService.bookSlot(slotID);

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
                    System.out.println(PREVIOUS_MENU_MESSAGE);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }
    }

}
