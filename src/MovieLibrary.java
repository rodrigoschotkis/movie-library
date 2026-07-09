import java.util.ArrayList;
import java.util.Comparator;

public class MovieLibrary {
    private ArrayList<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public boolean removeMovie(String title) {
        for (Movie m: movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                movies.remove(m);
                return true;
            }
        }
        return false;
    }

    public void listAll() {
        int num = 1;
        for (Movie m : movies) {
            System.out.println("Movie " + num);
            System.out.println(m);
            System.out.println();
            num++;
        }
    }

    public void listAllOnlyTitles() {
        int num = 1;
        for (Movie m : movies) {
            System.out.print(num + ". ");
            System.out.println(m.getTitle());
            num++;
        }
    }

    public boolean isEmpty() {
        return movies.isEmpty();
    }

    public boolean markAsWatched(String title) {
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                if (!m.getHaveIWatched()) {
                    m.setHaveIWatched(true);
                    return true;
                } else {
                    System.out.println("The film "+ m.getTitle() +" is already listed as watched.");
                    return false;
                }
            }
        }

        System.out.println("No movie with the title " + title + " was found.");
        return false;
    }

    public void showWatched() {
        boolean found = false;
        for (Movie m : movies) {
            if (m.getHaveIWatched()) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("You haven't watched any films yet.");
        }
    }

    public void showUnwatched() {
        boolean found = false;
        for (Movie m : movies) {
            if (!m.getHaveIWatched()) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("You've watched all your films!");
        }
    }

    public void searchByGenre(String genre) {
        boolean found = false;
        for (Movie m : movies) {
            if (m.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movies found in genre: " + genre);
        }
    }

    public void searchByDirector(String director) {
        boolean found = false;
        for (Movie m : movies) {
            if (m.getDirector().equalsIgnoreCase(director)) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movies found by director: " + director);
        }
    }

    public void filterByMinimumRating(int rating) {
        boolean found = false;
        for (Movie m : movies) {
            if (m.getMyRating() >= rating) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movies found rated " + rating + " or higher.");
        }
    }

    public void filterByYear(int minYear, int maxYear) {
        boolean found = false;
        for (Movie m : movies) {
            if (m.getYear() >= minYear && m.getYear() <= maxYear) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movies found between " + minYear + " and " + maxYear);
        }
    }

    public void sortByRating() {
        ArrayList<Movie> sorted = new ArrayList<>(movies);
        sorted.sort(Comparator.comparingInt(Movie::getMyRating).reversed());
        for (Movie m : sorted) {
            System.out.println(m);
        }
    }

    public void sortByYear() {
        ArrayList<Movie> sorted = new ArrayList<>(movies);
        sorted.sort(Comparator.comparingInt(Movie::getYear));
        for (Movie m : sorted) {
            System.out.println(m);
        }
    }
}
