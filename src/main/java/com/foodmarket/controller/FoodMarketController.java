package com.foodmarket.controller;

import com.foodmarket.model.User;
import com.foodmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodMarketController {
    @Autowired
    UserRepository userRepository; // Dependency injection from Spring

    @GetMapping(path = "/welcome")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping(path = "/createUser")
    public void addUser(@RequestParam(name = "first-name") String fName,
                        @RequestParam(name = "last-name") String lName,
                        @RequestParam(name = "city") String city,
                        @RequestParam(name = "zip-code") int zipCode,
                        @RequestParam(name = "country") String county) {
        User newUser = new User(fName, lName, city, county, zipCode);
        userRepository.save(newUser);
    }

    @GetMapping(path = "/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
