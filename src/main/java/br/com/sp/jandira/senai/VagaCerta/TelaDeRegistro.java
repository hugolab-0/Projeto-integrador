package br.com.sp.jandira.senai.VagaCerta;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import javafx.util.Callback;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;


public class TelaDeRegistro extends Application {

    private TableView<String[]> table = new TableView<>();
    private final ObservableList<String[]> dadosVeiculos = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        stage.setTitle(" Vaga Certa");

        // ------------------ CONFIGURAÇÃO DA TABLEVIEW --------------------


        TableColumn<String[], String> col1 = criarColuna("ID", 0);
        TableColumn<String[], String> col2 = criarColuna("NOME", 1);
        TableColumn<String[], String> col3 = criarColuna("MODELO", 2);
        TableColumn<String[], String> col4 = criarColuna("PLACA", 3);
        TableColumn<String[], String> col5 = criarColuna("COR", 4);
        TableColumn<String[], String> col6 = criarColuna("Total a ser pago", 6);



        table.getColumns().addAll(col1, col2, col3, col4, col5, col6);
        table.setItems(dadosVeiculos);
        // Caminho
        String caminhoArquivo = "src/main/data/veiculo_estacionados.csv";

      lerEPopularCSV(caminhoArquivo);

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
        caixaDeInformacoes.getChildren().addAll(table);

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


        // NOVO CONTAINER HORIZONTAL DE CONTEÚDO
        VBox colunaDeInformacoes = new VBox(15);
        colunaDeInformacoes.getChildren().addAll(caixaDeInformacoes);


        HBox conteudoHorizontal = new HBox(30);
        conteudoHorizontal.setPadding(new Insets(10, 35, 10, 35));
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

    // MÉTODO AUXILIAR PARA CRIAR AS COLUNAS
    private TableColumn<String[], String> criarColuna(String titulo, int indice) {
        TableColumn<String[], String> coluna = new TableColumn<>(titulo);
        coluna.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> data) {
                // Se o array tiver menos colunas do que o esperado, ele não falha
                if (data.getValue() != null && data.getValue().length > indice) {
                    return new SimpleStringProperty(data.getValue()[indice]);
                }
                return new SimpleStringProperty("");
            }
        });
        return coluna;
    }


    // MÉTODO QUE LÊ O CSV E PREENCHE O ObservableList
    private void lerEPopularCSV(String caminhoArquivo) {
        java.nio.file.Path path = Paths.get(caminhoArquivo);
        System.out.println("Tentando ler o arquivo em: " + path.toAbsolutePath());

        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String linha;
            // Tente comentar a linha abaixo se o seu arquivo não tiver cabeçalho
            // br.readLine();

            while ((linha = br.readLine()) != null) {
                // 🔴 ALTERAÇÃO CRUCIAL: USANDO O PONTO E VÍRGULA (;) COMO SEPARADOR
                String[] valores = linha.split(";");

                // Verifica se a linha tem o número esperado de colunas
                if (valores.length >= 4) {
                    // Adiciona o array de valores (a linha) à lista observável
                    dadosVeiculos.add(valores);
                } else {
                    System.err.println("Linha ignorada por ter menos de 4 colunas: " + linha);
                }
            }
        } catch (IOException e) {
            System.err.println("---------------------------------------------------------");
            System.err.println("ERRO: Não foi possível ler o arquivo CSV!");
            System.err.println("Caminho absoluto que o código tentou: " + path.toAbsolutePath());
            System.err.println("Erro detalhe: " + e.getMessage());
            System.err.println("---------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
