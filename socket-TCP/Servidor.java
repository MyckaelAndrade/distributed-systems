import java.net.*;
import java.io.*;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1099)) {
            System.out.println("Servidor iniciado e aguardando conexões na porta 1099...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("Cliente conectado: " + clientSocket.getInetAddress().getHostAddress());

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Mensagem recebida: " + inputLine);
                        out.println("Eco: " + inputLine);
                    }

                } catch (IOException e) {
                    System.err.println("Erro ao comunicar com o cliente: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
