import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieLibrary myLibrary = new MovieLibrary();
        Scanner scan = new Scanner(System.in);
        int menu = 0;
        String menuText = """
                 === MOVIE LIBRARY ===
                 1. Add a movie
                 2. Remove a movie
                 3. List all movies
                 4. Mark as watched
                 5. Search by genre
                 6. Quit
                 Choose an option:\s""";

        do {
            System.out.println(menuText);
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Type a number between 1 and 6.");
            }
        } while (menu != 6);

    }
}