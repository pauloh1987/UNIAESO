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

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

public class atvcsv22 {
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
        System.out.print("Digite o nome do produto que deseja atualizar: ");
        String nomeProduto = scanner.nextLine();

        Produto produto = buscarProdutoPorNome(produtos, nomeProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.println("Produto encontrado: " + produto);
        System.out.println("Digite as novas informações do produto:");
        System.out.print("Novo preço: ");
        double novoPreco = Double.parseDouble(scanner.nextLine());
        System.out.print("Nova quantidade: ");
        int novaQuantidade = Integer.parseInt(scanner.nextLine());

        produto.setPreco(novoPreco);
        produto.setQuantidade(novaQuantidade);

        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
            for (Produto p : produtos) {
                String[] linha = {p.getNome(), Double.toString(p.getPreco()), Integer.toString(p.getQuantidade())};
                writer.writeNext(linha);
            }
            System.out.println("Produto atualizado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }

    private static Produto buscarProdutoPorNome(List<Produto> produtos, String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }
}
