package org.orchestry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SagaOrchestratorService {

    @Autowired
    private RecordGoldMedalService recordGoldMedalService;

    @Autowired
    private UpdateAthleteProfileService updateAthleteProfileService;

    @Autowired
    private NotifySponsorsService notifySponsorsService;

    @Autowired
    private UpdateMedalCountService updateMedalCountService;

    public void handleGoldMedalWin(String athleteId) {
        try {
            // Step 1: Record gold medal win
            recordGoldMedalService.recordGoldMedal(athleteId);

            // Step 2: Update athlete profile
            updateAthleteProfileService.updateProfile(athleteId);

            // Step 3: Notify sponsors
            notifySponsorsService.notifySponsors(athleteId);

            // Step 4: Update medal count
            updateMedalCountService.updateMedalCount();

        } catch (Exception e) {
            System.err.println("Error handling gold medal win: " + e.getMessage());
        }
    }
}
