package com.quezia.streaminng.ranking.model.events;

import java.time.LocalDate;
import lombok.Data;

@Data
public class MoviePlayEvent {
  private final Long movieId;
  private final LocalDate date;
}
