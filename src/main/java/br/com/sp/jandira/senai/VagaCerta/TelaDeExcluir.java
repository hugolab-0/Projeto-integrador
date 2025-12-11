package br.com.sp.jandira.senai.VagaCerta;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class TelaDeExcluir extends Application {

    // Classe modelo usada pela TableView
    public static class Cliente {
        private final SimpleStringProperty nome;
        private final SimpleStringProperty modelo;
        private final SimpleStringProperty placa;
        private final SimpleStringProperty cor;

        public Cliente(String nome, String modelo, String placa, String cor) {
            this.nome = new SimpleStringProperty(nome);
            this.modelo = new SimpleStringProperty(modelo);
            this.placa = new SimpleStringProperty(placa);
            this.cor = new SimpleStringProperty(cor);
        }

        public SimpleStringProperty nomeProperty() { return nome; }
        public SimpleStringProperty modeloProperty() { return modelo; }
        public SimpleStringProperty placaProperty() { return placa; }
        public SimpleStringProperty corProperty() { return cor; }

        public String getNome() { return nome.get(); }
        public String getModelo() { return modelo.get(); }
        public String getPlaca() { return placa.get(); }
        public String getCor() { return cor.get(); }
    }

    // Lista que será carregada do CSV
    private final ObservableList<Cliente> data = FXCollections.observableArrayList();

    // Estilos visuais
    private final String ICON_STYLE_INACTIVE = "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0";
    private final String ICON_STYLE_ACTIVE = "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #88ff00; -fx-border-color: #88ff00";
    private final String ACTION_BTN_STYLE_INACTIVE = "-fx-background-color: #3f3242; -fx-text-fill: #ecdfd2; -fx-font-size: 20px;";
    private final String ACTION_BTN_STYLE_RETIRAR_ACTIVE = "-fx-background-color: #3f3242; -fx-text-fill: red; -fx-font-size: 20px; -fx-border-color: red;";

    private void resetIconStyles(Button... buttons) {
        for (Button btn : buttons) {
            btn.setStyle(ICON_STYLE_INACTIVE);
        }
    }

    // -------------------------
    // NOVO MÉTODO: LER ARQUIVO CSV
    // -------------------------
    private void carregarVeiculosEstacionados() {

        String caminho = "veiculo_estacionados.csv"; // Nome do arquivo CSV

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha;
            br.readLine(); // Ignorar cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");

                if (partes.length == 4) {
                    data.add(new Cliente(
                            partes[0].trim(), // nome
                            partes[1].trim(), // modelo
                            partes[2].trim(), // placa
                            partes[3].trim()  // cor
                    ));
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar CSV: " + e.getMessage());
        }
    }

    @Override
    public void start(Stage stage) {

        // Carrega os dados do CSV
        carregarVeiculosEstacionados();

        stage.setTitle(" Vaga Certa");

        Button btnAddUser = new Button ("\uD83D\uDC64");
        Button btnExcluir = new Button("\uD83D\uDDD1");
        Button btnRegistro = new Button("\uD83D\uDCDC");
        Button btnSair = new Button("\uD83C\uDFC3\u200D");

        Button btnRetirar = new Button("Excluir");
        btnRetirar.setStyle(ACTION_BTN_STYLE_INACTIVE);
        btnRetirar.setPadding(new Insets(10, 50, 10 , 50));

        // Tabela
        TableView<Cliente> tableViewClientes = new TableView<>();
        tableViewClientes.setItems(data);
        tableViewClientes.setEditable(false);
        tableViewClientes.setMaxWidth(Double.MAX_VALUE);

        TableColumn<Cliente, String> colNome = new TableColumn<>("Nome do Proprietário");
        colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        colNome.setPrefWidth(200);

        TableColumn<Cliente, String> colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(cellData -> cellData.getValue().modeloProperty());
        colModelo.setPrefWidth(150);

        TableColumn<Cliente, String> colPlaca = new TableColumn<>("Placa");
        colPlaca.setCellValueFactory(cellData -> cellData.getValue().placaProperty());
        colPlaca.setPrefWidth(120);

        TableColumn<Cliente, String> colCor = new TableColumn<>("Cor");
        colCor.setCellValueFactory(cellData -> cellData.getValue().corProperty());
        colCor.setPrefWidth(120);

        tableViewClientes.getColumns().addAll(colNome, colModelo, colPlaca, colCor);

        VBox caixaDeInformacoes = new VBox(12);
        caixaDeInformacoes.setStyle("-fx-background-color: #322431");
        caixaDeInformacoes.setPrefHeight(500);
        caixaDeInformacoes.setMaxWidth(Double.MAX_VALUE);
        caixaDeInformacoes.setPadding(new Insets(10));
        caixaDeInformacoes.getChildren().add(tableViewClientes);

        HBox caixaDeBotoes = new HBox(20);
        caixaDeBotoes.setAlignment(Pos.CENTER);
        caixaDeBotoes.setPadding(new Insets(20));
        caixaDeBotoes.setMaxWidth(Double.MAX_VALUE);
        caixaDeBotoes.setMaxHeight(300);
        caixaDeBotoes.getChildren().addAll(btnRetirar);

        btnAddUser.setStyle(ICON_STYLE_INACTIVE);
        btnExcluir.setStyle(ICON_STYLE_ACTIVE);
        btnRegistro.setStyle(ICON_STYLE_INACTIVE);
        btnSair.setStyle(ICON_STYLE_INACTIVE);

        btnAddUser.setOnAction(e -> { resetIconStyles(btnAddUser, btnExcluir, btnRegistro, btnSair); btnAddUser.setStyle(ICON_STYLE_ACTIVE); });
        btnExcluir.setOnAction(e -> { resetIconStyles(btnAddUser, btnExcluir, btnRegistro, btnSair); btnExcluir.setStyle(ICON_STYLE_ACTIVE); });
        btnRegistro.setOnAction(e -> { resetIconStyles(btnAddUser, btnExcluir, btnRegistro, btnSair); btnRegistro.setStyle(ICON_STYLE_ACTIVE); });
        btnSair.setOnAction(e -> { resetIconStyles(btnAddUser, btnExcluir, btnRegistro, btnSair); btnSair.setStyle(ICON_STYLE_ACTIVE); });
        btnRetirar.setOnAction(e -> { btnRetirar.setStyle(ACTION_BTN_STYLE_RETIRAR_ACTIVE); });

        HBox caixaHorizontal = new HBox(15);
        caixaHorizontal.setPadding(new Insets(12));
        caixaHorizontal.getChildren().addAll(btnAddUser, btnExcluir, btnRegistro, btnSair);

        VBox colunaDeInformacoes = new VBox(15);
        colunaDeInformacoes.setAlignment(Pos.CENTER);
        colunaDeInformacoes.getChildren().addAll(caixaDeInformacoes);

        HBox conteudoHorizontal = new HBox(30);
        conteudoHorizontal.setPadding(new Insets(10, 35, 10, 35));

        HBox.setHgrow(colunaDeInformacoes, Priority.ALWAYS);
        conteudoHorizontal.getChildren().addAll(colunaDeInformacoes);

        VBox caixaPrincipal = new VBox(15);
        caixaPrincipal.setStyle("-fx-background-color: #49414B");
        VBox.setVgrow(conteudoHorizontal, Priority.ALWAYS);
        caixaPrincipal.getChildren().addAll(caixaHorizontal, conteudoHorizontal, caixaDeBotoes);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #323031");
        root.setPadding(new Insets(20));
        root.getChildren().addAll(caixaPrincipal);

        Scene cena = new Scene(root, 850, 650);

        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}