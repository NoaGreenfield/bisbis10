package com.att.tdp.bisbis10.DTO.requestDTO;

public class RatingRequestDTO {
    private Long restaurantId;
    private Double ratingValue;


    public Double getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(Double ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
