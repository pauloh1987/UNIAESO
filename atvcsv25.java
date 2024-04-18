import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Venda {
    private String data;
    private double valor;
    private String produtoVendido;

    public Venda(String data, double valor, String produtoVendido) {
        this.data = data;
        this.valor = valor;
        this.produtoVendido = produtoVendido;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getProdutoVendido() {
        return produtoVendido;
    }
}

public class atvcsv25 {
    public static void main(String[] args) {
        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda("2024-04-20", 150.0, "Produto A"));
        vendas.add(new Venda("2024-04-21", 200.0, "Produto B"));
        vendas.add(new Venda("2024-04-22", 100.0, "Produto C"));

        String nomeArquivo = "vendas.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
            for (Venda venda : vendas) {
                String[] linha = {venda.getData(), Double.toString(venda.getValor()), venda.getProdutoVendido()};
                writer.writeNext(linha);
            }
            System.out.println("Vendas exportadas para o arquivo " + nomeArquivo + " com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}
