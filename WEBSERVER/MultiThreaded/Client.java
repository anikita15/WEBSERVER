import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public Runnable getRunnable(){
        return new Runnable() {
            @Override 
            public void run(){
                int port = 8010;
                try {
                    InetAddress address = InetAddress.getByName("LocalHost");
                    Socket socket = new Socket(address, port);
                    try(
                        PrintWriter msgToSocket = new PrintWriter(socket.getOutputStream(), true); 
                        BufferedReader msgFromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    ){
                        msgToSocket.println("Hello! I am your client");
                        String response = msgFromSocket.readLine();
                        System.out.println("Response from socket : " + response);
                    } catch(IOException e){
                        e.printStackTrace();
                    }

                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
    public static void main(String[] args) {
        Client client = new Client();
        for(int i=0; i<100; i++){
            try{
                Thread thread = new Thread(client.getRunnable());
                thread.start();
            }
            catch(Exception e){
                return;
            }
        }
    }
    
}
