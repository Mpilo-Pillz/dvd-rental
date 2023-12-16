package com.dvdrental.springbootdvdrentalapi;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.dvdrental.springbootdvdrentalapi.CustomerService;
@RestController
@RequestMapping("/customers")
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//        @GetMapping
//    public void mpilo() {
//        customerService.mpilo();
//    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
//        return customerService.findCustomerById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Customer createCustomer(@RequestBody Customer customer) {
//        return customerService.saveCustomer(customer);
//    }
//
//    @PutMapping("/{id}")
//    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
//        return customerService.saveCustomer(customer);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCustomer(@PathVariable Integer id) {
//        customerService.deleteCustomer(id);
//    }

}
