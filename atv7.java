import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class atv7 {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_ordenado.txt";

        List<String> linhas = lerArquivo(nomeArquivoEntrada);
        if (linhas != null) {
            Collections.sort(linhas);
            escreverArquivoOrdenado(nomeArquivoSaida, linhas);
            System.out.println("Arquivo ordenado com sucesso.");
        } else {
            System.out.println("Erro ao ler o arquivo.");
        }
    }

    private static List<String> lerArquivo(String nomeArquivo) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
            return linhas;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }

    private static void escreverArquivoOrdenado(String nomeArquivo, List<String> linhas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
