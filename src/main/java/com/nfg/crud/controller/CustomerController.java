package com.nfg.crud.controller;

import com.nfg.crud.entity.Customer;
import com.nfg.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping("/save")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer addCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<Customer>(addCustomer, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustemer(){
        List<Customer> allCustomer = customerService.findAllCustomer();
        return new ResponseEntity<List<Customer>>(allCustomer,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustemerID(@PathVariable("id") Long id){
        Customer customerById = customerService.getCustomerById(id);
        return new ResponseEntity<Customer>(customerById,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomerByID(@PathVariable Long id){
        customerService.deleteCustomerByID(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

    }


}
