package com.company.services;

import com.company.domain.MyCustomer;
import com.company.mappers.CustomerMapper;
import com.company.repositories.CustomerRepository;
import net.kriter.rcsdk.model.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RepCamp on 14/01/15.
 */
public class CustomerService {

    //Retrieve your customers from whatever source you like (Data Base, file, WebService, etc.) do some logic, map them to RepCamp's customer type and you are good to go!

    public List<Customer> findAll(int skip, int take) throws Exception
    {
        CustomerRepository customerRepository = new CustomerRepository();

        //Retrieve your database customers
        List<MyCustomer> mycustomers = customerRepository.findAll(skip, take);

        return mapAndTreatMyCustomers(mycustomers);
    }

    public List<Customer> findAll(Date date, int skip, int take) throws Exception
    {
        CustomerRepository customerRepository = new CustomerRepository();

        //Retrieve your database customers from a given date (just modified customers)
        List<MyCustomer> mycustomers = customerRepository.findAll(date, skip, take);

        return mapAndTreatMyCustomers(mycustomers);
    }

    public List<String> removedItems(Date date) throws Exception
    {
        CustomerRepository customerRepository = new CustomerRepository();
        return customerRepository.removedItems(date);
    }

    private List<Customer> mapAndTreatMyCustomers(List<MyCustomer> mycustomers) throws Exception
    {
        //New list of "RepCamp type" customers
        List<Customer> customers = new ArrayList<Customer>();

        //Instantiate the mapper
        CustomerMapper customerMapper = new CustomerMapper();

        for(MyCustomer mycustomer : mycustomers)
        {
            //Treat them
            customers.add(customerMapper.map(mycustomer));
        }

        return customers;
    }
}
