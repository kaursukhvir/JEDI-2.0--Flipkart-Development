package com.flipkart.client;

import com.flipkart.business.GymCentreService;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.SlotService;

import static com.flipkart.client.MainApplicationClient.scanner;
import static com.flipkart.constant.Constants.*;

public class GymOwnerClient {

    private GymOwnerService gymOwnerService = new GymOwnerService();
    private SlotService slotService = new SlotService();
    private GymCentreService gymCentre = new GymCentreService();



    public void gymOwnerMainPage() {

        while(true){
            System.out.println("1. Sending Gym Owner Approval Request\n2. Add a new Gym Center\n3. Send a Gym Centre Approval Request to Admin\n4. Add Slots to a Gym Centre\n5. Go Back to Previous Menu");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    gymOwnerService.requestGymOwnerApproval();
                    break;
                case 2:
                    gymOwnerService.addCenter();
                    break;
                case 3:
                    gymCentre.requestCentreApproval();
                    break;
                case 4:
                    slotService.addSlot();
                    break;
                case 5:
                    System.out.println(PREVIOUS_MENU);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }
    }

}
