import java.util.Scanner;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        MovieLibrary myLibrary = new MovieLibrary();
        Scanner scan = new Scanner(System.in);
        int menu = 0;
        String menuText = """
                 \n=== MOVIE LIBRARY ===
                 1. Add a movie
                 2. Remove a movie
                 3. List all movies
                 4. Mark as watched
                 5. Search/filter movies
                 6. Quit
                 Choose an option:\s""";

        do {
            System.out.print(menuText);
            if (scan.hasNextInt()) {
                menu = scan.nextInt();
                scan.nextLine();
            } else {
                System.out.println("Please enter an integer.");
                scan.nextLine();
                continue;
            }

            switch (menu) {
                case 1:
                    System.out.println("\nOption selected: 1. Add a movie");
                    int currentYear = Year.now().getValue();

                    String title;
                    String director;
                    String genre;
                    int year;
                    int rating = -1;
                    boolean haveWatched;

                    while (true) {
                        System.out.print("Type the Movie's title: ");
                        title = scan.nextLine();
                        if (!title.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Title can't be empty.");
                    }

                    do {
                        System.out.print("Type the Director's name: ");
                        director = scan.nextLine();
                        if (director.trim().isEmpty()) {
                            System.out.println("The director's name can't be empty.");
                            continue;
                        }
                        if (director.matches(".*\\d.*")) {
                            System.out.println("No numbers allowed.");
                            continue;
                        }
                        break;
                    } while (true);

                    do {
                        System.out.print("Type the Genre of the movie: ");
                        genre = scan.nextLine();
                        if (genre.trim().isEmpty()) {
                            System.out.println("The genre's name can't be empty.");
                            continue;
                        }
                        if (genre.matches(".*\\d.*")) {
                            System.out.println("No numbers allowed.");
                            continue;
                        }
                        break;
                    } while (true);

                    while (true) {
                        System.out.print("Enter the year of the movie: ");
                        String input = scan.nextLine();
                        try {
                            year = Integer.parseInt(input);
                            if (year < 1888 || year > currentYear) {
                                System.out.println("Type a year between " + 1888 + " and " + currentYear + ".");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("That's not a valid number.");
                        }
                    }

                    do {
                        System.out.print("Have you watched the movie? ");
                        String text = scan.nextLine();
                        if (text.equalsIgnoreCase("yes") || text.equalsIgnoreCase("y")) {
                            haveWatched = true;
                            break;
                        }
                        if (text.equalsIgnoreCase("no") || text.equalsIgnoreCase("n")) {
                            haveWatched = false;
                            rating = 0;
                            break;
                        }
                        System.out.println("Please type yes/no or y/n (case insensitive).");
                    } while (true);

                    while (rating != 0) {
                        System.out.print("How do you rate the movie? (1 to 10): ");
                        String input = scan.nextLine();
                        try {
                            rating = Integer.parseInt(input);
                            if (rating < 1 || rating > 10) {
                                System.out.println("Rate it between 1 and 10.");
                                if (rating == 0) {
                                    rating = 11; // so it doesn't move on from the loop
                                }
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("That's not a valid number.");
                        }
                    }

                    Movie m = new Movie(title, director, year, genre, rating, haveWatched);
                    myLibrary.addMovie(m);
                    System.out.println(title + " successfully added to your list.");

                    break;
                case 2:
                    if (myLibrary.isEmpty()) {
                        System.out.println("\nYou don't have any films added to your list.");
                        break;
                    }

                    String titleMovie;

                    System.out.println("\nOption selected: 2. Remove a movie");
                    System.out.println("\n--- YOUR MOVIES ---");
                    myLibrary.listAllOnlyTitles();

                    System.out.print("\nEnter the title of the film you'd like to remove: ");
                    titleMovie = scan.nextLine();
                    if (myLibrary.removeMovie(titleMovie)) {
                        System.out.println(titleMovie + " was successfully removed.");
                    } else {
                        System.out.println("No movie with the title " + titleMovie + " was found.");
                    }

                    break;
                case 3:
                    if (myLibrary.isEmpty()) {
                        System.out.println("\nYou don't have any films added to your list.");
                        break;
                    }
                    System.out.println();
                    System.out.println("--- YOUR MOVIES ---");
                    myLibrary.listAll();
                    break;
                case 4:
                    if (myLibrary.isEmpty()) {
                        System.out.println("\nYou don't have any films added to your list.");
                        break;
                    }

                    String titleMov;
                    boolean added = false;

                    System.out.println("\n--- YOUR MOVIES ---");
                    myLibrary.listAllOnlyTitles();

                    System.out.print("\nEnter the title of the film you'd like to mark as watched: ");
                    titleMov = scan.nextLine();
                    if (myLibrary.markAsWatched(titleMov)) {
                        System.out.println(titleMov + " was successfully marked as watched.");
                        added = true;
                    }

                    if (!added) {
                        break;
                    }

                    int ratingMov;
                    while (true) {
                        System.out.print("How do you rate the movie? (1 to 10): ");
                        String input = scan.nextLine();
                        try {
                            ratingMov = Integer.parseInt(input);
                            if (ratingMov < 1 || ratingMov > 10) {
                                System.out.println("Rate it between 1 and 10.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("That's not a valid number.");
                        }
                    }

                    myLibrary.rateMovie(titleMov, ratingMov);

                    break;
                case 5:
                    if (myLibrary.isEmpty()) {
                        System.out.println("\nYou don't have any films added to your list.");
                        break;
                    }

                    filterMenu(scan, myLibrary);
                    break;
                case 6:
                    System.out.println("Program finished.");
                    break;
                default:
                    System.out.println("Type a number between 1 and 6.");
            }
        } while (menu != 6);
    }

    public static void filterMenu(Scanner scan, MovieLibrary myLibrary) {
        int menu = 0;
        String menuText = """
                 How would you like to search/filter?
                 1. Search by director
                 2. Search by genre
                 3. Filter by minimum rating
                 4. Filter by year
                 5. Show movies watched
                 6. Show movies not watched
                 7. Return to menu
                 Choose an option:\s""";

        do {
            System.out.print(menuText);
            if (scan.hasNextInt()) {
                menu = scan.nextInt();
                scan.nextLine();
            } else {
                System.out.println("Please enter an integer.");
                scan.nextLine();
                continue;
            }

            switch (menu) {
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    System.out.println("\n--- MOVIES WATCHED ---");
                    myLibrary.showWatched();
                    System.out.println();
                    break;
                }
                case 6: {
                    System.out.println("\n--- MOVIES NOT WATCHED ---");
                    myLibrary.showUnwatched();
                    System.out.println();
                    break;
                }
                case 7: {
                    break;
                }
                default:
                    System.out.println("Type a number between 1 and 7.");
            }
        } while (menu != 7);
    }
}