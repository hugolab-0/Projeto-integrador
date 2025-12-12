package br.com.sp.jandira.senai.VagaCerta;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

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

        titulo.setStyle("-fx-font-size: 50px; -fx-text-fill: #F4F0F0");

        String buttonStyle = "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0";
        btnAddUser.setStyle(buttonStyle);
        btnExcluir.setStyle(buttonStyle);
        btnRegistro.setStyle(buttonStyle);
        btnSair.setStyle(buttonStyle);

        btnAddUser.setOnAction(e -> {
            btnAddUser.setStyle( "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");

            TelaDeCadastro telaC = new TelaDeCadastro();
            Stage novaJanela = new Stage();
            try {
                telaC.start(novaJanela);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
        btnExcluir.setOnAction(e -> {
            btnAddUser.setStyle( "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill:  #F4F0F0");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");

            TelaDeRetirar telaR = new TelaDeRetirar();
            Stage novaJanela = new Stage();
            try {
                telaR.start(novaJanela);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
        btnRegistro.setOnAction(e -> {
            btnAddUser.setStyle( "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill:  #F4F0F0");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");

            TelaDeRegistro telaRe = new TelaDeRegistro();
            Stage novaJanela = new Stage();
            try {
                telaRe.start(novaJanela);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        btnSair.setOnAction(e -> {
            btnAddUser.setStyle( "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnRegistro.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
            btnSair.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill:  #88ff00; -fx-border-color: #88ff00");

            Alert alerta  = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Fechar aplicação");
            alerta.setHeaderText("deseja mesmo sair?");

            ButtonType sim = new ButtonType("Sim");
            ButtonType nao = new ButtonType("Não");

            alerta.getButtonTypes().setAll(sim, nao);

            Optional<ButtonType> resultado = alerta.showAndWait();

            if (resultado.isPresent() && resultado.get() == sim) {

                System.exit(0);
            }
        });


        // ------- CAIXA PRINCIPAL HORIZONTAL (HBox) -------
        HBox caixaHorizontal = new HBox(15);
        caixaHorizontal.setPadding(new Insets(12));
        caixaHorizontal.getChildren().addAll(btnAddUser, btnExcluir, btnRegistro, btnSair);

        // ------- CAIXA PRINCIPAL VERTICAL (VBox) -------
        VBox caixaPrincipal = new VBox(15);
        caixaPrincipal.setStyle("-fx-background-color: #49414B");
        caixaPrincipal.getChildren().addAll(caixaHorizontal);

        // -------- CRIANDO CONTAINER -----------
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #323031");
        root.setPadding(new Insets(20));
        root.getChildren().addAll(caixaPrincipal, titulo);


        // ------- CRIAR A CENA -------
        Scene cena = new Scene(root, 750, 550);

        // ------- MOSTRAR A JANELA -------
        stage.setScene(cena);
        stage.show();
    }
}
