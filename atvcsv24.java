import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Funcionário{" +
                "nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salário=" + salario +
                '}';
    }
}

public class atvcsv24 {
    public static void main(String[] args) {
        String nomeArquivo = "funcionarios.csv";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                String nome = linha[0];
                String cargo = linha[1];
                double salario = Double.parseDouble(linha[2]);
                funcionarios.add(new Funcionario(nome, cargo, salario));
            }
        } catch (IOException | CsvValidationException e) {
            System.err.println("Erro ao ler arquivo CSV: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Opções de filtro:");
        System.out.println("1. Filtrar por cargo");
        System.out.println("2. Filtrar por salário mínimo");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Digite o cargo para filtrar: ");
                scanner.nextLine(); // Consumir a quebra de linha
                String cargoFiltro = scanner.nextLine();
                System.out.println("Funcionários com o cargo de " + cargoFiltro + ":");
                filtrarPorCargo(funcionarios, cargoFiltro);
                break;
            case 2:
                System.out.print("Digite o salário mínimo para filtrar: ");
                double salarioMinimo = scanner.nextDouble();
                System.out.println("Funcionários com salário igual ou superior a " + salarioMinimo + ":");
                filtrarPorSalarioMinimo(funcionarios, salarioMinimo);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void filtrarPorCargo(List<Funcionario> funcionarios, String cargoFiltro) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCargo().equalsIgnoreCase(cargoFiltro)) {
                System.out.println(funcionario);
            }
        }
    }

    private static void filtrarPorSalarioMinimo(List<Funcionario> funcionarios, double salarioMinimo) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getSalario() >= salarioMinimo) {
                System.out.println(funcionario);
            }
        }
    }
}
