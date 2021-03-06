package ru.hm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HomeWork6 extends JFrame {

    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private JTextField jtf;
    private JTextArea jta;

    private Socket sock;
    private Scanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new HomeWork6().setVisible(true);
    }

    public HomeWork6() {
        init();
        Network();
    }

    private void Network() {
        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new Scanner(sock.getInputStream());
            out = new PrintWriter(sock.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (in.hasNext()) {
                            String w = in.nextLine();
                            if (w.equalsIgnoreCase("end session")) break;
                            jta.append(w + System.lineSeparator());
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                Scanner s = new Scanner(System.in);

                while (true) {
                    try {
                        if (s.hasNext()) sendMsg(s.nextLine());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void init() {
        setBounds(500, 300, 400, 300);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSend = new JButton("SEND");
        bottomPanel.add(jbSend, BorderLayout.EAST);
        jtf = new JTextField();
        bottomPanel.add(jtf, BorderLayout.CENTER);

        jbSend.addActionListener(e -> sendMsg());
        jtf.addActionListener(e -> sendMsg());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                super.windowClosing(event);
                try {
                    out.println("end");
                    sock.close();
                    out.close();
                    in.close();
                } catch (IOException e) {
                }
            }
        });
    }

    private void sendMsg() {
        String msg = jtf.getText();
        sendMsg(msg);
        jtf.setText("");
        jtf.grabFocus();
    }

    private void sendMsg(String msg) {
        if (!msg.trim().isEmpty()) {
            out.println(msg);
            jta.append("Me: " + msg + System.lineSeparator());
        }
    }
}