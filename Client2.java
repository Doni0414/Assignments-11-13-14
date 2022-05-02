package com.example.ex31_4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.net.Socket;

public class Client2 extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Socket socket = new Socket("localhost",8000);

        DataInputStream fromServer = new DataInputStream(socket.getInputStream());

        String str = fromServer.readUTF();

        StackPane pane = new StackPane();
        pane.getChildren().add(new Label(str));

        Scene scene = new Scene(pane,300,200);
        stage.setScene(scene);
        stage.show();

    }
}
