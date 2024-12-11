import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MovieRecord{
    String title;
    String genre;
    int rating;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public MovieRecord(String title, String genre, int rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public String toCSV(){
        return title + "," +genre+","+rating;
    }

    public static MovieRecord fromCSV(String s){
        MovieRecord ans;
        String[] aux = s.split(",");
        try {
            ans = new MovieRecord(aux[0], aux[1], Integer.parseInt(aux[2]));
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            return null;
        }
        return ans;
    }   

    public static int sumRating(ArrayList<MovieRecord> a) {
        int ans = 0;
        for (MovieRecord r : a){
            ans += r.getRating();
        }
        return ans;
    }

    public static void sendMoviesToServer(ArrayList<MovieRecord> a){
        String serverAddress = "localhost"; // Replace with the server's IP if needed
        int port = 9000; // Port number

        try (Socket socket = new Socket(serverAddress, port);
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true)) {
            // Send the string
            for (MovieRecord r: a){
                writer.println(r.toCSV());
            }
            writer.println("QUIT");
            
            // System.out.println("Message sent to the server: " + message);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static ArrayList<MovieRecord> receiveMoviesFromClient(){
        int port = 9000; // Port to listen on
        ArrayList<MovieRecord> ans = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Accept incoming connections in a loop
            while (true) {
                Socket socket = serverSocket.accept(); // Accept a client connection
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String receivedMessage;
                while( !( receivedMessage = reader.readLine()).equals("QUIT") ){
                    MovieRecord aux = fromCSV( receivedMessage );
                    ans.add(aux);
                }
                // Close the client socket
                socket.close();
                break;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return ans;

    }

    public static Map<String, Integer> genreMap(ArrayList<MovieRecord> a){
        Map<String, Integer> map = new HashMap<>();
        for(MovieRecord r: a){
            int total = 0;
            if (map.containsKey(r.getGenre())){
                total = map.get( r.getGenre() );

            }
            map.put( r.getGenre(), total + r.getRating());
        }
        return map;
    }

    public PriorityQueue<MovieRecord> createQueue(ArrayList<MovieRecord> a){
        PriorityQueue<MovieRecord> q = new PriorityQueue<>( (x,y) -> x.getRating() - y.getRating() );

        for(MovieRecord r: a){
            q.add( r );
        }

        return q;
    }
}
