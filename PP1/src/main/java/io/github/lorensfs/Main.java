package io.github.lorensfs;

import java.util.Scanner;

/**
 * @author Lorenzo
 */
public class Main {

  private static final MovieCatalog catalog = new MovieCatalog();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    catalog.addMovieToCatalog(new RomanceMovie("Tres Metros Sobre el Cielo"));
    catalog.addMovieToCatalog(new TerrorMovie("IT"));
    catalog.addMovieToCatalog(new RomanceMovie("Lalaland"));
    catalog.addMovieToCatalog(new TerrorMovie("The Ring"));

    MenuHandler menuHandler = new MenuHandler(scanner, catalog);
    menuHandler.start();
  }
}
