import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SubstituirPalavra {
    public static void main(String[] args) {
        String nomeArquivoEntrada = "meuarquivo.txt";
        String nomeArquivoSaida = "meuarquivo_python.txt";
        String palavraAntiga = "Java";
        String palavraNova = "Python";

        substituirPalavra(nomeArquivoEntrada, nomeArquivoSaida, palavraAntiga, palavraNova);

        System.out.println("Substituição concluída. Verifique o arquivo 'meuarquivo_python.txt'.");
    }

    private static void substituirPalavra(String nomeArquivoEntrada, String nomeArquivoSaida, String palavraAntiga, String palavraNova) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivoEntrada));
             BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivoSaida))) {

            String linha;
            while ((linha = reader.readLine()) != null) {
                linha = linha.replaceAll(palavraAntiga, palavraNova);
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
