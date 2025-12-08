package br.com.sp.jandira.senai.VagaCerta;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaDeSaida {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
