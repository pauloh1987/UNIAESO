import java.io.*;

public class atvbin15 {
    public static void main(String[] args) {
        String arquivoOrigem = "arquivo_grande.bin";
        String arquivoDestino = "copia_arquivo_grande.bin";

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(arquivoOrigem));
             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(arquivoDestino))) {

            byte[] buffer = new byte[8192]; // 8KB buffer

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Arquivo copiado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao copiar arquivo: " + e.getMessage());
        }
    }
}
