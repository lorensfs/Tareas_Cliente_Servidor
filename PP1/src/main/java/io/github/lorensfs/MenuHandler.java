package io.github.lorensfs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class handles the menu operations for the Movie Catalog application.
 * It interacts with the user to provide options for searching movies by genre,
 * viewing movie details, and exiting the application.
 *
 * @author Lorenzo
 */
public class MenuHandler {

  private final Scanner scanner;
  private final MovieCatalog catalog;

  /**
   * Constructs a MenuHandler with the specified Scanner and MovieCatalog.
   *
   * @param scanner the Scanner object to read user input
   * @param catalog the MovieCatalog object that contains the movie data
   */
  public MenuHandler(Scanner scanner, MovieCatalog catalog) {
    this.scanner = scanner;
    this.catalog = catalog;
  }

  /**
   * Starts the menu loop, displaying options to the user and handling their input.
   * This method runs indefinitely until the user chooses to exit.
   */
  public void start() {
    while (true) {
      System.out.println("\n=== Netflix Movie Catalog ===");
      System.out.println("1. Search Movies by Genre");
      System.out.println("2. Exit\n");

      int input = getUserInput();
      scanner.nextLine();

      switch (input) {
        case 1:
          handleSearchMoviesByGenre();
          break;
        case 2:
          System.exit(0);
          break;
      }
    }
  }

  /**
   * Handles the process of searching movies by genre. If matching movies are found,
   * allows the user to view movie details or return to the main menu.
   */
  private void handleSearchMoviesByGenre() {
    MovieCatalog temp = catalog.searchMoviesByGenre(scanner);

    if (!temp.getMovie().isEmpty()) {
      boolean continueLoop = true;

      while (continueLoop) {
        System.out.println("1. View Movie Details by Index");
        System.out.println("2. Return");

        int input = getUserInput();
        scanner.nextLine();

        switch (input) {
          case 1:
            temp.askInfo(scanner, temp);
            break;
          case 2:
            continueLoop = false;
            break;
        }
      }
    }
  }

  /**
   * Prompts the user to enter an integer input for menu selection, ensuring the input is valid.
   * The valid input is an integer between 1 and 2.
   *
   * @return the valid integer input from the user
   */

  private int getUserInput() {
    int input = 0;
    boolean validInput = false;

    while (!validInput) {
      try {
        System.out.print("Enter an integer selecting the option: ");
        input = scanner.nextInt();
        if (input >= 1 && input <= 2) {
          validInput = true;
        } else {
          System.out.println(
            "Invalid input. Please enter a valid integer between " +
            1 +
            " and " +
            2 +
            "."
          );
        }
      } catch (InputMismatchException e) {
        System.out.println(
          "Invalid input. Please enter a valid integer between " +
          1 +
          " and " +
          2 +
          "."
        );
        scanner.nextLine();
      }
    }

    return input;
  }
}
