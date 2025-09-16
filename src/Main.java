import db.Database;
import enums.Genre;
import models.Actor;
import models.Movie;
import models.Producer;
import service.MovieFindableService;
import service.MovieSortableService;
import service.impl.MovieFindableServiceImpl;
import service.impl.MovieSortableImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static db.Database.movies;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        MovieFindableService findableService = new MovieFindableServiceImpl();
        MovieSortableService sortableService = new MovieSortableImpl();


        movies.add(new Movie("I", LocalDate.of(2010, 1, 1), Genre.SCIFI,
                new Producer("Christopher", "Nolan"),
                Arrays.asList(new Actor("Leonardo DiCaprio", "Cobb"),
                        new Actor("Joseph Gordon-Levitt", "Arthur"))));

        movies.add(new Movie("Interstellar", LocalDate.of(2014, 1, 1), Genre.SCIFI,
                new Producer("Christopher", "Nolan"),
                Arrays.asList(new Actor("Matthew McConaughey", "Cooper"),
                        new Actor("Anne Hathaway", "Brand"))));

        movies.add(new Movie("The Godfather", LocalDate.of(1972, 1, 1), Genre.DRAMA,
                new Producer("Francis", "Coppola"),
                Arrays.asList(new Actor("Marlon Brando", "Vito Corleone"),
                        new Actor("Al Pacino", "Michael Corleone"))));


        boolean isTrue = true;
        while (isTrue) {
            try {
            System.out.println("\n=======❤️ MOVIE MENU ❤️=======");
            System.out.println("1 . Show all movies");
            System.out.println("2 . Find by full or part name");
            System.out.println("3 . Find by actor name");
            System.out.println("4 . Find by year");
            System.out.println("5 . Find by producer full name");
            System.out.println("6 . Find by genre");
            System.out.println("7 . Find by role");
            System.out.println("8 . Sort by movie name (asc/desc)");
            System.out.println("9 . Sort by year (asc/desc)");
            System.out.println("10. Sort by producer (name/lastname)");
            System.out.println("0 . Exit");
            System.out.print("Choose option: ");

            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    for (Movie movie : findableService.getAllMovies()) {
                        System.out.println(movie);
                    }
                    break;

                case 2:
                    System.out.print("Write name movie: ");
                    String name = scanner.nextLine();
                    System.out.println(findableService.findMovieByFullNameOrPartName(name));
                    break;

                case 3:
                    System.out.print("Write name actor: ");
                    String actorName = scanner.nextLine();
                    System.out.println(findableService.findMovieByFullNameOrPartName(actorName));
                    break;

                case 4:
                    System.out.print("Enter year (yyyy): ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(findableService.findMovieByYear(LocalDate.of(year, 1, 1)));
                    break;

                case 5:
                    System.out.print("Enter producer full name: ");
                    String producerName = scanner.nextLine();
                    System.out.println(findableService.findMovieByProducer(producerName));
                    break;

                case 6:
                    System.out.print("Enter genre (ACTION, COMEDY, DRAMA");
                    Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());
                    System.out.println(findableService.findMovieByGenre(genre));
                    break;

                case 7:
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();
                    System.out.println(findableService.findMovieByRole(role));
                    break;

                case 8:
                    System.out.print("Sort by name (asc/desc): ");
                    String movieSort = scanner.nextLine();
                    sortableService.sortMovieByName(movieSort);
                    break;

                case 9:
                    System.out.print("Sort by year (asc/desc): ");
                    String ascOrDeasc = scanner.nextLine();
                    sortableService.sortByYear(ascOrDeasc);
                    break;
                case 10:
                    System.out.print("Sort by producer (name/lastname): ");
                    String producerSort = scanner.nextLine();
                    sortableService.sortByProducer(producerSort);
                    break;
                case 11:
                    isTrue = false;
                    break;
                default:
                    System.out.println("Tuura emes");

            }
        }catch(InputMismatchException e){
            System.out.println("siftra jaz");

        }
    }
}
            }