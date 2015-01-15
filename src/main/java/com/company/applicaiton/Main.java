package com.company.applicaiton;

import net.kriter.rcsdk.model.APIData;
import net.kriter.rcsdk.rest.RepCampAPI;

import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args)
    {
        try
        {
            //Instantiate the main RepCamp SDK controller
            RepCampAPI repcampAPI = new RepCampAPI();

            //Specify API data to start up
            APIData apidata = ApiDataMaker.getAPIData();

            //Set API data to the SDK
            repcampAPI.setAPIData(apidata);

            System.out.println("**********************************   INIT   **********************************");

            //Authenticate your self, just to test your API key out.
            if(repcampAPI.authenticateMe()) System.out.println("Authentication ----------- OK");
            else System.out.println("Authentication ----------- FAILED");

            //Instantiate the controllers
            CustomerController customerController = new CustomerController();

            //Uncomment to delete customers
//            GregorianCalendar calEnd = new GregorianCalendar(); //Date for a partial synchronization
//            calEnd.setTime(new Date());
//            calEnd.add(GregorianCalendar.MINUTE, -10); //Changes from 10 Minutes ago
//            Date date = calEnd.getTime();
//
//            if(customerController.removeCustomers(date)) System.out.println("Delete Customers - OK");
//            else System.out.println("Delete Customers - FAILED");

            //Uncomment for customers upload
            //Set date instead of null for a partial synchronization. If null, all customers will be uploaded
            if(customerController.uploadCustomers(null)) System.out.println("Upload Customers - OK");
            else System.out.println("Upload Customers - FAILED");


            System.out.println("********************************** FINISHED **********************************");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
