package org.orchestry.service;

import org.springframework.stereotype.Service;

@Service
public class RecordGoldMedalService {
    public void recordGoldMedal(String athleteId) {
        System.out.println("Recorded gold medal for athlete: " + athleteId);
    }
}
