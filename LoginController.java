package com.dailyaffirmation.affirmationtracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class LoginController {

    // Hardcoded credentials
    private final String validUsername = "soujanya";
    private final String validPassword = "1234";

    @PostMapping("/login")
public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
    String username = loginData.get("username");
    String password = loginData.get("password");

    if ("soujanya".equals(username) && "1234".equals(password)) {
        return ResponseEntity.ok("Login successful");
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}

}
