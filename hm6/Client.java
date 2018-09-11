package ru.hm;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    private volatile static int CLIENTS_COUNT = 0;
    private String name;

    public Client(Socket socket) {
        try {
            this.socket = socket;
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new Scanner(socket.getInputStream());
            name = "Client #" + CLIENTS_COUNT;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (in.hasNext()) {
                String w = in.nextLine();
                if (w.equalsIgnoreCase("END")) break;

            }
        }
        try {
            System.out.println("Client disconnected");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }
}
