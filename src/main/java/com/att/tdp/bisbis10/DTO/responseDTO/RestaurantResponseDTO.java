package com.att.tdp.bisbis10.DTO.responseDTO;


import java.util.Set;

public class RestaurantResponseDTO {
    private Long id;
    private String name;
    private boolean isKosher;
    private Set<String> cuisines;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean GetIsKosher() {
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

