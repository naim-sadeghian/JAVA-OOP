import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws Exception {
        ArrayList<MovieRecord> a = MovieRecord.receiveMoviesFromClient();
        for(MovieRecord r: a){
            System.out.println(r.toCSV());
        }
    }
}
