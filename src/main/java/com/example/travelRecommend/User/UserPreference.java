package com.example.travelRecommend.User;

import com.example.travelRecommend.common.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserPreference {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated(EnumType.STRING)
        private tempType temperature;

        @Enumerated(EnumType.STRING)
        private durationType duration;

        @Enumerated(EnumType.STRING)
        private budgetType budget;

        @Enumerated(EnumType.STRING)
        private areaType area;

        @Enumerated(EnumType.STRING)
        private groupType groupType;

        @Enumerated(EnumType.STRING)
        private activityType activity;

        @Enumerated(EnumType.STRING)
        private cuisineType cuisine;

        @Enumerated(EnumType.STRING)
        private transportType transport;

        @Enumerated(EnumType.STRING)
        private accommodationType accommodation;

        @Enumerated(EnumType.STRING)
        private seasonType season;

        @Enumerated(EnumType.STRING)
        private countryType country;

}
