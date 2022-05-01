package com.foodmarket.repository;

import com.foodmarket.model.FoodGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodGroupRepository extends JpaRepository<FoodGroup, String> {

}
