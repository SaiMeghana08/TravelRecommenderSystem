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
                Destination manali = new Destination();
                manali.setName("Manali");
                manali.setTemperature(tempType.COLD);
                manali.setDuration(durationType.MEDIUM);
                manali.setBudget(budgetType.LOW);
                manali.setArea(areaType.MOUNTAIN);
                manali.setActivity(activityType.TREKKING);
                manali.setCuisine(cuisineType.VEG);
                manali.setTransport(transportType.ROAD);
                manali.setAccommodation(accommodationType.HOTEL);
                manali.setSeason(seasonType.WINTER);
                manali.setCountry(countryType.INDIA);

                repo.save(manali);

                // 🏙️ Bangalore
                Destination bangalore = new Destination();
                bangalore.setName("Bangalore");
                bangalore.setTemperature(tempType.MODERATE);
                bangalore.setDuration(durationType.SHORT);
                bangalore.setBudget(budgetType.MEDIUM);
                bangalore.setArea(areaType.CITY);
                bangalore.setActivity(activityType.CULTURAL);
                bangalore.setCuisine(cuisineType.VEG);
                bangalore.setTransport(transportType.ROAD);
                bangalore.setAccommodation(accommodationType.HOTEL);
                bangalore.setSeason(seasonType.SPRING);
                bangalore.setCountry(countryType.INDIA);
                repo.save(bangalore);

                // 🌄 Ooty
                Destination ooty = new Destination();
                ooty.setName("Ooty");
                ooty.setTemperature(tempType.COLD);
                ooty.setDuration(durationType.LONG);
                ooty.setBudget(budgetType.MEDIUM);
                ooty.setArea(areaType.MOUNTAIN);
                ooty.setActivity(activityType.RELAXATION);
                ooty.setCuisine(cuisineType.VEG);
                ooty.setTransport(transportType.ROAD);
                ooty.setAccommodation(accommodationType.RESORT);
                ooty.setSeason(seasonType.WINTER);
                ooty.setCountry(countryType.INDIA);
                repo.save(ooty);
            }
        };
    }
}

