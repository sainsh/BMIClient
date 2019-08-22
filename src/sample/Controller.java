package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Controller {

    @FXML
    TextField weightText;
    @FXML
    TextField heightText;
    @FXML
    public TextField bmiText;



    public void sendOnClick(ActionEvent actionEvent) {

        BMI bmi = new BMI(Double.valueOf(heightText.getText().toString()),Double.valueOf(weightText.getText().toString()));

        (new Thread(new Connector(this,bmi))).start();



    }
}
