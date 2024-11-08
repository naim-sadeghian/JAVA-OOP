
import java.util.Comparator;

public class SortByYear implements Comparator<Movie>{
    @Override
    public int compare(Movie m1, Movie m2) {
        return m1.getYear() - m2.getYear();
    }
}
