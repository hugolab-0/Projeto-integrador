package br.com.sp.jandira.senai.VagaCerta;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaDeInicio extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle(" Vaga Certa");



        // ------- ELEMENTOS DA PAGINA -------
        Label titulo = new Label("Bem-Vindo");
        Button botao1 = new Button("Iniciar");


        // ------- CAIXA HORIZONTAL (HBox) -------
        HBox caixaHorizontal = new HBox(10);  // espaçamento 10px
        caixaHorizontal.getChildren().addAll(botao1);

        // ------- CAIXA PRINCIPAL VERTICAL (VBox) -------
        VBox caixaPrincipal = new VBox(15); // espaçamento 15px
        caixaPrincipal.getChildren().addAll(titulo, caixaHorizontal);

        // ------- CRIAR A CENA -------
        Scene cena = new Scene(caixaPrincipal, 650, 350);

        // ------- MOSTRAR A JANELA -------
        stage.setScene(cena);
        stage.show();
    }
}
