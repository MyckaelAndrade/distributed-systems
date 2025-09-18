import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1099);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado ao servidor! ");

            String userInput;
            System.out.println("Digite mensagens para enviar ao servidor (digite 'sair' para encerrar):");
            while (true) {
                System.out.print("> ");
                userInput = scanner.nextLine();
                if ("sair".equalsIgnoreCase(userInput)) {
                    break;
                }
                out.println(userInput);
                String response = in.readLine();
                System.out.println("Resposta do servidor: " + response);
            }

        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        }
    }
}
