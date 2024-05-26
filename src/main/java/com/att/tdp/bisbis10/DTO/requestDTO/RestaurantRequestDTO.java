package com.att.tdp.bisbis10.DTO.requestDTO;

import java.util.Set;

public class RestaurantRequestDTO {
    private String name;
    private boolean isKosher;
    private Set<String> cuisines;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsKosher() {
        return isKosher;
    }

    public void setIsKosher(boolean isKosher) {
        this.isKosher = isKosher;
    }

    public Set<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }
}


