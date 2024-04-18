import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class atv8 {
    public static void main(String[] args) {
        String arquivoEntrada = "meuarquivo.txt";
        String arquivoSaida = "meuarquivo_sem_excluir.txt";
        String palavraExcluir = "excluir";

        try {
            removerLinhasComPalavra(arquivoEntrada, arquivoSaida, palavraExcluir);
            System.out.println("Linhas contendo '" + palavraExcluir + "' removidas com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }

    private static void removerLinhasComPalavra(String arquivoEntrada, String arquivoSaida, String palavraExcluir)
            throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoEntrada));
             BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {

            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.contains(palavraExcluir)) {
                    writer.write(linha);
                    writer.newLine();
                }
            }
        }
    }
}
