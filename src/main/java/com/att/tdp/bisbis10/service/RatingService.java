package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.DTO.requestDTO.RatingRequestDTO;
import com.att.tdp.bisbis10.DTO.responseDTO.RestaurantResponseDTO;
import com.att.tdp.bisbis10.entity.Rating;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private RestaurantService restaurantService;


    private void updateAverageRating(Restaurant restaurant) {
    }

    public void createRatingValue(RatingRequestDTO ratingRequestDTO) {

    }

}