package com.quezia.streaminng.ranking.entrypoint.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RankingDto {
  private List<MovieDto> movies;
  private LocalDate date;
}
