package ru.hm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homework4 extends JFrame {

    private JTextArea chatHistory;
    private JTextField message;

    public static void main(String[] args) {
        new Homework4().open();
    }

    private void open() {
        init();
        setVisible(true);
    }

    public void init() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(600,300, 300, 400);

        setLayout(new BorderLayout());

        chatHistory = new JTextArea();
        chatHistory.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatHistory);
        add(scrollPane, BorderLayout.CENTER);

        JPanel jPanel = new JPanel(new BorderLayout());
        add(jPanel, BorderLayout.SOUTH);

        message = new JTextField();
        message.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        jPanel.add(message, BorderLayout.CENTER);

        JButton jb = new JButton("Отправить");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        jPanel.add(jb, BorderLayout.EAST);
    }

    private void sendMessage() {
        if (message.getText().isEmpty()) {
        } else {
            chatHistory.append("User: " + message.getText() + System.lineSeparator());
            message.setText("");
        }
        message.grabFocus();
    }
}