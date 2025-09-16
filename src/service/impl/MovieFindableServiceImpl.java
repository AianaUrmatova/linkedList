package service.impl;

import db.Database;
import enums.Genre;
import models.Actor;
import models.Movie;
import service.MovieFindableService;

import java.time.LocalDate;
import java.util.List;

public class MovieFindableServiceImpl implements MovieFindableService {


    @Override
    public List<Movie> getAllMovies() {
        return Database.movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie movie : Database.movies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie : Database.movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getActorFullName().equalsIgnoreCase(actorName)) {
                    return movie;
                }
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie movie : Database.movies) {
            if (movie.getYear().getYear() == year.getYear()) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie movie : Database.movies) {
            if (movie.getProducer().getFursName().equalsIgnoreCase(producerFullName)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie movie : Database.movies) {
            if (movie.getGenre().equals(genre)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
        for (Movie movie : Database.movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getRole().equalsIgnoreCase(role)) {
                    return movie;
                }
            }


        }
        return null;
    }
}

