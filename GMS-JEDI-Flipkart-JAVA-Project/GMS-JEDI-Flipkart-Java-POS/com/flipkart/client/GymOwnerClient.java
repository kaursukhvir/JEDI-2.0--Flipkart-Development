package com.flipkart.client;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.business.GymCentreService;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.SlotService;

import java.time.LocalTime;

import static com.flipkart.client.MainApplicationClient.scanner;
import static com.flipkart.constant.Constants.*;

public class GymOwnerClient {

    private GymOwnerService gymOwnerService = new GymOwnerService();
    private SlotService slotService = new SlotService();
    private GymCentreService gymCentreService = new GymCentreService();


    public void gymOwnerMainPage(String gymOwnerId) {



        while(true){
            System.out.println("1. Sending Gym Owner Approval Request\n2. Add a new Gym Center\n3. Send a Gym Centre Approval Request to Admin\n4. Add Slots to a Gym Centre\n5. Go Back to Previous Menu");
            int choice = scanner.nextInt();
            switch (choice){
                /* Take input from user for all service parameters ( Make the menu ) */

                case 1:
                    gymOwnerService.requestGymOwnerApproval(gymOwnerId);
                    break;

                case 2:
                    System.out.println("Enter Gym Centre name: ");
                    String gymCentreName = scanner.next();

                    System.out.println("Enter Gym Centre city: ");
                    String city = scanner.nextLine();

                    System.out.println("Enter Gym Centre capacity: ");
                    int capacity = scanner.nextInt();

                    gymCentreService.addCenter(new GymCentre(gymCentreName, gymOwnerId, city, capacity));
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

                    slotService.addSlot(new Slot(centreId, LocalTime.parse(time)));
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

    public void register() {

    }
}
