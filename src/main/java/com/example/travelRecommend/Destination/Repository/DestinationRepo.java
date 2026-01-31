package com.example.travelRecommend.Destination.Repository;

import com.example.travelRecommend.Destination.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepo extends JpaRepository<Destination,Long> {
}
