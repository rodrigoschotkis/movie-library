public class Movie {
    private String title;
    private String director;
    private int year;
    private String genre;
    private int myRating;
    private boolean haveIWatched;

    public Movie(String title, String director, int year, String genre, int myRating, boolean haveIWatched) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.myRating = myRating;
        this.haveIWatched = haveIWatched;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDirector() {
        return this.director;
    }

    public int getYear() {
        return this.year;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getMyRating() {
        return this.myRating;
    }

    public boolean getHaveIWatched() {
        return this.haveIWatched;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setDirector(String newDirector) {
        this.director = newDirector;
    }

    public void setYear(int newYear) {
        this.year = newYear;
    }

    public void setGenre(String newGenre) {
        this.genre = newGenre;
    }

    public void setMyRating(int newMyRating) {
        this.myRating = newMyRating;
    }

    public void setHaveIWatched(boolean haveIWatched) {
        this.haveIWatched = haveIWatched;
    }

    @Override
    public String toString() {
            String watchedText = this.haveIWatched ? "Yes" : "No";
            return "Title: " + this.title +
                   "\nDirector: " + this.director +
                   "\nYear: " + this.year +
                   "\nGenre: " + this.genre +
                   "\nMy Rating: " + this.myRating +
                   "\nHave I watched?: " + watchedText;
    }
}
