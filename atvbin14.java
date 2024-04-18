import java.io.*;

class ContaBancaria implements Serializable {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }
}

public class atvbin14 {
    public static void main(String[] args) {
        ContaBancaria conta = deserializarConta("conta.dat");
        if (conta != null) {
            System.out.println("Saldo antes da atualização: " + conta.getSaldo());
            conta.depositar(1000.0); 
            System.out.println("Saldo após atualização: " + conta.getSaldo());
            serializarConta(conta, "conta.dat");
            System.out.println("Conta atualizada e serializada com sucesso.");
        } else {
            System.out.println("Erro ao carregar a conta.");
        }
    }

    private static ContaBancaria deserializarConta(String nomeArquivo) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (ContaBancaria) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao deserializar conta: " + e.getMessage());
            return null;
        }
    }

    private static void serializarConta(ContaBancaria conta, String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(conta);
        } catch (IOException e) {
            System.err.println("Erro ao serializar conta: " + e.getMessage());
        }
    }
}
