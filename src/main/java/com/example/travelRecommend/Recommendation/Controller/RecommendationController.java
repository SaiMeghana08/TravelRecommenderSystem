package com.example.travelRecommend.Recommendation.Controller;

import com.example.travelRecommend.Recommendation.Service.RecommendationService;
import com.example.travelRecommend.Destination.Destination;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {
    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{userId}")
    public List<Destination> recommend(@PathVariable Long userId) {
        return recommendationService.getTop3Recommendations(userId);
    }
}
