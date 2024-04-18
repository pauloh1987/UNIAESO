import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}

public class atvcsv23 {
    public static void main(String[] args) {
        String nomeArquivo = "produtos.csv";
        List<Produto> produtos = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                String nome = linha[0];
                double preco = Double.parseDouble(linha[1]);
                int quantidade = Integer.parseInt(linha[2]);
                produtos.add(new Produto(nome, preco, quantidade));
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Erro ao ler arquivo CSV: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do produto que deseja excluir: ");
        String nomeProduto = scanner.nextLine();

        Produto produtoParaExcluir = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produtoParaExcluir = produto;
                break;
            }
        }

        if (produtoParaExcluir != null) {
            produtos.remove(produtoParaExcluir);
            try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
                for (Produto p : produtos) {
                    String[] linha = {p.getNome(), Double.toString(p.getPreco()), Integer.toString(p.getQuantidade())};
                    writer.writeNext(linha);
                }
                System.out.println("Produto excluído com sucesso.");
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
