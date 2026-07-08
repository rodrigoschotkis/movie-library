public class Main {
    public static void main(String[] args) {
        MovieLibrary myLibrary = new MovieLibrary();

        Movie movie1 = new Movie("title", "director", 2000, "Drama", 7, true);
        Movie movie2 = new Movie("title", "director", 2000, "Drama", 7, true);
        Movie movie3 = new Movie("title", "director", 2000, "Drama", 7, true);

        myLibrary.addMovie(movie1);
        myLibrary.addMovie(movie2);
        myLibrary.addMovie(movie3);

        myLibrary.listAll();
    }
}