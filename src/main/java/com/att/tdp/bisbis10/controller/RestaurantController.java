package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.DTO.requestDTO.RestaurantRequestDTO;
import com.att.tdp.bisbis10.DTO.responseDTO.RestaurantResponseDTO;
import com.att.tdp.bisbis10.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    // Get all restaurants
    @GetMapping()
    public ResponseEntity<List<RestaurantResponseDTO>> getAllRestaurants()
    {
        return new ResponseEntity<>(restaurantService.getAllRestaurants(), HttpStatus.OK);
    }

    // Get restaurants by cuisine.
    @GetMapping("/cuisine/{cuisine}")
    public ResponseEntity<Set<RestaurantResponseDTO>> getRestaurantsByCuisine(@PathVariable String cuisine) {
        Set< RestaurantResponseDTO> restaurantsResponseDTO =
                restaurantService.getRestaurantsByCuisine(cuisine);
        return new ResponseEntity<>(restaurantsResponseDTO, HttpStatus.OK);
    }

    // Get restaurants by id.
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDTO> getRestaurantById(@PathVariable Long id) {
        RestaurantResponseDTO restaurantResponseDTO = restaurantService.getRestaurantById(id);
        return new ResponseEntity<>(restaurantResponseDTO, HttpStatus.OK);
    }

    // Create a restaurant.
    @PostMapping()
    public ResponseEntity<Void> addOneRestaurant(@RequestBody RestaurantRequestDTO restaurantRequestDTO)
    {
        restaurantService.createRestaurantWithCuisines(restaurantRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Update a restaurant.
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOne(@PathVariable Long id,
                                          @RequestBody RestaurantRequestDTO restaurantRequestDTO)
    {
        restaurantService.updateRestaurant(id, restaurantRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Delete a restaurant.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}








