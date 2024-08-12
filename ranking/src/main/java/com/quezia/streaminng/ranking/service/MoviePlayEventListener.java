package com.quezia.streaminng.ranking.service;

import com.quezia.streaminng.ranking.datasource.jpa.MovieRepository;
import com.quezia.streaminng.ranking.datasource.jpa.RankingRepository;
import com.quezia.streaminng.ranking.model.Movie;
import com.quezia.streaminng.ranking.model.Ranking;
import com.quezia.streaminng.ranking.model.events.MoviePlayEvent;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MoviePlayEventListener {
  private MovieRepository movieRepository;
  private RankingRepository rankingRepository;

  @EventListener
  public void handleMoviePlayEvent(MoviePlayEvent event) {
    Long movieId = event.getMovieId();
    LocalDate date = event.getDate();
    Movie movie =
        movieRepository
            .findById(movieId)
            .orElseThrow(() -> new RuntimeException("Movie not found"));
    Ranking ranking = rankingRepository.findByMovieIdAndDate(movieId, date);
    if (ranking == null) {
      rankingRepository.save(Ranking.builder().movie(movie).playedSum(1).date(date).build());
    } else {
      ranking.incrementPlayedSum();
      rankingRepository.save(ranking);
    }
    System.out.println("Updated movie ranking for movieId: " + movieId);
  }
}
