import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public void run() throws IOException{
        int port = 8010;  //open port
        InetAddress address = InetAddress.getByName("LocalHost");  //localaddress of client
        Socket socket = new Socket(address, port);   //socket between client and server port
        PrintWriter msgToSocket = new PrintWriter(socket.getOutputStream());  //input from client to server
        BufferedReader msgFromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));  //output from server to client
        msgToSocket.println("Hello! I am your client");
        //Reading response from socket
        String response = msgFromSocket.readLine();
        System.out.println("Response from socket : " + response);
        msgFromSocket.close();
        msgToSocket.close();
        socket.close();
    }
    public static void main(String[] args){
        try {
            Client client = new Client();
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

