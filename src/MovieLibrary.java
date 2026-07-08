import java.util.ArrayList;

public class MovieLibrary {
    private ArrayList<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(String title) {
        for (Movie m: movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                movies.remove(m);
                return;
            }
        }
    }

    public void listAll() {
        for (Movie m : movies) {
            System.out.println(m);
            System.out.println();
        }
    }

    public void markAsWatched(String title) {
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                m.setHaveIWatched(true);
                return;
            }
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
}
