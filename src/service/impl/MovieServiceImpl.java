package service.impl;

import enums.Genre;
import models.Movie;
import service.MovieFindableService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieServiceImpl implements MovieFindableService {
    private List<Movie> movies;
    public MovieServiceImpl(List<Movie> movies) {
        this.movies = movies;
    }


    @Override
    public List<Movie> getAllMovies() {
        return List.of();
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        return movies.stream()
                .filter(m -> m.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst()
                .orElse(null);

    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        return movies.stream()
                .filter(m -> m.getActors().stream()
                        .anyMatch(a -> a.getActorFullName().equalsIgnoreCase(actorName)))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        return movies.stream()
                .filter(m -> m.getYear().equals(year))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        return movies.stream()
                .filter(m -> m.getProducer().getFursName().equalsIgnoreCase(producerFullName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        return movies.stream()
                .filter(m -> m.getGenre() == genre)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie findMovieByRole(String role) {
        return movies.stream()
                .filter(m -> m.getActors().stream()
                        .anyMatch(a -> a.getRole().equalsIgnoreCase(role)))
                .findFirst()
                .orElse(null);
    }
        public void sortMovieByName(String ascOrDesc) {
            movies.sort(Comparator.comparing(Movie::getName));
            if (ascOrDesc.equalsIgnoreCase("desc")) {
                Collections.reverse(movies);
            }
        }


        public void sortByYear(String ascOrDesc) {
            movies.sort(Comparator.comparing(Movie::getYear));
            if (ascOrDesc.equalsIgnoreCase("desc")) {
                Collections.reverse(movies);
            }
        }


        public void sortByProducer(String nameOrLastName) {
            if (nameOrLastName.equalsIgnoreCase("name")) {
                movies.sort(Comparator.comparing(m -> m.getProducer().getFursName()));
            } else if (nameOrLastName.equalsIgnoreCase("lastname")) {
                movies.sort(Comparator.comparing(m -> m.getProducer().getLastName()));
    }
}}

