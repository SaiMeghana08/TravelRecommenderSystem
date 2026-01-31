package com.example.travelRecommend.Destination.Controllers;

import com.example.travelRecommend.Destination.Destination;
import com.example.travelRecommend.Destination.Repository.DestinationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dest")
public class DestController {
    @Autowired
    private DestinationRepo repo;



    @GetMapping
    public List<Destination> getAll() {
        return repo.findAll();
    }
}

