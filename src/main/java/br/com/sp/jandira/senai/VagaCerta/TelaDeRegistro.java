package br.com.sp.jandira.senai.VagaCerta;

import br.com.sp.jandira.senai.VagaCerta.veiculosEstacionado.VeiculoEstacionado;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority; // Importante para o Priority.ALWAYS
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TelaDeRegistro extends Application {

    private TableView<ObservableList<String>> table;

        @Override
        public void start(Stage stage) {
            stage.setTitle(" Vaga Certa");

            table = new TableView<>();
            table.setPrefHeight(450);

            TableColumn<VeiculoEstacionado, String> colId = new TableColumn<>("ID");
            colId.setCellValueFactory(f -> f.getValue().setId());

            File arquivo = new File("src/main/data/veiculo_estacionado.csv");

            try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {

                String linha = leitor.readLine();
                linha = leitor.readLine();

                while (linha  != null) {

                    String[] campos = linha.split(";");

                    VeiculoEstacionado v = new VeiculoEstacionado(
                            campos[0], // id
                            campos[1], // nome
                            campos[2], // modelo
                            campos[3], // placa
                            campos[4], // cor
                            campos[5]  // total
                    );



                }
            } catch (Exception erro) {
                System.out.println("Houve um problema");
                System.out.println(erro.getMessage());
            }


            // ------- ELEMENTOS PRICIPAIS DA PAGINA -------
            Button btnAddUser = new Button("\uD83D\uDC64");
            Button btnExcluir = new Button("\uD83D\uDDD1");
            Button btnRegistro = new Button("\uD83D\uDCDC");
            Button btnSair = new Button("\uD83C\uDFC3\u200D");


            //--------- CRIAÇÃO DE COLETA DE INFORMAÇÕES (VBOX) ----------


            VBox caixaDeInformacoes = new VBox(12);
            VBox.setMargin(caixaDeInformacoes, new Insets(25));
            caixaDeInformacoes.setStyle("-fx-background-color: #322431");
            caixaDeInformacoes.setPrefHeight(405);
            caixaDeInformacoes.setMaxWidth(850);
            caixaDeInformacoes.getChildren().addAll();

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

            // ------- CAIXA SUPERIOR HORIZONTAL (HBox) -------
            HBox caixaHorizontal = new HBox(15);
            caixaHorizontal.setPadding(new Insets(12));
            caixaHorizontal.getChildren().addAll(btnAddUser, btnExcluir, btnRegistro, btnSair);


            // NOVO CONTAINER HORIZONTAL DE CONTEÚDO (Para colocar a caixa de botões à direita)
            VBox colunaDeInformacoes = new VBox(15);
            colunaDeInformacoes.getChildren().addAll(caixaDeInformacoes);


            HBox conteudoHorizontal = new HBox(30);
            conteudoHorizontal.setPadding(new Insets(10, 35, 10, 35));
            // FORÇA A COLUNA DE INFORMAÇÕES A CRESCER HORIZONTALMENTE
            // Isso garante que ela ocupe todo o espaço na esquerda
            HBox.setHgrow(colunaDeInformacoes, Priority.ALWAYS);
            conteudoHorizontal.getChildren().addAll(colunaDeInformacoes);

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

        public static void main(String[] args) {
            launch(args);
        }
}
