import java.util.ArrayList;

public class GenreRatingAggregator implements Runnable{
    ArrayList<MovieRecord> movieList;
    String genre;
    int totalRating;

    public GenreRatingAggregator(String genre, ArrayList<MovieRecord> movieList) {
        this.genre = genre;
        this.movieList = movieList;
        this.totalRating = 0;
    }

    public int getTotalRating(){
        return totalRating;
    }

    @Override
    public void run() {
        totalRating = MovieRecord.genreMap(movieList).get(genre);
    }

}
