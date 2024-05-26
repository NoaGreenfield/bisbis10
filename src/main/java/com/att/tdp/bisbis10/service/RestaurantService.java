package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.DTO.requestDTO.RestaurantRequestDTO;
import com.att.tdp.bisbis10.DTO.responseDTO.RestaurantResponseDTO;
import com.att.tdp.bisbis10.entity.Cuisine;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RestaurantService {


    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private CuisineService cuisineService;


    // READ REQUEST - SERVER RESPONSE
    public List<RestaurantResponseDTO> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(this::convertToRestaurantResponseDTO)
                .collect(Collectors.toList());
    }

    // READ ONE REQUEST - SERVER RESPONSE
    public RestaurantResponseDTO getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
        return convertToRestaurantResponseDTO(restaurant);
    }

    public Restaurant getRegRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public Set<RestaurantResponseDTO> getRestaurantsByCuisine(String cuisineName) {
        Cuisine cuisine = cuisineService.getCuisineByName(cuisineName);
        if (cuisine != null)
        {
            Set<Restaurant> restaurants = cuisine.getRestaurants();
            return restaurants.stream()
                    .map(this::convertToRestaurantResponseDTO)
                    .collect(Collectors.toSet());
        }
        return null;
    }

    // CREATE REQUEST
    public void createRestaurantWithCuisines(RestaurantRequestDTO restaurantRequestDTO) {
        Restaurant restaurant = new Restaurant();
       createFromRequestDTO(restaurantRequestDTO, restaurant);
    }


    // DELETE
    public void deleteRestaurant(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    // UPDATE
    public void updateRestaurant(Long restaurantId, RestaurantRequestDTO restaurantRequestDTO) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            Set<Cuisine> cuisines = new HashSet<>();
            for (String cuisineName : restaurantRequestDTO.getCuisines()) {
                cuisines.add(cuisineService.getOrCreateCuisine(cuisineName));
            }
            restaurant.setCuisines(cuisines);
            restaurantRepository.save(restaurant);
        }
    }



    private void createFromRequestDTO(RestaurantRequestDTO restaurantRequestDTO,
                                            Restaurant restaurant) {
        restaurant.setName(restaurantRequestDTO.getName());
        restaurant.setIsKosher(restaurantRequestDTO.getIsKosher());

        Set<Cuisine> cuisines = new HashSet<>();
        for (String cuisineName : restaurantRequestDTO.getCuisines()) {
            cuisines.add(cuisineService.getOrCreateCuisine(cuisineName));
        }
        restaurant.setCuisines(cuisines);
        restaurantRepository.save(restaurant);
    }


    // HELPER
    private RestaurantResponseDTO convertToRestaurantResponseDTO(Restaurant restaurant) {
        if (restaurant != null) {
            RestaurantResponseDTO restaurantResponseDTO = new RestaurantResponseDTO();
            restaurantResponseDTO.setId(restaurant.getId());
            restaurantResponseDTO.setName(restaurant.getName());
            restaurantResponseDTO.setIsKosher(restaurant.getIsKosher());

            Set<String> cuisineNames = restaurant.getCuisines().stream()
                    .map(Cuisine::getName)
                    .collect(Collectors.toSet());
            restaurantResponseDTO.setCuisines(cuisineNames);
            return restaurantResponseDTO;
        }
        return null;
    }

}





