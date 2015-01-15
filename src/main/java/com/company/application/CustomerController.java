package com.company.application;

import com.company.services.CustomerService;
import net.kriter.rcsdk.model.Customer;
import net.kriter.rcsdk.model.GenericResponse;
import net.kriter.rcsdk.rest.RepCampAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RepCamp on 14/01/15.
 */
public class CustomerController {

    RepCampAPI repcampAPI = null;
    CustomerService customerService = null;

    public CustomerController() throws Exception
    {
        this.repcampAPI = new RepCampAPI();
        this.customerService = new CustomerService();
    }

    public boolean addCustomer(String code)
    {
        try
        {
            Customer customer = this.customerService.findByCode(code);

            GenericResponse resp =  repcampAPI.addCustomer(customer);

            if(resp.getSingleResponse() != null)
            {
                if(resp.getSingleResponse().getError() != null)
                {
                    System.out.println("Failed to upload customer: (CODE) " + customer.getCode() + " Error: " + resp.getSingleResponse().getError());
                }
            }

            System.out.println(resp.toString());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return true;
    }

    public boolean removeCustomers(Date date)
    {
        try
        {
            List<String> customerCodes = customerService.removedItems(date);

            List<String> errors = new ArrayList<String>();


            for(String code : customerCodes)
            {
                GenericResponse resp =  repcampAPI.removeCustomer(code);

                if(resp.getSingleResponse() != null)
                {
                    if(resp.getSingleResponse().getError() != null)
                    {
                        errors.add(code);
                        System.out.println("Failed to delete customer: (CODE) " + code + " Error: " + resp.getSingleResponse().getError());
                    }
                }
            }

            if(errors.size() == 0)
            {
                if(customerCodes.size() == 0) System.out.println("Customers to Delete: None");
                else System.out.println("Customers Deleted: " + customerCodes.size());
                return true;
            }
            else
            {
                System.out.println("Customers Deleted: ERROR, Check the error log for details");

                String msg = "";
                for(String err : errors)
                {
                    msg += err + "\n";
                }

                System.out.println("Failed to delete this customers: " + msg);

                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to delete customers");
            e.printStackTrace();
            return false;
        }
    }

    public boolean uploadCustomers(Date date)
    {
        try
        {
            GenericResponse resp = null;
            int skip = 0, take = 100;
            boolean finish = false;

            int totals = 0;
            int errorsnum = 0;
            int updates = 0;
            int inserts = 0;

            List<String> errors = new ArrayList<String>();

            while(!finish)
            {
                List<Customer> customers = null;

                if(date == null) { customers = customerService.findAll(skip,take); }
                else { customers = customerService.findAll(date, skip,take); }

                if(customers.size() > 0)
                {
                    resp = repcampAPI.uploadCustomers(customers);

                    if(resp.getBulkResponse() != null)
                    {
                        totals += resp.getBulkResponse().getTotal();
                        inserts += resp.getBulkResponse().getInserts();
                        updates += resp.getBulkResponse().getUpdates();
                        errorsnum += resp.getBulkResponse().getErrors();

                        if(resp.getBulkResponse().getErrors() > 0)
                        {
                            for(String code : resp.getBulkResponse().getItems_error()) { errors.add(code); }
                        }
                    }
                    else
                    {
                        System.out.println("Customers Upload: ERROR, Check the error log for details");
                        System.out.println("URL: " + resp.getUrl());
                        System.out.println("STATUS: " + resp.getStatus());
                        System.out.println("MESSAGE: " + resp.getMessage());
                    }

                    skip += take;
                }
                else
                {
                    finish = true;
                }
            }



            if(errorsnum == 0)
            {
                if(totals == 0) System.out.println("Customers to Upload: None");
                else
                {
                    System.out.println("Customers Uploaded: " + totals);
                    System.out.println("Customers Added: " + inserts);
                    System.out.println("Customers Updates: " + updates);
                    System.out.println("Customers Errors: " + errorsnum);
                }

                return true;
            }
            else
            {
                System.out.println("Customers Upload: ERROR, Check the error log for details");

                String msg = "";
                for(String err : errors)
                {
                    msg += err + "\n";
                }

                System.out.println("Failed to upload this customers: " + msg);

                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println("Customers Upload: ERROR, Check the error log for details");
            System.out.println("Failed to upload customers");
            e.printStackTrace();
            return false;
        }
    }
}
