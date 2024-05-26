package com.att.tdp.bisbis10.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String name;

    @Column(name = "is_kosher")
    private Boolean isKosher;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "restaurant_cuisine",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "cuisine_id"))
    private Set<Cuisine> cuisines = new HashSet<>();

    @OneToMany(mappedBy="restaurant", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Rating> ratings;

    @Column(name = "average_rating")
    private double averageRating;

    public Restaurant() { }
    public Restaurant(String name, Boolean isKosher) {
        this.name = name;
        this.isKosher = isKosher;
    }

    // Getters and Setters

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

    public boolean getIsKosher() {
        return isKosher;
    }

    public void setIsKosher(boolean isKosher) {
        this.isKosher = isKosher;
    }

    public Set<Cuisine> getCuisines() {
        return cuisines;
    }
    public void setCuisines(Set<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public double getAverageRating() {
        return averageRating;
    }


    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
