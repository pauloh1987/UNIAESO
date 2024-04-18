import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class atv6 {
    public static void main(String[] args) {
        String nomeArquivo = "dados.csv";

        lerArquivoCSV(nomeArquivo);
    }

    private static void lerArquivoCSV(String nomeArquivo) {
        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] campos = linha.split(",");

                System.out.println("Campos da linha:");
                for (String campo : campos) {
                    System.out.println(campo);
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + nomeArquivo);
        }
    }
}
