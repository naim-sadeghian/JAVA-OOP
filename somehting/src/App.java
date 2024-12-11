import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<MovieRecord> a = new ArrayList<>();
        
        a.add(new MovieRecord("Title1", "Horror", 4));
        a.add(new MovieRecord("Title2", "Drama", 5));
        a.add(new MovieRecord("Title3", "Drama", 8));
        a.add(new MovieRecord("Title4", "Horror", 10));

        
        // MovieRecord.sendMoviesToServer(a);
        GenreRatingAggregator ag1 = new GenreRatingAggregator("Drama", a);
        GenreRatingAggregator ag2 = new GenreRatingAggregator("Horror", a);
        
        Thread th1 = new Thread( ag1 );
        Thread th2 = new Thread( ag2 );
        th1.start();
        th2.start();

        try {
            th1.join(); // Wait for the thread to finish
            th2.join();
            // Thread has finished
        } catch (InterruptedException e) {
            System.out.println("Whoopsy");
        }

        System.out.println("Result for thread 1: "+ag1.getTotalRating());
        System.out.println("Result for thread 2: "+ag2.getTotalRating());

    }
}
