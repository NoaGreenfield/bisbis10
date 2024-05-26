package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.entity.Cuisine;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CuisineService {
    @Autowired
    private CuisineRepository cuisineRepository;

    // CREATE
    public Cuisine createCuisine(Cuisine cuisine) {
        return cuisineRepository.save(cuisine);
    }



    // READ BY NAME
    public Cuisine getCuisineByName(String cuisineName) {
        Optional<Cuisine> optionalCuisine = cuisineRepository.findByName(cuisineName);
        return optionalCuisine.orElse(null);
    }



    // GET OR CREATE
    public Cuisine getOrCreateCuisine(String cuisineName) {
    Cuisine existingCuisine = getCuisineByName(cuisineName);
    if (existingCuisine != null) {
        return existingCuisine;
    } else {
        Cuisine newCuisine = new Cuisine(cuisineName);
        return createCuisine(newCuisine);
    }
}

    // READ
//    public List<Cuisine> getCuisine() {
//        return cuisineRepository.findAll();
//    }

//    // DELETE
//    public void deleteCuisine(Long cuisineId) {
//        cuisineRepository.deleteById(cuisineId);
//
//    }

//    // UPDATE
//    public void updateCuisine(Long cuisineId, Cuisine cuisineDetails) {
//        Optional<Cuisine> optionalCuisine = cuisineRepository.findById(cuisineId);
//        if (optionalCuisine.isPresent()) {
//            Cuisine cuisine = optionalCuisine.get();
//            cuisine.setName(cuisineDetails.getName());
//        }
//    }


}



