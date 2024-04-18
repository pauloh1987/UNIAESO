import java.io.FileInputStream;
import java.io.ObjectInputStream;
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

public class atvbin12 {
    public static void main(String[] args) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("pessoa.dat"))) {
            Pessoa pessoa = (Pessoa) inputStream.readObject();
            System.out.println("Detalhes da Pessoa:");
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());
        } catch (Exception e) {
            System.err.println("Erro ao deserializar objeto Pessoa: " + e.getMessage());
        }
    }
}
