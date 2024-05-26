package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.DTO.requestDTO.RatingRequestDTO;
import com.att.tdp.bisbis10.entity.Rating;
import com.att.tdp.bisbis10.repository.RatingRepository;
import com.att.tdp.bisbis10.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping()
    public ResponseEntity<Void> addOne(@RequestBody RatingRequestDTO ratingRequestDTO)
    {
        ratingService.createRatingValue(ratingRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
