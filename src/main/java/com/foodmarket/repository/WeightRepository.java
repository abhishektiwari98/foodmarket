package com.foodmarket.repository;

import com.foodmarket.model.Weight;
import com.foodmarket.model.WeightId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, WeightId> {
}
