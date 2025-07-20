import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    public Consumer<Socket> getConsumer(){
        return (clientSocket) -> {
            try {
                PrintWriter msgToClient = new PrintWriter(clientSocket.getOutputStream());
                msgToClient.println("Hello! I am your Server.");
                msgToClient.close();
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
    public static void main(String[] args) throws IOException{
        int port = 8010;
        Server server = new Server();
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        System.out.println("Server is listening on port : " + port);
        while (true) {
            Socket socketAccepted = socket.accept();
            Thread t = new Thread(()->server.getConsumer().accept(socketAccepted));
            t.start();
        }
    }
}
