package com.foodmarket.controller;

import com.foodmarket.common.Constants;
import com.foodmarket.model.FoodDescription;
import com.foodmarket.model.FoodGroup;
import com.foodmarket.model.Weight;
import com.foodmarket.service.FoodService;
import com.foodmarket.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * Controller class to register all the API endpoints that are publicly accessible.
 */
@Controller
public class FoodMarketController {
    @Autowired
    private WeightService weightService;

    @Autowired
    private FoodService foodService;

    @GetMapping(path = "getWeight")
    public Map<String, String> getWeight(@RequestParam("dbNumber") String dbNumber,
                                         @RequestParam("seq") String seqNumber) {
        Map<String, String> response = new HashMap<>();
        Weight weight = weightService.getWeight(dbNumber, seqNumber);

        response.put("db_number", weight.getWeightId().getNdbNumber());
        response.put("seq_number", weight.getWeightId().getSequence());
        response.put("desc", weight.getDescription());
        response.put("amount", String.valueOf(weight.getAmount()));
        response.put("weight", String.valueOf(weight.getWeight()));
        response.put("data_points", String.valueOf(weight.getNumDataPoints()));
        response.put("std_dev", String.valueOf(weight.getStdDev()));

        response.put("foo", "bar");
        response.put("aa", "bb");

        return response;
    }

    @GetMapping(path = "foodGroups")
    public String getFoodGroups(Model model) {
        List<Map<String, String>> foodGroups = new ArrayList<>();
        List<FoodGroup> allGroups = foodService.getAllFoodGroups();
        for (FoodGroup group : allGroups) {
            Map<String, String> response = new HashMap<>();
            response.put("code", group.getGroupCode());
            response.put("desc", group.getGroupDescription());
            foodGroups.add(response);
        }

        model.addAttribute("groups", foodGroups);
        return Constants.FOOD_GROUPS_VIEW_NAME;
    }

    @GetMapping(path = "foodItemsInGroup")
    public String getAllFoodItemsInGroup(@RequestParam("groupCode") Optional<String> groupCodeInput, Model model) {
        final String groupCode = groupCodeInput.orElse("0100");

        List<Map<String, String>> foodItems = new ArrayList<>();
        List<FoodDescription> allGroups = foodService.getFoodDescription(groupCode);
        for (FoodDescription desc : allGroups) {
            Map<String, String> response = new HashMap<>();
            response.put("databank", desc.getDatabankNumber());
            response.put("group_code", desc.getFoodGroupCode());
            response.put("long_desc", desc.getLongDescription());
            response.put("short_desc", desc.getShortDescription());
            response.put("n_factor", desc.getNitrogenFactor() == null ? "N/A" : String.valueOf(desc.getNitrogenFactor()));
            response.put("pro_factor", desc.getProteinFactor() == null ? "N/A" : String.valueOf(desc.getProteinFactor()));
            response.put("fat_factor", desc.getFatFactor() == null ? "N/A" : String.valueOf(desc.getFatFactor()));
            response.put("carb_factor", desc.getCarbFactor() == null ? "N/A" : String.valueOf(desc.getCarbFactor()));
            foodItems.add(response);
        }

        model.addAttribute("items", foodItems);
        return Constants.FOOD_GROUP_ITEMS_VIEW_NAME;
    }
}
