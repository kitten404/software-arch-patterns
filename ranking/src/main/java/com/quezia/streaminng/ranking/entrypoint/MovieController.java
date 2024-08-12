package com.quezia.streaminng.ranking.entrypoint;

import com.quezia.streaminng.ranking.service.MoviePlayEventPublisher;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {
  private MoviePlayEventPublisher eventPublisher;

  @PostMapping("/play/{movieId}")
  public void playMovie(@PathVariable Long movieId) {
    eventPublisher.publishMoviePlayEvent(movieId, LocalDate.now());
  }
}
