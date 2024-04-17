import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class atv2 {
    public static void main(String[] args) {
        try {
            FileReader arquivoLeitura = new FileReader("meuarquivo.txt");
            BufferedReader ler = new BufferedReader(arquivoLeitura);
            String linha;
            while ((linha = ler.readLine()) != null) {
                System.out.println(linha);
            }
            ler.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }
}