package Task_2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class Client {
    private static int number=new Random().nextInt(100);

    public static void main(String[] args) throws IOException {
        String clientName = "Client #" + number +" : ";
        Socket socket = new Socket(InetAddress.getLocalHost(), 7068); // указывается айпи-адрес сервера и номер порта
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream output = new PrintStream(socket.getOutputStream());
        try {
            new Thread(() -> {
                Scanner sc = new Scanner(System.in);
                while (!socket.isClosed()) {
                    String message = clientName + sc.nextLine();
                    output.println(message);
                    if(message.equals("stop")) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(() -> {
                while (!socket.isClosed()) {
                    try {
                        String message = input.readLine();
                        System.out.println(message);
                    } catch (IOException e) {
                        System.out.println("You have disconnected.");
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
