package com.quezia.streaminng.ranking.entrypoint;

import com.quezia.streaminng.ranking.entrypoint.dto.MovieDto;
import com.quezia.streaminng.ranking.entrypoint.dto.RankingDetailedDto;
import com.quezia.streaminng.ranking.entrypoint.dto.RankingDto;
import com.quezia.streaminng.ranking.model.Ranking;
import com.quezia.streaminng.ranking.service.RankingService;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rankings")
@AllArgsConstructor
public class RankingController {
  private RankingService rankingService;

  @GetMapping("/current/movies")
  public RankingDto getMovieRankByCurrentDate() {
    LocalDate date = LocalDate.now();
    List<Ranking> rankings = rankingService.findRankingInCurrentDate(date);
    if (rankings != null && !rankings.isEmpty()) {
      List<MovieDto> movieDto =
          rankings.stream().map(e -> new MovieDto(e.getMovie().getName())).toList();
      return RankingDto.builder().movies(movieDto).date(date).build();
    }
    return null;
  }

  @GetMapping
  public List<RankingDetailedDto> getRanking() {
    LocalDate date = LocalDate.now();
    List<Ranking> rankings = rankingService.findRankingInCurrentDate(date);
    if (rankings != null) {
      return rankings.stream()
          .map(
              e ->
                  RankingDetailedDto.builder()
                      .movieName(e.getMovie().getName())
                      .date(date)
                      .playedSum(e.getPlayedSum())
                      .build())
          .toList();
    }
    return null;
  }
}
