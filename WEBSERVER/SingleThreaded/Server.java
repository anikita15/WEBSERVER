import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public void run() throws IOException{
        int port = 8010;  //Open port
        ServerSocket socket = new ServerSocket(port);  //socket declaration 
        socket.setSoTimeout(10000);  //set timer so that socket is free after every interval
        while(true){
            System.out.println("Server is listening on port : " + port);
            Socket connectionAccepted = socket.accept();  //Establish connection 
            System.out.println("Connection established from client " + connectionAccepted.getRemoteSocketAddress());
            PrintWriter msgToClient = new PrintWriter(connectionAccepted.getOutputStream());   //output for client from server
            BufferedReader msgFromClient = new BufferedReader(new InputStreamReader(connectionAccepted.getInputStream()));
            msgToClient.println("Hello! Welcome to the Server.");   //input for server from client
            msgFromClient.close();
            msgToClient.close();
            connectionAccepted.close();
        }
    }
    public static void main(String[] args){
        Server server = new Server();  //Constructor
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
