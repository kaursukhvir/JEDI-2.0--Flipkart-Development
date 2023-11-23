package com.flipkart.client;
import java.time.LocalTime;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slots;
import com.flipkart.business.GymCentreService;
import com.flipkart.business.GymOwnerService;

public class GymOwnerClient {

    public static void main(String[] args) {

        GymOwnerService gymOwnerService = new GymOwnerService();
        GymCentreService gymCentre = new GymCentreService();

        System.out.println("Registering Gym Owner -------");
        gymOwnerService.register();

        System.out.println("Logging in the Gym Owner -------");
        gymOwnerService.login();

        System.out.println("Sending Gym Owner Approval Request -------");
        gymOwnerService.requestGymOwnerApproval();

        System.out.println("Adding a new Gym Center");
        gymOwnerService.addCenter();

        System.out.println("Sending a Gym Centre Approval Request to Admin ------");
        gymCentre.requestCentreApproval();

        System.out.println("Adding a Slot to a Gym Centre ------");
        Slots slots = new Slots("1", LocalTime.parse("03:18:23"));

    }

}
