package br.com.sp.jandira.senai.VagaCerta;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaDeCadastro extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle(" Vaga Certa");

        // ------- ELEMENTOS PRICIPAIS DA PAGINA -------
        Button btnAddUser = new Button ("\uD83D\uDC64");
        Button btnExcluir = new Button("\uD83D\uDDD1");
        Button btnRegistro = new Button("\uD83D\uDCDC");
        Button btnSair = new Button("\uD83C\uDFC3\u200D");

        // ------- ELEMENTOS DA PAGINA -------
        Label nome = new Label("Nome do proprietário");
        nome.setStyle("-fx-font-size: 16px; -fx-font-family: 'Roboto'; -fx-text-fill: #ecdfd2");

       TextField campoNome = new TextField();
        campoNome.setStyle("-fx-background-color: #ecdfd2");
        campoNome.setPromptText("Nome");
        campoNome.setMaxWidth(200);
        campoNome.setPrefHeight(30);

        Label modelo = new Label("Modelo do veículo");
        modelo.setStyle("-fx-font-size: 20px; -fx-font-family: 'Roboto'; -fx-text-fill: #ecdfd2");

        TextField campoModelo = new TextField();
        campoModelo.setStyle("-fx-background-color: #ecdfd2");
        campoModelo.setPromptText("Modelo");
        campoModelo.setMaxWidth(200);
        campoModelo.setPrefHeight(30);

        Label placa = new Label("Placa do veículo");
        placa.setStyle("-fx-font-size: 20px; -fx-font-family: 'Roboto'; -fx-text-fill: #ecdfd2");

        TextField campoPlaca = new TextField();
        campoPlaca.setStyle("-fx-background-color: #ecdfd2");
        campoPlaca.setPromptText("Placa");
        campoPlaca.setMaxWidth(200);
        campoPlaca.setPrefHeight(30);

        Label cor = new Label("Cor do veículo");
        cor.setStyle("-fx-font-size: 20px; -fx-font-family: 'Roboto'; -fx-text-fill: #ecdfd2");

        TextField campoCor = new TextField();
        campoCor.setStyle("-fx-background-color: #ecdfd2");
        campoCor.setPromptText("Cor");
        campoCor.setMaxWidth(200);
        campoCor.setPrefHeight(30);

        Button btnRegistrar = new Button("Registrar");
        btnRegistrar.setStyle("-fx-background-color: red");
        btnRegistrar.setPadding(new Insets(15, 40, 15, 40));

        //--------- CRIAÇÃO DE COLETA DE INFORMAÇÕES ----------

        VBox caixaDeInformacoes = new VBox(10);
        caixaDeInformacoes.setStyle("-fx-background-color: #3f3242");
        VBox.setMargin(nome,new Insets(8, 0, 0, 10));
        VBox.setMargin( campoNome,new Insets(0, 0, 0, 10));
        caixaDeInformacoes.setPrefHeight(92);
        caixaDeInformacoes.setMaxWidth(300);
        caixaDeInformacoes.getChildren().addAll(nome, campoNome);

        VBox caixaDeInformacoesCar = new VBox(12);
        caixaDeInformacoesCar.setStyle("-fx-background-color: #322431");
        VBox.setMargin( modelo, new Insets(8, 0, 0, 10));
        VBox.setMargin( placa, new Insets(8, 0, 0, 10));
        VBox.setMargin( cor, new Insets(8, 0, 0, 10));
        VBox.setMargin( campoModelo,new Insets(0, 0, 0, 10));
        VBox.setMargin( campoPlaca,new Insets(0, 0, 0, 10));
        VBox.setMargin( campoCor,new Insets(0, 0, 0, 10));
        caixaDeInformacoesCar.setPrefHeight(325);
        caixaDeInformacoesCar.setMaxWidth(350);
        caixaDeInformacoesCar.getChildren().addAll(modelo, campoModelo, placa, campoPlaca, cor, campoCor);


        // ------------- AJUSTE NOS ELEMENTOS --------

        String buttonStyle = "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0";
        btnAddUser.setStyle(buttonStyle);
        btnExcluir.setStyle(buttonStyle);
        btnRegistro.setStyle(buttonStyle);
        btnSair.setStyle(buttonStyle);

        btnAddUser.setOnAction(e -> {
            btnAddUser.setStyle( "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #FFB800; -fx-border-color: #FFB800");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
        });
        btnExcluir.setOnAction(e -> {
            btnAddUser.setStyle( "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #FFB800; -fx-border-color: #FFB800");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
        });
        btnRegistro.setOnAction(e -> {
            btnAddUser.setStyle( "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #FFB800; -fx-border-color: #FFB800");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
        });
        btnSair.setOnAction(e -> {
            btnAddUser.setStyle( "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #FFB800; -fx-border-color: #FFB800");
        });


        // ------- CAIXA PRINCIPAL HORIZONTAL (HBox) -------
        HBox caixaHorizontal = new HBox(15);
        HBox.setMargin(btnRegistrar, new Insets(20, 20, 20, 20));
        caixaHorizontal.setPadding(new Insets(12));
        caixaHorizontal.getChildren().addAll(btnAddUser, btnExcluir, btnRegistro, btnSair, btnRegistrar);

        // ------- CAIXA PRINCIPAL VERTICAL (VBox) -------
        VBox caixaPrincipal = new VBox(15);
        caixaPrincipal.setStyle("-fx-background-color: #49414B");
        VBox.setMargin(caixaDeInformacoes, new Insets(20, 0, 0, 35));
        VBox.setMargin(caixaDeInformacoesCar, new Insets(10, 0, 0, 35));

        caixaPrincipal.getChildren().addAll(caixaHorizontal, caixaDeInformacoes, caixaDeInformacoesCar);

        // -------- CRIANDO CONTAINER -----------

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #323031");
        root.setPadding(new Insets(20));
        root.getChildren().addAll(caixaPrincipal);


        // ------- CRIAR A CENA -------
        Scene cena = new Scene(root, 850, 650);

        // ------- MOSTRAR A JANELA -------
        stage.setScene(cena);
        stage.show();
    }
}

