package com.quezia.streaminng.ranking.service;

import com.quezia.streaminng.ranking.model.events.MoviePlayEvent;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MoviePlayEventPublisher {
  private ApplicationEventPublisher applicationEventPublisher;

  public void publishMoviePlayEvent(Long movieId, LocalDate date) {
    MoviePlayEvent event = new MoviePlayEvent(movieId, date);
    applicationEventPublisher.publishEvent(event);
  }
}
