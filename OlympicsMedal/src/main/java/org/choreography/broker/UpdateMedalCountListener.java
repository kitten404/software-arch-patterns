package org.choreography.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UpdateMedalCountListener {
    @RabbitListener(queues = "medalCountQueue")
    public void handleMedalUpdateEvent(String athleteId) {
        System.out.println("Updated global medal count for athlete: " + athleteId);
    }
}
