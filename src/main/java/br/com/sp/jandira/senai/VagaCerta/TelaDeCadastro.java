
package br.com.sp.jandira.senai.VagaCerta;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority; // Importante para o Priority.ALWAYS
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;

public class TelaDeCadastro extends Application {


    @Override
    public void start (Stage stage){
        stage.setTitle(" Vaga Certa");
        String caminhoArquivo = "src/main/data/veiculo_estacionados.csv";
        String caminhoHistorico = "src/main/data/historico_do_estacionamento.csv";





        // ------- ELEMENTOS PRICIPAIS DA PAGINA -------
        Button btnAddUser = new Button("\uD83D\uDC64");
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
        btnRegistrar.setStyle("-fx-background-color: #3f3242; -fx-text-fill: #ecdfd2; -fx-font-size: 20px");
        btnRegistrar.setPadding(new Insets(10, 30, 10, 30));

        Button btnLimpar = new Button("Limpar");
        btnLimpar.setStyle("-fx-background-color: #3f3242; -fx-text-fill: #ecdfd2; -fx-font-size: 20px");
        btnLimpar.setPadding(new Insets(10, 40, 10, 40));

        //--------- CRIAÇÃO DE COLETA DE INFORMAÇÕES (VBOX) ----------

        VBox caixaDeInformacoes = new VBox(10);
        caixaDeInformacoes.setStyle("-fx-background-color: #3f3242");
        VBox.setMargin(nome, new Insets(8, 0, 0, 10));
        VBox.setMargin(campoNome, new Insets(0, 0, 10, 10));
        caixaDeInformacoes.setPrefHeight(80);
        caixaDeInformacoes.setMaxWidth(390);
        caixaDeInformacoes.getChildren().addAll(nome, campoNome);

        VBox caixaDeInformacoesCar = new VBox(12);
        caixaDeInformacoesCar.setStyle("-fx-background-color: #322431");
        VBox.setMargin(modelo, new Insets(8, 0, 0, 10));
        VBox.setMargin(placa, new Insets(8, 0, 0, 10));
        VBox.setMargin(cor, new Insets(8, 0, 0, 10));
        VBox.setMargin(campoModelo, new Insets(0, 0, 0, 10));
        VBox.setMargin(campoPlaca, new Insets(0, 0, 0, 10));
        VBox.setMargin(campoCor, new Insets(0, 0, 0, 10));
        caixaDeInformacoesCar.setPrefHeight(300);
        caixaDeInformacoesCar.setMaxWidth(405);
        caixaDeInformacoesCar.getChildren().addAll(modelo, campoModelo, placa, campoPlaca, cor, campoCor);

        // Caixa de Botões
        VBox caixaDeBotoes = new VBox(12);
        caixaDeBotoes.setAlignment(Pos.CENTER);
        caixaDeBotoes.setPadding(new Insets(20));
        caixaDeBotoes.setMaxWidth(300);
        caixaDeBotoes.setMaxHeight(300);
        caixaDeBotoes.getChildren().addAll(btnRegistrar, btnLimpar);


        // ------------- AJUSTE NOS ELEMENTOS (Estilos de Botão) --------

        String buttonStyle = "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0";
        btnAddUser.setStyle(buttonStyle);
        btnExcluir.setStyle(buttonStyle);
        btnRegistro.setStyle(buttonStyle);
        btnSair.setStyle(buttonStyle);

        btnAddUser.setOnAction(e -> {
            btnAddUser.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #88ff00; -fx-border-color: #88ff00");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
        });
        btnExcluir.setOnAction(e -> {
            btnAddUser.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill:  #88ff00; -fx-border-color: #88ff00");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
        });
        btnRegistro.setOnAction(e -> {
            btnAddUser.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill:  #88ff00; -fx-border-color: #88ff00");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
        });
        btnSair.setOnAction(e -> {
            btnAddUser.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill:  #88ff00; -fx-border-color: #88ff00");
        });

        btnRegistrar.setOnAction(e -> {
            btnRegistrar.setStyle("-fx-background-color: #3f3242; -fx-text-fill: #ecdfd2; -fx-font-size: 20px;  -fx-border-color: #88ff00; -fx-text-fill:  #88ff00");
            btnRegistrar.setPadding(new Insets(10, 30, 10, 30));
            btnLimpar.setStyle("-fx-background-color: #3f3242; -fx-text-fill: #ecdfd2; -fx-font-size: 20px");
            btnLimpar.setPadding(new Insets(10, 40, 10, 40));
        });
        btnLimpar.setOnAction(e -> {
            btnRegistrar.setStyle("-fx-background-color: #3f3242; -fx-text-fill: #ecdfd2; -fx-font-size: 20px");
            btnRegistrar.setPadding(new Insets(10, 30, 10, 30));
            btnLimpar.setStyle("-fx-background-color: #3f3242; -fx-text-fill: #ecdfd2; -fx-font-size: 20px;  -fx-border-color: rgb(213,19,19); -fx-text-fill:  rgb(197,22,22)");
            btnLimpar.setPadding(new Insets(10, 40, 10, 40));

        });


        // ------- CAIXA SUPERIOR HORIZONTAL (HBox) -------
        HBox caixaHorizontal = new HBox(15);
        caixaHorizontal.setPadding(new Insets(12));
        caixaHorizontal.getChildren().addAll(btnAddUser, btnExcluir, btnRegistro, btnSair);


        // NOVO CONTAINER HORIZONTAL DE CONTEÚDO (Para colocar a caixa de botões à direita)
        VBox colunaDeInformacoes = new VBox(15);
        colunaDeInformacoes.getChildren().addAll(caixaDeInformacoes, caixaDeInformacoesCar);


        HBox conteudoHorizontal = new HBox(30);
        conteudoHorizontal.setPadding(new Insets(10, 35, 10, 35));
        // FORÇA A COLUNA DE INFORMAÇÕES A CRESCER HORIZONTALMENTE
        // Isso garante que ela ocupe todo o espaço na esquerda
        HBox.setHgrow(colunaDeInformacoes, Priority.ALWAYS);
        conteudoHorizontal.getChildren().addAll(colunaDeInformacoes, caixaDeBotoes);

        // ------- CAIXA PRINCIPAL VERTICAL (VBox) -------
        VBox caixaPrincipal = new VBox(15);
        caixaPrincipal.setStyle("-fx-background-color: #49414B");
        caixaPrincipal.getChildren().addAll(caixaHorizontal, conteudoHorizontal);

        // -------- CRIANDO CONTAINER (StackPane) -----------
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