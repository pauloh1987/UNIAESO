import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class atvcsv21 {
    public static void main(String[] args) {
        String nomeArquivo = "produtos.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo, true))) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite os detalhes do produto:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Preço: ");
            double preco = Double.parseDouble(scanner.nextLine());
            System.out.print("Quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            String[] linha = {nome, Double.toString(preco), Integer.toString(quantidade)};
            writer.writeNext(linha);

            System.out.println("Produto adicionado ao arquivo CSV.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}
