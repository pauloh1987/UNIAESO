import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class atvcsv18 {
    public static void main(String[] args) {
        String nomeArquivo = "alunos.csv";

        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                for (String dado : linha) {
                    System.out.print(dado + "\t");
                }
                System.out.println();
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Erro ao ler arquivo CSV: " + e.getMessage());
        }
    }
}
