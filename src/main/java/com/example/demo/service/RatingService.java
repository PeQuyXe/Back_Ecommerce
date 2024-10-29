package com.example.demo.service;

import com.example.demo.model.Rating;
import com.example.demo.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> getRatingsByProductId(Long prodId) {
        return ratingRepository.findByProdId(prodId);
    }

    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Optional<Rating> updateRating(Long id, Rating ratingDetails) {
        return ratingRepository.findById(id)
                .map(rating -> {
                    rating.setStar(ratingDetails.getStar());
                    rating.setComment(ratingDetails.getComment());
                    rating.setStatus(ratingDetails.getStatus());
                    return ratingRepository.save(rating);
                });
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
