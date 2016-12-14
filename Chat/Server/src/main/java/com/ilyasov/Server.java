package com.ilyasov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class Server extends Chat {

    private ServerSocket serverSocket;
    private final String USER_CONNECTED = "User connected.You can communicate now!\n";
    private final String USER_DISCONNECTED = "User disconnected.\n";
    private final String NO_USERS_IN_THIS_CHAT = "No active users in this chat \n";

    private void startWork() {
        try {
            createFrame();
            serverSocket = new ServerSocket(8080);
            textArea.append(NO_USERS_IN_THIS_CHAT);
            initializeUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String text = out.readLine();
                        if (text != null) {
                            textArea.append(text + "\n");
                        } else {
                            textArea.append(USER_DISCONNECTED);
                            initializeUser();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    private void initializeUser() {
        try {
            socket = serverSocket.accept();
            textArea.append(USER_CONNECTED);
            out = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            in = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startWork();
    }
}
