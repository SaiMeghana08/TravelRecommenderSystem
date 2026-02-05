package com.example.travelRecommend.Destination.Repository;

import com.example.travelRecommend.Destination.Destination;
import com.example.travelRecommend.common.enums.countryType;
import com.example.travelRecommend.common.enums.seasonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepo extends JpaRepository<Destination,Long> {
    List<Destination> findByCountry(countryType country);

    List<Destination> findBySeason(seasonType season);
}
