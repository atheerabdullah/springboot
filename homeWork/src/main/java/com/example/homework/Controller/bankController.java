package com.example.homework.Controller;

import com.example.homework.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v2/bank")
public class bankController {

    public ArrayList<Customer> customers = new ArrayList<>();


    @GetMapping("/get-all-customers")
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    @PostMapping("/add-customers")
    public ArrayList<Customer> creatCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customers;
    }

    @PutMapping("/update- customer/{index}")
    public ArrayList<Customer> updateCustomer(@PathVariable int index, @RequestBody Customer customer) {
        customers.set(index, customer);
        return customers;
    }

    @DeleteMapping("/delete- customer/{index}")
    public ArrayList<Customer> deleteCustomers(@PathVariable int index) {
        customers.remove(index);
        return customers;
    }

    //Deposit money to customer
    @PostMapping("/{id}/{balance}")
    public Customer depositMoney(@PathVariable Long id, @PathVariable int balance) {
        Customer customerToUpdate = null;

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customerToUpdate = customer;
                continue;
            }

            int currentBalance = customerToUpdate.getBalance();
            int newBalance = currentBalance + balance;
            customerToUpdate.setBalance(newBalance);
            return customerToUpdate;
        }
        return customerToUpdate;
    }


    ///Withdraw money from customers


}
