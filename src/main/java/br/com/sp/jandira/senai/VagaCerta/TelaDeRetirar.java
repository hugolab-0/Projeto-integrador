package br.com.sp.jandira.senai.VagaCerta;

import br.com.sp.jandira.senai.VagaCerta.calculotempo.ValorETempo;
import br.com.sp.jandira.senai.VagaCerta.excluir.ExcluirVeiculos;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;

import javafx.util.Callback;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;


public class TelaDeRetirar extends Application {

    private void salvarLinhaNoCSV2(String[] linha) {

        try (FileWriter writer =
                     new FileWriter("src/main/data/historico_do_estacionamento.csv", true)) {

            String linhaCSV = String.join(";", linha);
            writer.append(linhaCSV).append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TableView<String[]> table = new TableView<>();
    private final ObservableList<String[]> dadosVeiculos = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        stage.setTitle(" Vaga Certa");



        // ------------------ 1. CONFIGURAÇÃO DA TABLEVIEW --------------------


        TableColumn<String[], String> col1 = criarColuna("ID", 0);
        TableColumn<String[], String> col2 = criarColuna("NOME", 1);
        TableColumn<String[], String> col3 = criarColuna("MODELO", 2);
        TableColumn<String[], String> col4 = criarColuna("PLACA", 3);
        TableColumn<String[], String> col5 = criarColuna("COR", 4);





        table.getColumns().addAll(col1, col2, col3, col4, col5);
        table.setItems(dadosVeiculos);
        // Caminho
        String caminhoArquivo = "src/main/data/veiculo_estacionados.csv";

        lerEPopularCSV(caminhoArquivo);

        Button btnAddUser = new Button("\uD83D\uDC64");
        Button btnExcluir = new Button("\uD83D\uDDD1");
        Button btnRegistro = new Button("\uD83D\uDCDC");
        Button btnSair = new Button("\uD83C\uDFC3\u200D");

        Button btnRetirar = new Button("Retirar");


        //--------- CRIAÇÃO DE COLETA DE INFORMAÇÕES (VBOX) ----------
        TextField campoPesquisa = new TextField();
        campoPesquisa.setPromptText("Pesquisar placa...");
        campoPesquisa.setStyle("-fx-font-size: 10px");
        campoPesquisa.setPadding(new Insets(7, 60, 7, 60));


        Button btnPesquisar = new Button("Buscar");
        btnPesquisar.setStyle("-fx-font-size: 10px; -fx-background-color: #322f32; -fx-text-fill: white;");
        btnPesquisar.setPadding(new Insets(7, 50, 7, 50));

        HBox barraPesquisa = new HBox(10);
        barraPesquisa.setPadding(new Insets(10));
        barraPesquisa.getChildren().addAll(campoPesquisa, btnPesquisar);

        VBox caixaDeInformacoes = new VBox(12);
        VBox.setMargin(caixaDeInformacoes, new Insets(25));
        caixaDeInformacoes.setStyle("-fx-background-color: #322431");
        caixaDeInformacoes.setPrefHeight(405);
        caixaDeInformacoes.setMaxWidth(850);
        caixaDeInformacoes.getChildren().addAll(barraPesquisa, table);

        // ------------- AJUSTE NOS ELEMENTOS (Estilos de Botão) --------

        String buttonStyle = "-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0";
        btnAddUser.setStyle(buttonStyle);
        btnExcluir.setStyle("-fx-font-family: 'Segoe UI Emoji'; -fx-font-size: 35px; -fx-background-color: #322f32; -fx-text-fill: #88ff00; -fx-border-color: #88ff00");
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
        btnPesquisar.setOnAction(e -> {
            String texto = campoPesquisa.getText().trim().toLowerCase();

            if (texto.isEmpty()) {
                table.setItems(dadosVeiculos);
                return;
            }

            ObservableList<String[]> filtrado = FXCollections.observableArrayList();

            for (String[] linha : dadosVeiculos) {
                if (linha.length > 3 && linha[3].toLowerCase().contains(texto)) {
                    filtrado.add(linha);
                }
            }

            table.setItems(filtrado);
        });
        btnRetirar.setOnAction(e->{
            String[] linhaSelecionada = table.getSelectionModel().getSelectedItem();

            // Validação
            if (linhaSelecionada == null) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setHeaderText("Nenhum veículo selecionado.");
                alerta.setContentText("Selecione um veículo na lista.");
                alerta.show();
                return;
            }

            //  Finaliza o tempo
            ValorETempo.finalizarContador();

            //  Calcula tempo e valor
            long tempoMinutos = ValorETempo.getTempoEmMinutos();
            double valor = ValorETempo.getValorAPagar();

            // Mostra o tempo pro usuário
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setHeaderText("Tempo de permanência");
            info.setContentText(
                    "Tempo estacionado: " + tempoMinutos + " minutos\n" +
                            "Valor a pagar: R$ " + valor
            );
            info.showAndWait();

            //  Cria nova linha com tempo
            String[] linhaComDados = new String[linhaSelecionada.length + 2];

            System.arraycopy(linhaSelecionada, 0, linhaComDados, 0, linhaSelecionada.length);

            linhaComDados[linhaSelecionada.length] = ValorETempo.getTempoFormatado();
            linhaComDados[linhaSelecionada.length + 1] = ValorETempo.getValorFormatado();

// salva o array
            salvarLinhaNoCSV2(linhaComDados);

            //  Remove do CSV original
            String linhaCSV = String.join(";", linhaSelecionada);
            ExcluirVeiculos.removerLinhaExata(linhaCSV);

            // Remove da tabela
            dadosVeiculos.remove(linhaSelecionada);
        });
        btnRetirar.setStyle("; -fx-font-size: 25px; -fx-background-color: #322f32; -fx-text-fill: #F4F0F0;");
        btnRetirar.setPadding(new Insets(20, 80, 20, 80));

        // ------- CAIXA SUPERIOR HORIZONTAL (HBox) -------
        HBox caixaHorizontal = new HBox(15);
        caixaHorizontal.setPadding(new Insets(12));
        caixaHorizontal.getChildren().addAll(btnAddUser, btnExcluir, btnRegistro, btnSair);


        // NOVO CONTAINER HORIZONTAL DE CONTEÚDO
        VBox colunaDeInformacoes = new VBox(15);
        colunaDeInformacoes.getChildren().addAll(caixaDeInformacoes, btnRetirar);


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
            public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> data) {
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

            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(";");

                if (valores.length >= 4) {

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
}

