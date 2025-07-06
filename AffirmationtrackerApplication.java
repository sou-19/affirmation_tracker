package com.dailyaffirmation.affirmationtracker;

import com.dailyaffirmation.affirmationtracker.model.Affirmation;
import com.dailyaffirmation.affirmationtracker.repository.AffirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AffirmationtrackerApplication implements CommandLineRunner {

	@Autowired
	private AffirmationRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AffirmationtrackerApplication.class, args);
	}

	// This method runs after the application starts
	@Override
	public void run(String... args) throws Exception {
		// Add affirmations if repository is empty
		if (repository.count() == 0) {
			repository.save(new Affirmation("You are doing great!"));
			repository.save(new Affirmation("Stay positive and strong."));
			repository.save(new Affirmation("Every step forward counts."));
			repository.save(new Affirmation("Change the world by being yourself."));
			repository.save(new Affirmation("Mindset is everything."));
			repository.save(new Affirmation("Lead from the heart not the head."));
			repository.save(new Affirmation("Turn your wounds into wisdom."));
			repository.save(new Affirmation("Every moment is a fresh beginning."));

		}
	}
}
