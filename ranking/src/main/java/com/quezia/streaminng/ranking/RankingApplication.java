package com.quezia.streaminng.ranking;

import com.quezia.streaminng.ranking.datasource.jpa.MovieRepository;
import com.quezia.streaminng.ranking.model.Movie;
import com.quezia.streaminng.ranking.model.enums.GenreEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RankingApplication implements CommandLineRunner {
  @Autowired private MovieRepository movieRepository;

  public static void main(String[] args) {
    SpringApplication.run(RankingApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    movieRepository.save(
        Movie.builder().name("THE SILENCE OF THE LAMBS").genre(GenreEnum.THRILLER).build());

    movieRepository.save(Movie.builder().name("THE GODFATHER").genre(GenreEnum.DRAMA).build());

    movieRepository.save(Movie.builder().name("THE MATRIX").genre(GenreEnum.SCI_FI).build());

    movieRepository.save(Movie.builder().name("JURASSIC PARK").genre(GenreEnum.ADVENTURE).build());

    movieRepository.save(
        Movie.builder().name("GONE WITH THE WIND").genre(GenreEnum.ROMANCE).build());
  }
}
