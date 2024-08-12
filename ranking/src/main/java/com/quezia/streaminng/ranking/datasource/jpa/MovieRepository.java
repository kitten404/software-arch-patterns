package com.quezia.streaminng.ranking.datasource.jpa;

import com.quezia.streaminng.ranking.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {}
