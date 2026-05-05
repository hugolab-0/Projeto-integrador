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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.util.Callback;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;


public class TelaDeRetirar extends Application {

    private static final Logger LOGGER = Logger.getLogger(TelaDeRetirar.class.getName());

    private boolean salvarLinhaNoCSV2(String[] linha) {
        if (linha == null || linha.length == 0) {
            LOGGER.warning("Tentativa de salvar linha nula ou vazia no histórico.");
            return false;
        }

        Path caminhoHistorico = Paths.get("src/main/data/historico_do_estacionamento.csv");

        try {
            Path diretorioPai = caminhoHistorico.getParent();
            if (diretorioPai != null && !Files.exists(diretorioPai)) {
                Files.createDirectories(diretorioPai);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Não foi possível criar o diretório para o histórico: " + e.getMessage(), e);
            mostrarAlertaErro("Erro ao salvar histórico",
                    "Não foi possível criar o diretório de dados.",
                    "Verifique as permissões do sistema de arquivos.");
            return false;
        }

        try (FileWriter writer = new FileWriter(caminhoHistorico.toFile(), true)) {
            String linhaCSV = String.join(";", linha);
            writer.append(linhaCSV).append("\n");
            return true;
        } catch (SecurityException e) {
            LOGGER.log(Level.SEVERE, "Permissão negada ao escrever no histórico: " + e.getMessage(), e);
            mostrarAlertaErro("Erro de permissão",
                    "Não foi possível salvar no arquivo de histórico.",
                    "Verifique se o arquivo não está protegido contra escrita.");
            return false;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro de I/O ao salvar no histórico: " + e.getMessage(), e);
            mostrarAlertaErro("Erro ao salvar histórico",
                    "Não foi possível escrever no arquivo de histórico.",
                    "Detalhe: " + e.getMessage());
            return false;
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

            // Salva o array no histórico
            boolean salvoComSucesso = salvarLinhaNoCSV2(linhaComDados);

            if (!salvoComSucesso) {
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setHeaderText("Erro ao registrar retirada");
                alertaErro.setContentText(
                        "Não foi possível salvar o registro no histórico. " +
                        "O veículo não será removido da lista para evitar perda de dados.");
                alertaErro.showAndWait();
                return;
            }

            //  Remove do CSV original
            try {
                String linhaCSV = String.join(";", linhaSelecionada);
                ExcluirVeiculos.removerLinhaExata(linhaCSV);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Erro ao remover veículo do CSV de estacionados: " + ex.getMessage(), ex);
                mostrarAlertaErro("Erro ao atualizar lista",
                        "O histórico foi salvo, mas houve um erro ao remover o veículo da lista de estacionados.",
                        "Detalhe: " + ex.getMessage());
            }

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
        Path path = Paths.get(caminhoArquivo);
        LOGGER.info("Tentando ler o arquivo em: " + path.toAbsolutePath());

        // Verifica se o arquivo existe
        if (!Files.exists(path)) {
            LOGGER.warning("Arquivo CSV não encontrado: " + path.toAbsolutePath());
            mostrarAlertaErro("Arquivo não encontrado",
                    "O arquivo de veículos estacionados não foi encontrado.",
                    "Caminho esperado: " + path.toAbsolutePath() +
                    "\nUm arquivo vazio será usado. Os dados aparecerão quando veículos forem cadastrados.");
            return;
        }

        // Verifica permissão de leitura
        if (!Files.isReadable(path)) {
            LOGGER.severe("Sem permissão de leitura no arquivo: " + path.toAbsolutePath());
            mostrarAlertaErro("Erro de permissão",
                    "Não foi possível ler o arquivo de veículos estacionados.",
                    "O arquivo existe, mas o programa não tem permissão de leitura.\n" +
                    "Caminho: " + path.toAbsolutePath());
            return;
        }

        int linhasLidas = 0;
        int linhasIgnoradas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                // Ignora linhas vazias ou em branco
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] valores = linha.split(";");

                if (valores.length >= 4) {
                    // Valida que os campos obrigatórios não estão vazios
                    boolean camposValidos = true;
                    for (int i = 0; i < 4; i++) {
                        if (valores[i] == null || valores[i].trim().isEmpty()) {
                            camposValidos = false;
                            break;
                        }
                    }

                    if (camposValidos) {
                        dadosVeiculos.add(valores);
                        linhasLidas++;
                    } else {
                        LOGGER.warning("Linha ignorada por conter campos obrigatórios vazios: " + linha);
                        linhasIgnoradas++;
                    }
                } else {
                    LOGGER.warning("Linha ignorada por ter menos de 4 colunas: " + linha);
                    linhasIgnoradas++;
                }
            }

            if (linhasIgnoradas > 0) {
                LOGGER.warning(linhasIgnoradas + " linha(s) foram ignoradas por dados malformados.");
                mostrarAlertaErro("Dados malformados no CSV",
                        linhasIgnoradas + " linha(s) foram ignoradas por estarem com formato incorreto.",
                        "O arquivo pode conter dados corrompidos ou incompletos.\n" +
                        "Total de veículos carregados: " + linhasLidas);
            }

            LOGGER.info("CSV lido com sucesso. " + linhasLidas + " veículo(s) carregado(s).");

        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Arquivo CSV não encontrado: " + path.toAbsolutePath(), e);
            mostrarAlertaErro("Arquivo não encontrado",
                    "O arquivo de veículos estacionados não foi encontrado.",
                    "Caminho: " + path.toAbsolutePath() + "\nDetalhe: " + e.getMessage());
        } catch (SecurityException e) {
            LOGGER.log(Level.SEVERE, "Erro de segurança ao acessar o arquivo CSV: " + e.getMessage(), e);
            mostrarAlertaErro("Erro de permissão",
                    "Acesso negado ao arquivo de veículos estacionados.",
                    "Verifique as permissões do arquivo.\nDetalhe: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro de I/O ao ler o arquivo CSV: " + e.getMessage(), e);
            mostrarAlertaErro("Erro ao ler arquivo",
                    "Não foi possível ler o arquivo de veículos estacionados.",
                    "Caminho: " + path.toAbsolutePath() + "\nDetalhe: " + e.getMessage());
        }
    }

    private void mostrarAlertaErro(String titulo, String cabecalho, String conteudo) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(conteudo);
        alerta.showAndWait();
    }
}

