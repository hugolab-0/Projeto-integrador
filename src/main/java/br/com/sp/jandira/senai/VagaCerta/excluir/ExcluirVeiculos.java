package br.com.sp.jandira.senai.VagaCerta.excluir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExcluirVeiculos {

    private static final String CAMINHO = "src/main/data/veiculo_estacionados.csv";

    // Apaga a linha EXATA (não só pela placa)
    public static void removerLinhaExata(String linhaCompleta) {

        try {
            List<String> linhas = Files.readAllLines(Paths.get(CAMINHO));
            List<String> novasLinhas = new ArrayList<>();

            for (String linha : linhas) {
                // Só remove se a linha for exatamente igual à linha selecionada
                if (!linha.equals(linhaCompleta)) {
                    novasLinhas.add(linha);
                }
            }

            Files.write(Paths.get(CAMINHO), novasLinhas);

        } catch (IOException e) {
            System.out.println("Erro ao apagar linha do CSV: " + e.getMessage());
        }
    }
}
