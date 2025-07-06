package com.dailyaffirmation.affirmationtracker.model;


import jakarta.persistence.*;

@Entity
public class Affirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quote;
    private boolean liked;

    // Constructors
    public Affirmation() {}

    public Affirmation(String quote) {
        this.quote = quote;
        this.liked = false;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getQuote() { return quote; }
    public void setQuote(String quote) { this.quote = quote; }

    public boolean isLiked() { return liked; }
    public void setLiked(boolean liked) { this.liked = liked; }
}
