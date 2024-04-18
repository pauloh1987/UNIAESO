import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Pessoa implements Serializable {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

public class atvbin11 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 30);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("pessoa.dat"))) {
            outputStream.writeObject(pessoa);
            System.out.println("Objeto Pessoa serializado com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao serializar objeto Pessoa: " + e.getMessage());
        }
    }
}
