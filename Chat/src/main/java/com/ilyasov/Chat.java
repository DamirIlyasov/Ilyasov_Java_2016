package com.ilyasov;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

abstract class Chat {
    Socket socket;
    PrintWriter in;
    BufferedReader out;
    Frame frame;
    Button button;
    TextField textField;
    TextArea textArea;
    Thread thread;

    void createFrame() {
        frame = new Frame("Chat");
        frame.setLayout(new FlowLayout());
        frame.setBackground(Color.white);
        button = new Button("Send");
        button.setBackground(Color.white);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.append("Me:" + textField.getText() + '\n');
                in.println("User: " + textField.getText());
                textField.setText("");
            }
        });
        textField = new TextField(20);
        textArea = new TextArea(15, 25);
        textArea.setBackground(Color.white);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        frame.add(textField);
        frame.add(button);
        frame.add(textArea);
        frame.setSize(200, 200);
        frame.setLocation(300, 300);
        frame.setVisible(true);
        frame.validate();
    }
}
