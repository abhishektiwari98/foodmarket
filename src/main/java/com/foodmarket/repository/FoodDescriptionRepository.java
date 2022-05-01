package com.foodmarket.repository;

import com.foodmarket.model.FoodDescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodDescriptionRepository extends JpaRepository<FoodDescription, String> {
    List<FoodDescription> findByfoodGroupCode(String foodGroupCode);
}
