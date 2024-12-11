import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerWorker extends Thread {
    DataInputStream inputStream;
    DataOutputStream outputStream;
    Socket socket;
    Scanner scanner;
    static int clientCounter = 0;

    public ServerWorker(Socket s) {
        clientCounter++;
        this.socket = s;
        try {
            this.inputStream = new DataInputStream( s.getInputStream() );
            this.outputStream = new DataOutputStream( s.getOutputStream() );
            this.scanner = new Scanner(System.in);
            this.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public void run(){
        String message, reply;
        System.out.println("Starting new connection for <<"+clientCounter+">>");
        while(true){
            try {
                message = inputStream.readUTF( );
                if (message.equals("QUIT")){
                    break;
                }  
                System.out.println( clientCounter+")Server recieved:" + message );
                System.out.print(clientCounter+")Enter a reply: ");
                reply = scanner.nextLine();

                outputStream.writeUTF( reply );

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } 

        }

        try {
            socket.close();
            // clientCounter--;
        } catch (IOException e) {
            System.out.println("Couldnt close socket");
        }
    }
}
