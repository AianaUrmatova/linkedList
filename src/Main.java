import enums.Genre;
import models.Actor;
import models.Movie;
import models.Producer;
import service.impl.MovieServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
        new Movie("Insertion", LocalDate.of(2010, 1, 1), Genre.SCIFI,
                new Producer("Christopher", "Nolan"),
                Arrays.asList(new Actor("Leonardo DiCaprio", "Cobb"),
                        new Actor("Joseph Gordon-Levitt", "Arthur"))),

                new Movie("Interstellar", LocalDate.of(2014, 1, 1), Genre.SCIFI,
                        new Producer("Christopher", "Nolan"),
                        Arrays.asList(new Actor("Matthew McConaughey", "Cooper"),
                                new Actor("Anne Hathaway", "Brand"))),

                new Movie("The Godfather", LocalDate.of(1972, 1, 1), Genre.DRAMA,
                        new Producer("Francis", "Coppola"),
                        Arrays.asList(new Actor("Marlon Brando", "Vito Corleone"),
                                new Actor("Al Pacino", "Michael Corleone"))));


        MovieServiceImpl service = new MovieServiceImpl(movies);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=======❤️ MOVIE MENU ❤️=======");
            System.out.println("1 -> Show all movies");
            System.out.println("2 -> Find by full or part name");
            System.out.println("3 -> Find by actor name");
            System.out.println("4 -> Find by year");
            System.out.println("5 -> Find by producer full name");
            System.out.println("6 -> Find by genre");
            System.out.println("7 -> Find by role");
            System.out.println("8 -> Sort by movie name (asc/desc)");
            System.out.println("9 -> Sort by year (asc/desc)");
            System.out.println("10 -> Sort by producer (name/lastname)");
            System.out.println("0 -> Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    service.getAllMovies().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter movie name or part: ");
                    String name = scanner.nextLine();
                    System.out.println(service.findMovieByFullNameOrPartName(name));
                    break;
                case 3:
                    System.out.print("Enter actor name: ");
                    String actorName = scanner.nextLine();
                    System.out.println(service.findMovieByActorName(actorName));
                    break;
                case 4:
                    System.out.print("Enter year (yyyy): ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(service.findMovieByYear(LocalDate.of(year, 1, 1)));
                    break;
                case 5:
                    System.out.print("Enter producer full name: ");
                    String producerName = scanner.nextLine();
                    System.out.println(service.findMovieByProducer(producerName));
                    break;
                case 6:
                    System.out.print("Enter genre (ACTION, COMEDY, DRAMA");
                    String genreStr = scanner.nextLine().toUpperCase();
                    System.out.println(service.findMovieByGenre(Genre.valueOf(genreStr)));
                    break;
                case 7:
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();
                    System.out.println(service.findMovieByRole(role));
                    break;
                case 8:
                    System.out.print("Sort by name (asc/desc): ");
                    String sortName = scanner.nextLine();
                    service.sortMovieByName(sortName);
                    service.getAllMovies().forEach(System.out::println);
                    break;
                case 9:
                    System.out.print("Sort by year (asc/desc): ");
                    String sortYear = scanner.nextLine();
                    service.sortByYear(sortYear);
                    service.getAllMovies().forEach(System.out::println);
                    break;
                case 10:
                    System.out.print("Sort by producer (name/lastname): ");
                    String producerSort = scanner.nextLine();
                    service.sortByProducer(producerSort);
                    service.getAllMovies().forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");

            }
        }
    }
}