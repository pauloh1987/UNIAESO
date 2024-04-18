import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class atvcsv19 {
    public static void main(String[] args) {
        String nomeArquivo = "funcionarios.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo, true))) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite os detalhes do funcionário:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();
            System.out.print("Salário: ");
            String salario = scanner.nextLine();

            String[] linha = {nome, cargo, salario};
            writer.writeNext(linha);

            System.out.println("Informações do funcionário adicionadas ao arquivo CSV.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }

    }
}
