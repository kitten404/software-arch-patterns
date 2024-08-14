package org.choreography.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UpdateAthleteProfileListener {
    @RabbitListener(queues = "athleteProfileQueue")
    public void handleGoldMedalEvent(String athleteId) {
        System.out.println("Updated profile for athlete: " + athleteId);
    }
}
