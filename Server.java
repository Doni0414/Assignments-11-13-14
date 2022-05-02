package com.example.ex31_4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server extends Application {
    int numOfClients = 0;

    @Override
    public void start(Stage stage){
        TextArea ta = new TextArea();
        StackPane pane = new StackPane();
        pane.getChildren().add(ta);
        Scene scene = new Scene(pane,300,200);
        stage.setScene(scene);
        stage.show();
        new Thread(() -> {
            try{
                ServerSocket serverSocket = new ServerSocket(8000);

                Platform.runLater(() ->{
                    ta.appendText("Server started at "+new Date()+"\n");
                });

                while(true){
                    Socket socket = serverSocket.accept();
                    numOfClients++;
                    InetAddress address = socket.getInetAddress();

                    new Thread(() -> {
                        try {
                            DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
                            toClient.writeUTF("You are visitor: "+numOfClients);

                            Platform.runLater(() ->{
                                ta.appendText("Starting Thread "+(numOfClients-1)+"\n");
                                ta.appendText("Client IP "+address.getHostAddress()+"\n");
                            });

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();

                }
            }catch(IOException e){}
        }).start();



    }

    public static void main(String[] args) {
        launch();
    }
}