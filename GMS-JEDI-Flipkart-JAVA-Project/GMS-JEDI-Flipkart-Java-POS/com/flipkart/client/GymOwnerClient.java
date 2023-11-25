package com.flipkart.client;

import com.flipkart.bean.GymCentre;
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

    GymOwnerDAO gymOwnerDAO = new GymOwnerDAO();
    private List<GymOwner> gymOwnerList = gymOwnerDAO.getGymOwnerList();

    private GymOwnerService gymOwnerService = new GymOwnerService();
    private SlotService slotService = new SlotService();
    private GymCentreService gymCentreService = new GymCentreService();
    private String gymOwnerId;

    private static int newGymCentreId = 10;

    public boolean isUserValid(String userName, String password, List<GymOwner> gymOwnerList) {
        for(GymOwner c:gymOwnerList) {
            if (userName.equals(c.getUserName()) && password.equals(c.getPassword())) {
                gymOwnerId = c.getUserID();
                return true;
            }
        }
        return false;
    }

    public boolean gymOwnerLogin(String userName, String password) {
        System.out.println("in owner");
        if (isUserValid(userName, password,gymOwnerList)) {

            System.out.println("Successfully logged in");
            gymOwnerClientMainPage();
        }
        else{
            System.out.println("UserName or password doesn't match");
            return false;
        }
        return true;
    }



    public void gymOwnerClientMainPage() {

        while(true){
            System.out.println("" +
                    "0. View all my Gym Centres\n" +
                    "1. Sending Gym Owner Approval Request\n" +
                    "2. Add a new Gym Center\n" +
                    "3. Send a Gym Centre Approval Request to Admin\n" +
                    "4. Add Slots to a Gym Centre\n" +
                    "5. Go Back to Previous Menu"
            );
            int choice = scanner.nextInt();
            switch (choice){
                /* Take input from user for all service parameters ( Make the menu ) */

                case 0:
                    List<GymCentre> allGymCentres = gymCentreService.getAllCentres(gymOwnerId);


                    System.out.println("---------------------------------------------------------");
                    for(GymCentre gymCentre: allGymCentres) {
                        System.out.printf("%-8s\t", gymCentre.getOwnerID());
                        System.out.printf("%-8s\t", gymCentre.getGymCentreID());
                        System.out.printf("%-8s\t", gymCentre.getGymCenterName());
                        System.out.printf("%-8s\t", gymCentre.getCity());
                        System.out.printf("%-8s\t", gymCentre.getPrice());

                        if(gymCentre.isApproved() == 1) System.out.println("Yes\n");
                        else if(gymCentre.isApproved() == 0) System.out.println("No\n");
                        else System.out.println("Pending\n");
                        System.out.println("");
                    }
                    System.out.println("---------------------------------------------------------");



                    break;

                case 1:
                    gymOwnerService.requestGymOwnerApproval(gymOwnerId);
                    break;

                case 2:

                    System.out.println("Enter gym centre id: ");
                    String gymId = scanner.next();

                    System.out.println("Enter Gym Centre name: ");
                    String gymCentreName = scanner.next();

                    System.out.println("Enter Gym Centre GSTIN: ");
                    String gstin = scanner.next();

                    System.out.println("Enter Gym Centre city: ");
                    String city = scanner.next();

                    System.out.println("Enter Gym Centre capacity: ");
                    int capacity = scanner.nextInt();

                    System.out.println("Enter price: : ");
                    int price = scanner.nextInt();

                    newGymCentreId++;
                    gymCentreService.addCenter(
                            new GymCentre(
                                    gymId,
                                    gymOwnerId,
                                    gymCentreName,
                                    gstin,
                                    city,
                                    capacity,
                                    price
                            )
                    );
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
        gymOwnerClientMainPage();
    }

}
