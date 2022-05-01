package com.foodmarket.service;

import com.foodmarket.model.FoodDescription;
import com.foodmarket.model.FoodGroup;
import com.foodmarket.repository.FoodDescriptionRepository;
import com.foodmarket.repository.FoodGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodService {
    @Autowired
    private FoodGroupRepository foodGroupRepository;

    @Autowired
    private FoodDescriptionRepository foodDescriptionRepository;

    public List<FoodGroup> getAllFoodGroups() {
        return foodGroupRepository.findAll();
    }

    public List<FoodDescription> getFoodDescription(final String groupCode) {
        return foodDescriptionRepository.findByfoodGroupCode(groupCode);
    }
}
