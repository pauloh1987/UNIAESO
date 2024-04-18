import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class atv1 {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        String mensagem = "Olá, mundo!";

        escreverNoArquivo(nomeArquivo, mensagem);

        System.out.println("Mensagem escrita no arquivo com sucesso.");
    }

    private static void escreverNoArquivo(String nomeArquivo, String mensagem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(mensagem);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }
}
