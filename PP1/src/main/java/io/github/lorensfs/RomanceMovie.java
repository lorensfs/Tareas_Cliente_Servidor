package io.github.lorensfs;

/**
 * @author Lorenzo
 */
public class RomanceMovie extends BaseMovie {

  public RomanceMovie(String movie) {
    super("Romance", movie);
  }

  /**
   * Displays information about the movie, including its title and genre.
   * This method prints the movie's title and genre to the standard output.
   */
  @Override
  public void showInfoMovie() {
    System.out.println(
      "Movie: " + getMovie() + "\n" + "Genre: " + getGenre() + "\n"
    );
  }
}
