package com.company.repositories;

import com.company.domain.MyCustomer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RepCamp on 14/01/15.
 */
public class CustomerRepository {

    //HERE IS WHERE YOU SHOULD CONNECT TO THE DATABASE AND RETRIEVE ALL YOUR DATA

    public List<MyCustomer> findAll(int skip, int take) throws Exception
    {
        //Retrieve all Customers
        List<MyCustomer> customers = new ArrayList<MyCustomer>();

        //For the example to work
        if(skip < 2)
        {
            customers.add(dataBaseCustomer1());
            customers.add(dataBaseCustomer2());
        }

        return customers;
    }

    public List<MyCustomer> findAll(Date date, int skip, int take) throws Exception
    {
        //Retrieve all Customers from a given date... so you make the synchronization lighter only uploading changes
        List<MyCustomer> modifiedCustomers = new ArrayList<MyCustomer>();

        //For the example to work
        if(skip < 2) {
            //Just a fake modification
            MyCustomer modifiedCustomer = dataBaseCustomer1();
            modifiedCustomer.setComercial_name("RepCamp");
            modifiedCustomers.add(modifiedCustomer);
        }

        return modifiedCustomers;
    }
    
    public List<String> removedItems(Date date) throws Exception
    {
        //Retrieve all Customer codes from a given date... so you make the synchronization smart ;)
        List<String> removedCustomerCodes = new ArrayList<String>();

        //Just fake a customer removal
        removedCustomerCodes.add("CT0002");

        return removedCustomerCodes;
    }
    
    private MyCustomer dataBaseCustomer1()
    {
        MyCustomer mycustomer = new MyCustomer();

        mycustomer.setCode("CT0001");
        mycustomer.setFiscal_name("Kriter Software, S.L.");
        mycustomer.setComercial_name("Kriter Software");
        mycustomer.setVat_number("D58709832");
        mycustomer.setTelephone("+34 937575997");
        mycustomer.setTelephone_2("");
        mycustomer.setEmail("support@repcamp.com");
        mycustomer.setAddress("Pablo Iglesias 63");
        mycustomer.setAddress_2("PB L1");
        mycustomer.setCity("Mataró");
        mycustomer.setZip("08302");
        mycustomer.setState("Barcelona (BCN)");
        mycustomer.setCountry("SPAIN");
        mycustomer.setLatitude(new BigDecimal("41.531395"));
        mycustomer.setLongitude(new BigDecimal("2.43232"));
        mycustomer.setPayment_method("Bank Transfer 30 days");
        mycustomer.setDiscount(new BigDecimal("10"));
        mycustomer.setDescription("Kriter Software is a Business Management Information Systems developer. We work on masking technologies to give easy, simple, affordable, reliable and profitable solutions to our customers for the efficient management of their businesses");
        mycustomer.setStatus((short) 1);
        mycustomer.setPricelist("01");
        mycustomer.setLanguage("en");

        //NOTE:  To match the existing Rep from your ERP and the one at RepCamp.com, you'll have to specified a code at reps management page.

//        List<String> repcodes = new ArrayList<String>();
//        repcodes.add("ERP_ID");
//        repcodes.add("ERP_ID");
//        repcodes.add("ERP_ID");
//
//        mycustomer.setReps(repcodes);

        return mycustomer;
    }

    private MyCustomer dataBaseCustomer2()
    {
        MyCustomer mycustomer = new MyCustomer();

        mycustomer.setCode("CT0002");
        mycustomer.setFiscal_name("Maname Camp, LTD");
        mycustomer.setComercial_name("Man & Surf");
        mycustomer.setVat_number("D58709832");
        mycustomer.setTelephone("(831) 758-7214");
        mycustomer.setTelephone_2("");
        mycustomer.setEmail("comercial@maname.com");
        mycustomer.setAddress("15 Pujol St");
        mycustomer.setAddress_2("");
        mycustomer.setCity("Temecula");
        mycustomer.setZip("92589");
        mycustomer.setState("California (CA)");
        mycustomer.setCountry("ESTADOS UNIDOS DE AMERICA");
        mycustomer.setLatitude(new BigDecimal("-117.1500000"));
        mycustomer.setLongitude(new BigDecimal("33.4900000"));
        mycustomer.setPayment_method("Bank Transfer 30 days");
        mycustomer.setDiscount(new BigDecimal("0"));
        mycustomer.setDescription("Some Comments");
        mycustomer.setStatus((short) 1);
        mycustomer.setPricelist("02");
        mycustomer.setLanguage("en");

        //NOTE:  To match the existing Rep from your ERP and the one at RepCamp.com, you'll have to specified a code at reps management page.

//        List<String> repcodes = new ArrayList<String>();
//        repcodes.add("ERP_ID");
//        repcodes.add("ERP_ID");
//        repcodes.add("ERP_ID");
//
//        mycustomer.setReps(repcodes);

        return mycustomer;
    }
}
