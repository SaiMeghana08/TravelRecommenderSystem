package com.example.travelRecommend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class Controller {

    @GetMapping
    public String health() {
        return "Travel Recommendation Service is running";
    }
}

