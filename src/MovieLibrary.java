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
}
