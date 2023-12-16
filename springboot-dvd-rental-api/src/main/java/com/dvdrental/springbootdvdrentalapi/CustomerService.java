package com.dvdrental.springbootdvdrentalapi;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
//    public void mpilo() {
//        System.out.println("wwhjklrergdsfg");
//    }
//
//    public List<Customer> findAllCustomers() {
//        return customerRepository.findAll();
//    }
//
//    public Optional<Customer> findCustomerById(Integer id) {
//        return customerRepository.findById(id);
//    }
//
//    public Customer saveCustomer(Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    public void deleteCustomer(Integer id) {
//        customerRepository.deleteById(id);
//    }

        public List<Customer> findAllCustomers() {
        return (List<Customer>) customerRepository.findByEmailAddress("mary.smith@sakilacustomer.org");
    }
}
