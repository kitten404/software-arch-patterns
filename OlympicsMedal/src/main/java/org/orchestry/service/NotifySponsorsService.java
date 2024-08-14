package org.orchestry.service;

import org.springframework.stereotype.Service;

@Service
public class NotifySponsorsService {
    public void notifySponsors(String athleteId) {
        System.out.println("Notified sponsors for athlete: " + athleteId);
    }
}