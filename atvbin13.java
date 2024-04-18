import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Produto implements Serializable {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}

public class atvbin13 {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", 2500.00));
        produtos.add(new Produto("Celular", 1500.00));
        produtos.add(new Produto("Tablet", 800.00));

        serializarProdutos(produtos);

        List<Produto> produtosDeserializados = deserializarProdutos();
        for (Produto produto : produtosDeserializados) {
            System.out.println(produto);
        }
    }

    private static void serializarProdutos(List<Produto> produtos) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("produtos.dat"))) {
            outputStream.writeObject(produtos);
        } catch (IOException e) {
            System.err.println("Erro ao serializar lista de produtos: " + e.getMessage());
        }
    }

    private static List<Produto> deserializarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("produtos.dat"))) {
            produtos = (List<Produto>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao deserializar lista de produtos: " + e.getMessage());
        }
        return produtos;
    }
}
