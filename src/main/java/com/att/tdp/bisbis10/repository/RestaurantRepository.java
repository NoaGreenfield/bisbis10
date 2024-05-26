package com.att.tdp.bisbis10.repository;

import com.att.tdp.bisbis10.entity.Cuisine;
import com.att.tdp.bisbis10.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
