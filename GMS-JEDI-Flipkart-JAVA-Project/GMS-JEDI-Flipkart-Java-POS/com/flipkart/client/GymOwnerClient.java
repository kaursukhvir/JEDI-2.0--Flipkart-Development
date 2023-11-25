package com.flipkart.client;

import com.flipkart.bean.Slot;
import com.flipkart.DAO.GymOwnerDAO;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymCentreService;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.SlotService;

import java.time.LocalTime;

import java.util.List;

import static com.flipkart.client.MainApplicationClient.scanner;
import static com.flipkart.constant.Constants.*;

public class GymOwnerClient {


    private GymOwnerService gymOwnerService = new GymOwnerService();
    private SlotService slotService = new SlotService();
    private GymCentreService gymCentreService = new GymCentreService();


//    public boolean isUserValid(String userName, String password, List<GymOwner> gymOwnerList) {
//        for(GymOwner c:gymOwnerList) {
//            if (userName.equals(c.getUserName()) && password.equals(c.getPassword())) {
//                gymOwnerId = c.getUserID();
//                return true;
//            }
//        }
//        return false;
//    }

//    public void gymOwnerLogin(String userName, String password) {
//        System.out.println("in owner");
//        if(gymOwnerService.loginGymOwner(userName,password))
//            gymOwnerClientMainPage();
//    public boolean gymOwnerLogin(String userName, String password) {
////        System.out.println("in owner"); -- BAD
//        if (isUserValid(userName, password,gymOwnerList)) {
//
//            System.out.println("Successfully logged in");
//            gymOwnerClientMainPage(userName);
//        }
//        else{
//            System.out.println("UserName or password doesn't match");
//            return false;
//        }
//        return true;
//    }



    public void gymOwnerClientMainPage(String userName) {
        System.out.println("WELCOME "+userName+" !!! \nWhat you want to do?");
        while(true){
            System.out.println("1. Sending Gym Owner Approval Request\n2. Add a new Gym Center\n3. Send a Gym Centre Approval Request to Admin\n4. Add Slots to a Gym Centre\n5. Go Back to Previous Menu");
            int choice = scanner.nextInt();
            switch (choice){
                /* Take input from user for all service parameters ( Make the menu ) */

                case 1:
                    gymOwnerService.requestGymOwnerApproval(userName);
                    break;

                case 2:
                    System.out.println("Enter Gym Centre name: ");
                    String gymCentreName = scanner.next();

                    System.out.println("Enter Gym Centre city: ");
                    String city = scanner.nextLine();

                    System.out.println("Enter Gym Centre capacity: ");
                    int capacity = scanner.nextInt();

//                    gymCentreService.addCenter(new GymCentre(gymCentreName, gymOwnerId, city, capacity));
                    break;

                case 3:

                    System.out.println("Enter Gym Centre Id: ");
                    String gymCentreId = scanner.next();

                    gymCentreService.requestGymCentreApproval(gymCentreId);
                    break;

                case 4:
                    System.out.println("Enter Gym Centre Id: ");
                    String centreId = scanner.next();

                    System.out.println("Enter time in 24h format (hh:mm:ss) : ");
                    String time = scanner.next();

                    slotService.addSlot(new Slot("slot8", centreId, LocalTime.parse(time)));
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

    public void register(String userId) {
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your PAN Number");
        String panNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        gymOwnerService.registerGymOwner(userId,userName,password,email,panNumber,cardNumber);
        gymOwnerClientMainPage(userName);
    }

}
