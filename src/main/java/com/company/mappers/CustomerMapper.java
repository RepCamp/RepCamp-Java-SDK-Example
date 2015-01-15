package com.company.mappers;

import com.company.domain.MyCustomer;
import net.kriter.rcsdk.model.Customer;
import net.kriter.rcsdk.model.CustomerLanguageType;

/**
 * Created by RepCamp on 14/01/15.
 */
public class CustomerMapper {

    //Map your customer model with the RepCamp Customer so it can be pushed!

    public Customer map (MyCustomer mycustomer) throws Exception
    {
        Customer customer = new Customer();


        //NOTE: If RepCamp's customer model has more attributes than yours just forget them. No blank mapping needed.
        //      If Your customer has more attributes that you would like RepCamp to have just wait a bit... or send an email to support@repcamp.com. We are working hard to satisfy your needs.

        customer.setCode(mycustomer.getCode());
        customer.setVat_number(mycustomer.getVat_number());
        customer.setFiscal_name(mycustomer.getFiscal_name());
        customer.setComercial_name(mycustomer.getComercial_name());
        customer.setTelephone(mycustomer.getTelephone());
        customer.setTelephone_2(mycustomer.getTelephone_2());
        customer.setEmail(mycustomer.getEmail());
        customer.setAddress(mycustomer.getAddress());
        customer.setAddress_2(mycustomer.getAddress_2());
        customer.setCity(mycustomer.getCity());
        customer.setZip(mycustomer.getZip());
        customer.setState(mycustomer.getState());
        customer.setCountry(mycustomer.getCountry());
        customer.setLatitude(mycustomer.getLatitude());
        customer.setLongitude(mycustomer.getLongitude());
        customer.setDescription(mycustomer.getDescription());
        customer.setDiscount(mycustomer.getDiscount());
        customer.setPayment_method(mycustomer.getPayment_method());
        customer.setStatus(mycustomer.getStatus());

        if(mycustomer.getPricelist() != null) customer.setPricelist(mycustomer.getPricelist());

        //if(mycustomer.getReps().size() > 0) customer.setReps(mycustomer.getReps());

        if(mycustomer.getLanguage().equalsIgnoreCase("ca")) customer.setLanguage(CustomerLanguageType.CATALAN);
        else if(mycustomer.getLanguage().equalsIgnoreCase("es")) customer.setLanguage(CustomerLanguageType.SPANISH);
        else customer.setLanguage(CustomerLanguageType.ENGLISH);

        return customer;
    }

}
