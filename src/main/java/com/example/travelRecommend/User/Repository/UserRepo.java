package com.example.travelRecommend.User.Repository;

import com.example.travelRecommend.User.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserPreference,Long> {

}
