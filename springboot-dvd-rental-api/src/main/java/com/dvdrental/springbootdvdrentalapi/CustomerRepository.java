package com.dvdrental.springbootdvdrentalapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Find customers by last name
    List<Customer> findByLastName(String lastName);

    // Find customers by first name and last name
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    // Find customers by store ID
    List<Customer> findByStoreId(Short storeId);

    // Find active or inactive customers
    List<Customer> findByActiveBool(Boolean active);

    // Custom query using @Query annotation to find customers by email
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Customer findByEmailAddress(String email);

    // Custom query to find customers with a certain creation date
    @Query("SELECT c FROM Customer c WHERE c.createDate = ?1")
    List<Customer> findByCreateDate(Date createDate);

}
