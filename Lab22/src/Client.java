import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket clientSocket = null;
        int port = 8011;
        String address = "localhost";
        if (args.length == 2) {
            address = args[0];
            port = Integer.parseInt(args[1]);
        }
        try {
            clientSocket = new Socket("localhost", 8011);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(clientSocket.getOutputStream())));
            Scanner scanner = new Scanner(System.in);
            String outMessage = "Hello from the client";
            String inMessage;
            out.println(outMessage);
            out.flush();
            inMessage = in.readLine();
            while(!inMessage.equals("QUIT")) {
                outMessage = scanner.nextLine();
                // Write message to the server
                out.println(outMessage);
                out.flush();

                if(inMessage.equals("QUIT")){
                    break;
                }

                // Read message from the server
                inMessage = in.readLine();
                System.out.println(inMessage);
            }
            System.out.println(inMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
