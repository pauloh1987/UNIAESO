import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

public class atvcsv20 {
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
        }

        // Exibir detalhes dos produtos no console
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
