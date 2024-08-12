package com.quezia.streaminng.ranking.service;

import com.quezia.streaminng.ranking.datasource.jpa.RankingRepository;
import com.quezia.streaminng.ranking.model.Ranking;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RankingService {
  private RankingRepository rankingRepository;

  public List<Ranking> findRankingInCurrentDate(LocalDate date) {
    return rankingRepository.findTopToBottomByDate(date);
  }
}
