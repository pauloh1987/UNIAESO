import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class atv2 {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";

        String conteudo = lerArquivo(nomeArquivo);

        System.out.println("Conteúdo do arquivo:");
        System.out.println(conteudo);
    }

    private static String lerArquivo(String nomeArquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha);
                conteudo.append("\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + nomeArquivo + ": " + e.getMessage());
        }
        return conteudo.toString();
    }
}
