package br.com.sp.jandira.senai.VagaCerta;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
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
        Button btnAddUser = new Button ("\uD83D\uDC64");
        Button btnExcluir = new Button("\uD83D\uDDD1");
        Button btnRegistro = new Button("\uD83D\uDCDC");
        Button btnSair = new Button("\uD83C\uDFC3\u200D");
        Label titulo = new Label("BEM-VINDO");

        // ------------- AJUSTE NOS ELEMENTOS --------

        titulo.setStyle("-fx-font-size: 40px");

        btnAddUser.setStyle("-fx-text-alignment: center; -fx-font-size: 35px;");
        btnExcluir.setStyle("-fx-text-alignment: center; -fx-font-size: 35px;");
        btnRegistro.setStyle("-fx-text-alignment: center; -fx-font-size: 35px;");
        btnSair.setStyle("-fx-text-alignment: center; -fx-font-size: 35px;");

        // ------- CAIXA PRINCIPAL HORIZONTAL (HBox) -------
        HBox caixaHorizontal = new HBox();
        caixaHorizontal.setPadding(new Insets(12));
        caixaHorizontal.getChildren().addAll(btnAddUser, btnExcluir, btnRegistro, btnSair);

        // ------- CAIXA PRINCIPAL VERTICAL (VBox) -------
        VBox caixaPrincipal = new VBox(15);
        caixaPrincipal.setStyle("-fx-gap-start-and-end: 10px, 20px, 10px");
        caixaPrincipal.getChildren().addAll(caixaHorizontal);

        // -------- CRIANDO CONTAINER -----------
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: pink");
        root.setPadding(new Insets(20));
        root.getChildren().addAll(caixaPrincipal, titulo);


        // ------- CRIAR A CENA -------
        Scene cena = new Scene(root, 650, 550);

        // ------- MOSTRAR A JANELA -------
        stage.setScene(cena);
        stage.show();
    }
}
