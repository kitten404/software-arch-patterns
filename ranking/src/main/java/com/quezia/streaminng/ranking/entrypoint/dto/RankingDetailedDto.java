package com.quezia.streaminng.ranking.entrypoint.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RankingDetailedDto {
  private String movieName;
  private Integer playedSum;
  private LocalDate date;
}
