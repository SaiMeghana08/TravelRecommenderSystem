package com.example.travelRecommend.Recommendation.Service;

import com.example.travelRecommend.Destination.Destination;
import com.example.travelRecommend.Destination.Repository.DestinationRepo;
import com.example.travelRecommend.User.Repository.UserRepo;
import com.example.travelRecommend.User.UserPreference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final UserRepo userRepo;
    private final DestinationRepo destinationRepo;

    private static final int MIN_SCORE_THRESHOLD = 4;

    public RecommendationService(UserRepo userRepo,
                                 DestinationRepo destinationRepo) {
        this.userRepo = userRepo;
        this.destinationRepo = destinationRepo;
    }

    // 🔹 MAIN ENTRY POINT
    public List<Destination> getTop3Recommendations(Long userId) {

        UserPreference user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Destination> destinations = destinationRepo.findAll();

        List<ScoredDestination> scoredDestinations = destinations.stream()
                .map(dest -> new ScoredDestination(dest, calculateScore(user, dest)))
                .sorted((a, b) -> {
                    int cmp = Integer.compare(b.score, a.score);
                    return cmp != 0 ? cmp : a.destination.getName().compareTo(b.destination.getName());
                })

                .toList();

        // 🚨 Cold-start / low-match handling
        if (scoredDestinations.isEmpty()
                || scoredDestinations.get(0).score < MIN_SCORE_THRESHOLD) {
            return fallbackRecommendation(user);
        }

        // ✅ Normal recommendation

        return scoredDestinations.stream()
                .filter(sd -> sd.score >= MIN_SCORE_THRESHOLD)
                .limit(3)
                .map(sd -> sd.destination)
                .toList();

    }

    // 🔹 SCORING LOGIC
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

    // 🛟 FALLBACK LOGIC (STEP 5 CORE)
    private List<Destination> fallbackRecommendation(UserPreference user) {

        // 1️⃣ Same country
        List<Destination> sameCountry =
                destinationRepo.findByCountry(user.getCountry());

        if (!sameCountry.isEmpty()) {
            return sameCountry.stream().limit(3).toList();
        }

        // 2️⃣ Same season
        List<Destination> sameSeason =
                destinationRepo.findBySeason(user.getSeason());

        if (!sameSeason.isEmpty()) {
            return sameSeason.stream().limit(3).toList();
        }

        // 3️⃣ Absolute fallback
        return destinationRepo.findAll().stream()
                .limit(3)
                .toList();
    }

    // 🔹 INTERNAL HELPER CLASS
    private static class ScoredDestination {
        Destination destination;
        int score;

        ScoredDestination(Destination destination, int score) {
            this.destination = destination;
            this.score = score;
        }
    }
}


