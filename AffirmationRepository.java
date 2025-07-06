package com.dailyaffirmation.affirmationtracker.repository;

import com.dailyaffirmation.affirmationtracker.model.Affirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AffirmationRepository extends JpaRepository<Affirmation, Long> {
    List<Affirmation> findByLikedTrue();
}
