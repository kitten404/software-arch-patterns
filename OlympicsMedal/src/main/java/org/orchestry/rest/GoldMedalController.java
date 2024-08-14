package org.orchestry.rest;

import org.orchestry.service.SagaOrchestratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/athletes")
public class GoldMedalController {

    @Autowired
    private SagaOrchestratorService sagaOrchestratorService;

    @PostMapping("/{athleteId}/gold-medal")
    public String handleGoldMedalWin(@PathVariable String athleteId) {
        sagaOrchestratorService.handleGoldMedalWin(athleteId);
        return "Gold medal process initiated for athlete: " + athleteId;
    }
}
