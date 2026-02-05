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

                UserPreference u1 = new UserPreference();
                u1.setTemperature(tempType.HOT);
                u1.setDuration(durationType.MEDIUM);
                u1.setBudget(budgetType.MEDIUM);
                u1.setArea(areaType.BEACH);
                u1.setGroupType(groupType.FRIENDS);
                u1.setActivity(activityType.RELAXATION);
                u1.setCuisine(cuisineType.VEG);
                u1.setTransport(transportType.AIR);
                u1.setAccommodation(accommodationType.RESORT);
                u1.setSeason(seasonType.SUMMER);
                u1.setCountry(countryType.INDIA);
                repo.save(u1);

                // 👤 User 2 – Adventure solo
                UserPreference u2 = new UserPreference();
                u2.setTemperature(tempType.COLD);
                u2.setDuration(durationType.SHORT);
                u2.setBudget(budgetType.LOW);
                u2.setArea(areaType.MOUNTAIN);
                u2.setGroupType(groupType.SOLO);
                u2.setActivity(activityType.ADVENTURE);
                u2.setCuisine(cuisineType.LOCAL);
                u2.setTransport(transportType.ROAD);
                u2.setAccommodation(accommodationType.HOMESTAY);
                u2.setSeason(seasonType.WINTER);
                u2.setCountry(countryType.INDIA);
                repo.save(u2);

                // 👤 User 3 – Family vacation
                UserPreference u3 = new UserPreference();
                u3.setTemperature(tempType.MODERATE);
                u3.setDuration(durationType.LONG);
                u3.setBudget(budgetType.HIGH);
                u3.setArea(areaType.CITY);
                u3.setGroupType(groupType.FAMILY);
                u3.setActivity(activityType.CULTURAL);
                u3.setCuisine(cuisineType.VEG);
                u3.setTransport(transportType.AIR);
                u3.setAccommodation(accommodationType.HOTEL);
                u3.setSeason(seasonType.SPRING);
                u3.setCountry(countryType.INDIA);
                repo.save(u3);
            }
        };
    }
}
