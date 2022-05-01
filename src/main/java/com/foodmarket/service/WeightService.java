package com.foodmarket.service;

import com.foodmarket.model.Weight;
import com.foodmarket.model.WeightId;
import com.foodmarket.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WeightService {
    @Autowired
    private WeightRepository weightRepository;

    public Weight getWeight(final String dbNumber, final String seqNumber) {
        WeightId id = new WeightId();
        id.setNdbNumber(dbNumber);
        id.setSequence(seqNumber);

        Optional<Weight> weightResponse = weightRepository.findById(id);
        return weightResponse.get();
    }
}
