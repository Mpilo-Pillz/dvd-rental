package com.dvdrental.springbootdvdrentalapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DVDRentalController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to dvd rental api";
    }
}
