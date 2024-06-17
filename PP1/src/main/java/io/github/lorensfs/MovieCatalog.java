package io.github.lorensfs;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents a catalog of movies. It provides functionality
 * to add movies to the catalog, search for movies by genre, and display
 * information about a specific movie.
 *
 * @author Lorenzo
 */
public final class MovieCatalog {

  private final List<Movies> movie = new ArrayList<>();

  public MovieCatalog() {}

  public List<Movies> getMovie() {
    return movie;
  }

  /**
   * Adds a new movie to the catalog.
   *
   * @param movie The movie to add to the catalog.
   */
  public void addMovieToCatalog(Movies movie) {
    this.movie.add(movie);
  }

  /**
   * Searches for movies in the catalog by genre.
   *
   * @param scanner A Scanner object to read user input
   * @return a MovieCatalog containing the movies that match the specified genre
   */
  public MovieCatalog searchMoviesByGenre(Scanner scanner) {
    MovieCatalog result = new MovieCatalog();
    System.out.println("Type genre of movies you are looking for: ");
    String genre = scanner.nextLine();
    for (Movies movies : this.movie) {
      if (movies.getGenre().equalsIgnoreCase(genre)) {
        result.getMovie().add(movies);
      }
    }
    System.out.println(result);
    return result;
  }

  /**
   * Displays information about a specific movie from a list of movies.
   *
   * @param number The index of the movie to display information about
   * @param movie The list of movies to choose from
   * @throws IllegalArgumentException if the index is out of bounds
   */
  private void infoMovie(int number, List<Movies> movie)
    throws IllegalArgumentException {
    if (!movie.isEmpty()) {
      if (!(number >= 1 && number <= movie.size())) {
        throw new IllegalArgumentException(
          "Index have to be between 1 and " + movie.size()
        );
      }
      movie.get(number - 1).showInfoMovie();
    } else {
      System.out.println("Catalog is empty");
    }
  }

  /**
   * Asks the user for the index of a movie and displays information about that movie.
   *
   * @param scanner A Scanner object to read user input
   * @param result A MovieCatalog containing the movies to choose from
   */
  public void askInfo(Scanner scanner, MovieCatalog result) {
    System.out.println(
      "Type the index of the movie you want to display info: "
    );
    try {
      int number = scanner.nextInt();
      scanner.nextLine();
      infoMovie(number, result.getMovie());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      askInfo(scanner, result);
    } catch (InputMismatchException e) {
      System.out.println("Input has to be an int value");
      scanner.nextLine();
      askInfo(scanner, result);
    }
  }

  @Override
  public String toString() {
    StringBuilder moviesCatalogByGenre = new StringBuilder();
    int index = 1;
    for (Movies movie : this.movie) {
      moviesCatalogByGenre
        .append(index)
        .append("- ")
        .append(movie.getMovie())
        .append("\n");
      index++;
    }
    if (index == 1) {
      moviesCatalogByGenre.append(
        "There isn't any matches or the catalog is empty\n"
      );
    }
    return moviesCatalogByGenre.toString();
  }
}
