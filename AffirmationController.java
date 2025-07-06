package com.dailyaffirmation.affirmationtracker.controller;

import com.dailyaffirmation.affirmationtracker.model.Affirmation;
import com.dailyaffirmation.affirmationtracker.repository.AffirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*") // Allow frontend to access
@RequestMapping("/api/affirmations")
public class AffirmationController {

    @Autowired
    private AffirmationRepository repository;

    // Get a random affirmation
    @GetMapping("/random")
    public Affirmation getRandomAffirmation() {
        List<Affirmation> all = repository.findAll();
        if (all.isEmpty()) return new Affirmation("You are amazing!");
        return all.get(new Random().nextInt(all.size()));
    }

    // Like an affirmation
    @PostMapping("/{id}/like")
    public String likeAffirmation(@PathVariable Long id) {
        Affirmation affirmation = repository.findById(id).orElse(null);
        if (affirmation != null) {
            affirmation.setLiked(true);
            repository.save(affirmation);
            return "Liked!";
        }
        return "Affirmation not found.";
    }

    // Get liked affirmations
    @GetMapping("/favorites")
    public List<Affirmation> getFavorites() {
        return repository.findByLikedTrue();
    }

    // Add a new affirmation manually
    @PostMapping("/add")
    public Affirmation addAffirmation(@RequestBody Affirmation affirmation) {
        return repository.save(affirmation);
    }
}
