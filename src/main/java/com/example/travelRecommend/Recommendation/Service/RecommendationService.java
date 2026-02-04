package com.example.travelRecommend.Recommendation.Service;

import com.example.travelRecommend.User.Repository.UserRepo;
import com.example.travelRecommend.User.UserPreference;
import com.example.travelRecommend.Destination.Destination;
import com.example.travelRecommend.Destination.Repository.DestinationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final UserRepo userRepo;
    private final DestinationRepo destinationRepo;

    public RecommendationService(UserRepo userRepo,
                                 DestinationRepo destinationRepo) {
        this.userRepo = userRepo;
        this.destinationRepo = destinationRepo;
    }

    public List<Destination> getTop3Recommendations(Long userId) {

        UserPreference user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Destination> destinations = destinationRepo.findAll();

        return destinations.stream()
                .map(dest -> new ScoredDestination(dest, calculateScore(user, dest)))
                .sorted((a, b) -> Integer.compare(b.score, a.score))
                .limit(3)
                .map(sd -> sd.destination)
                .toList();
    }

    private int calculateScore(UserPreference user, Destination dest) {
        int score = 0;

        if (user.getTemperature() == dest.getTemperature()) score += 2;
        if (user.getBudget() == dest.getBudget()) score += 2;

        if (user.getDuration() == dest.getDuration()) score++;
        if (user.getArea() == dest.getArea()) score++;
        if (user.getActivity() == dest.getActivity()) score++;
        if (user.getCuisine() == dest.getCuisine()) score++;
        if (user.getTransport() == dest.getTransport()) score++;
        if (user.getAccommodation() == dest.getAccommodation()) score++;
        if (user.getSeason() == dest.getSeason()) score++;
        if (user.getCountry() == dest.getCountry()) score++;

        return score;
    }

    private static class ScoredDestination {
        Destination destination;
        int score;

        ScoredDestination(Destination destination, int score) {
            this.destination = destination;
            this.score = score;
        }
    }
}

