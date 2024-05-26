package com.att.tdp.bisbis10.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "rating_value")
    private Double ratingValue;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    // Constructors
    public Rating(double ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Rating() {}

    // Getters and Setters
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Double getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(Double ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Restaurant getRestaurant() { return restaurant;}

    public void setRestaurant(Restaurant restaurant) {
    }

}
