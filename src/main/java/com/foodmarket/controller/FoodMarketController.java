package com.foodmarket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodMarketController {

    @GetMapping(path = "/welcome")
    public String welcome() {
        return "Welcome";
    }
}
