package com.example.travelRecommend.Recommendation.Config;

import com.example.travelRecommend.User.Repository.UserRepo;
import com.example.travelRecommend.User.UserPreference;
import com.example.travelRecommend.common.enums.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadUserPreferences(UserRepo repo) {
        return args -> {

            // Prevent duplicate inserts
            if (repo.count() == 0) {

                UserPreference user1 = new UserPreference();
                user1.setTemperature(tempType.MODERATE);
                user1.setDuration(durationType.MEDIUM);
                user1.setBudget(budgetType.MEDIUM);
                user1.setArea(areaType.BEACH);
                user1.setGroupType(groupType.FRIENDS);
                user1.setActivity(activityType.TREKKING);
                user1.setCuisine(cuisineType.VEG);
                user1.setTransport(transportType.AIR);
                user1.setAccommodation(accommodationType.RESORT);
                user1.setSeason(seasonType.SPRING);
                user1.setCountry(countryType.INDIA);

                repo.save(user1);

                UserPreference user2 = new UserPreference();
                user2.setTemperature(tempType.COLD);
                user2.setDuration(durationType.SHORT);
                user2.setBudget(budgetType.LOW);
                user2.setArea(areaType.MOUNTAIN);
                user2.setGroupType(groupType.SOLO);
                user2.setActivity(activityType.ADVENTURE);
                user2.setCuisine(cuisineType.LOCAL);
                user2.setTransport(transportType.ROAD);
                user2.setAccommodation(accommodationType.HOMESTAY);
                user2.setSeason(seasonType.WINTER);
                user2.setCountry(countryType.INDIA);

                repo.save(user2);
            }
        };
    }
}
