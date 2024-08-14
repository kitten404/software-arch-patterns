package org.choreography.broker;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoldMedalProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void recordGoldMedal(String athleteId) {
        System.out.println("Recorded gold medal for athlete: " + athleteId);

        rabbitTemplate.convertAndSend("goldMedalExchange", "athlete.goldmedal", athleteId);
    }
}
