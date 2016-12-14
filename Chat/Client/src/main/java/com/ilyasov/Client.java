package com.ilyasov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Chat {
    private final String CONNECTED = "Connected.\n";

    public void startWork() {
        createFrame();
        initializeServer();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        textArea.append(out.readLine() + '\n');
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        textArea.append(CONNECTED);
    }

    public void initializeServer() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8080);
            out = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            in = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.startWork();
    }
}
