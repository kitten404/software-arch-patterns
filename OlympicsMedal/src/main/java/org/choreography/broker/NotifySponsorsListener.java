package org.choreography.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotifySponsorsListener {
    @RabbitListener(queues = "sponsorNotificationQueue")
    public void handleProfileUpdatedEvent(String athleteId) {
        System.out.println("Notified sponsors for athlete: " + athleteId);
    }
}
