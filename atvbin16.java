import java.io.*;

public class atvbin16 {
    public static void main(String[] args) {
        String nomeArquivo = "arquivo.bin";
        int bytesParaLer = 100;

        try (InputStream inputStream = new FileInputStream(nomeArquivo)) {
            byte[] buffer = new byte[bytesParaLer];
            int bytesRead = inputStream.read(buffer, 0, bytesParaLer);

            if (bytesRead != -1) {
                System.out.println("Os primeiros " + bytesRead + " bytes do arquivo " + nomeArquivo + ":");
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print(buffer[i] + " ");
                }
            } else {
                System.out.println("O arquivo está vazio.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}
