package br.com.sp.jandira.senai.VagaCerta;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaDeInicio extends Application {

    Label label = new Label();

    @Override
    public void start(Stage stage) {

        stage.setTitle(" Vaga Certa");
        Scene scene = new Scene(label, 400, 400);

        Label titulo = new Label("Vaga Certa");

        stage.getScene();

        stage.show();
    }
}
