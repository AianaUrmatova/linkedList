package service.impl;

import models.Movie;
import service.MovieSortableService;

import java.util.Comparator;

import static db.Database.movies;

public class MovieSortableImpl implements MovieSortableService {
    @Override
    public void sortMovieByName(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("acs")) {
            movies.sort(Comparator.comparing(Movie::getName));
            System.out.println(movies);
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            movies.sort(Comparator.comparing(Movie::getName).reversed());
            System.out.println(movies);
        } else {
            System.out.println("tuura jaz!");
        }
    }

    @Override
    public void sortByYear(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            movies.sort(Comparator.comparing(Movie::getYear));
            System.out.println(movies);
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            movies.sort(Comparator.comparing(Movie::getYear).reversed());
            System.out.println(movies);
        } else {
            System.out.println("tuura jaz!");
        }

    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        if (nameOrLastName.equalsIgnoreCase("LastName")) {
movies.sort(Comparator.comparing(m -> m.getProducer().getFursName()));
            System.out.println(movies);
        }else {
            System.out.println("tuura jazynyz!");
        }
    }
}
