package ru.hm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private Client client;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        Socket s = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("Server created. Waiting for client...");
            s = server.accept();
            System.out.println("Client connected");
            client = new Client(s);
            new Thread(client).start();
            console();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                System.out.println("Server closed");
                if (s != null) s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void console() {
        Scanner s = new Scanner(System.in);

        while (true) {
            try {
                if (s.hasNext()) {
                    String message = s.nextLine();
                    String msg = "Server: " + message;
                    client.sendMessage(msg);
                    System.out.println(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
