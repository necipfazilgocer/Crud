package com.nfg.crud.service;

import com.nfg.crud.entity.Customer;
import com.nfg.crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);

    }

    public List<Customer> findAllCustomer(){

        return  customerRepository.findAll();

    }


    public Customer getCustomerById(Long customerID){
        return  customerRepository.findById(customerID).get();
    }

    public void deleteCustomerByID(Long customerId){
        customerRepository.deleteById(customerId);
    }
}
