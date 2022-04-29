package Task_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static ArrayList<SocketThread> socketThreads = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(7068)) {        // создаем серверный сокет
            System.out.println("Server started");
            while (true) {
                Socket socket = server.accept();            // принимаем соединение от клиента и ожидаем сообщения с помощью методa аccept()
                System.out.println(socket.getInetAddress().getHostName() + " connected");
                SocketThread socketThread = new SocketThread(socket);
                socketThreads.add(socketThread);
                socketThread.start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
