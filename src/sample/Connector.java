package sample;

import javafx.scene.control.Control;
import sample.BMI;
import sample.Controller;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connector implements Runnable{
    String host = "localhost";
    int port = 1337;

    BMI bmi;
    Controller controller;

    public Connector(Controller controller, BMI bmi){
        this.controller = controller;
        this.bmi = bmi;
    }

    public void run() {


        try {
            Socket socket = new Socket(host, port);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            out.writeObject(bmi);
            out.flush();

            controller.bmiText.setText(String.valueOf(in.readDouble()));

        } catch(
                IOException e)

        {
            e.printStackTrace();
        }
    }

}

