package com.example.travelRecommend.Destination;

import com.example.travelRecommend.Destination.Repository.DestinationRepo;
import com.example.travelRecommend.common.enums.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DestDataLoader {
    @Bean
    CommandLineRunner loadDestinations(DestinationRepo repo) {
        return args -> {
            if (repo.count() == 0) {

                Destination goa = new Destination();
                goa.setName("Goa");
                goa.setTemperature(tempType.HOT);
                goa.setDuration(durationType.MEDIUM);
                goa.setBudget(budgetType.MEDIUM);
                goa.setArea(areaType.BEACH);
                goa.setActivity(activityType.TREKKING);
                goa.setCuisine(cuisineType.VEG);
                goa.setTransport(transportType.AIR);
                goa.setAccommodation(accommodationType.RESORT);
                goa.setSeason(seasonType.SUMMER);
                goa.setCountry(countryType.INDIA);

                repo.save(goa);
            }
        };
    }
}

