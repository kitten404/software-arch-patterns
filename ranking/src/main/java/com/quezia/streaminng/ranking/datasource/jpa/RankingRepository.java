package com.quezia.streaminng.ranking.datasource.jpa;

import com.quezia.streaminng.ranking.model.Ranking;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
  @Query(value = "select r from Ranking r where r.movie.id=?1 and r.date=?2")
  Ranking findByMovieIdAndDate(Long id, LocalDate date);

  @Query("select r from Ranking r where r.date=?1 ORDER BY playedSum DESC")
  List<Ranking> findTopToBottomByDate(LocalDate date);
}
