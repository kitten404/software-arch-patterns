package org.orchestry.service;

import org.springframework.stereotype.Service;

@Service
public class UpdateAthleteProfileService {
    public void updateProfile(String athleteId) {
        System.out.println("Updated profile for athlete: " + athleteId);
    }
}