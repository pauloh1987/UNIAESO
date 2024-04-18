import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class atv9 {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        String palavraBuscada = "Java";

        try {
            int contador = contarPalavras(nomeArquivo, palavraBuscada);
            System.out.println("A palavra '" + palavraBuscada + "' aparece " + contador + " vezes no texto.");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private static int contarPalavras(String nomeArquivo, String palavraBuscada) throws IOException {
        int contador = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] palavras = linha.split("\\s+");
                for (String palavra : palavras) {
                    if (palavra.equals(palavraBuscada)) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }
}
