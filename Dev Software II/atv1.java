import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class atv1 {

    public static void main(String[] args) {
        try {
            FileWriter arquivoEscrita = new FileWriter("meuarqugitivo.txt");
            PrintWriter escrever = new PrintWriter(arquivoEscrita);
            escrever.println("Olá, mundo!");
            escrever.close();
            System.out.println("Arquivo criado com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar o arquivo.");
            e.printStackTrace();
        } 
    }


}