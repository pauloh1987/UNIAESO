import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private double salario;

    public Funcionario(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                '}';
    }
}

public class atvbin17 {
    private static final String NOME_ARQUIVO = "funcionarios.bin";
    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        carregarFuncionarios();

        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1. Adicionar funcionário");
            System.out.println("2. Atualizar funcionário");
            System.out.println("3. Excluir funcionário");
            System.out.println("4. Exibir todos os funcionários");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarFuncionario(scanner);
                    break;
                case 2:
                    atualizarFuncionario(scanner);
                    break;
                case 3:
                    excluirFuncionario(scanner);
                    break;
                case 4:
                    exibirFuncionarios();
                    break;
                case 5:
                    salvarFuncionarios();
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void carregarFuncionarios() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO))) {
            funcionarios = (List<Funcionario>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Não foi possível carregar os funcionários. Criando um novo arquivo...");
        }
    }

    private static void salvarFuncionarios() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
            outputStream.writeObject(funcionarios);
        } catch (IOException e) {
            System.err.println("Erro ao salvar funcionários: " + e.getMessage());
        }
    }

    private static void adicionarFuncionario(Scanner scanner) {
        System.out.print("Digite o ID do funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();

        Funcionario funcionario = new Funcionario(id, nome, salario);
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso.");
    }

    private static void atualizarFuncionario(Scanner scanner) {
        System.out.print("Digite o ID do funcionário que deseja atualizar: ");
        int id = scanner.nextInt();
        Funcionario funcionario = buscarFuncionarioPorId(id);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado: " + funcionario);
            System.out.println("Digite as novas informações do funcionário:");
            System.out.print("Nome: ");
            scanner.nextLine(); // Limpar o buffer
            String nome = scanner.nextLine();
            System.out.print("Salário: ");
            double salario = scanner.nextDouble();
            funcionario = new Funcionario(id, nome, salario);
            funcionarios.removeIf(f -> f.getId() == id);
            funcionarios.add(funcionario);
            System.out.println("Funcionário atualizado com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void excluirFuncionario(Scanner scanner) {
        System.out.print("Digite o ID do funcionário que deseja excluir: ");
        int id = scanner.nextInt();
        Funcionario funcionario = buscarFuncionarioPorId(id);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
            System.out.println("Funcionário excluído com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void exibirFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out
