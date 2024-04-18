import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class atv3 {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        String mensagemAdicional = "Isso é uma adição!";

        adicionarAoArquivo(nomeArquivo, mensagemAdicional);

        System.out.println("Mensagem adicionada ao arquivo com sucesso.");
    }

    private static void adicionarAoArquivo(String nomeArquivo, String mensagemAdicional) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(mensagemAdicional);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao adicionar ao arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }
}
