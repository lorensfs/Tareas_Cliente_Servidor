package io.github.lorensfs;

/**
 * @author Lorenzo
 */
public abstract class BaseMovie implements Movies {

  private String Movie;
  private String Genre;

  public BaseMovie(String genre, String movie) {
    this.Genre = genre;
    this.Movie = movie;
  }

  public String getMovie() {
    return this.Movie;
  }

  public String getGenre() {
    return this.Genre;
  }

  public abstract void showInfoMovie();
}
