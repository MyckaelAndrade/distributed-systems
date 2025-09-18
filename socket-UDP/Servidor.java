import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Map;

public class Servidor {
    public static void main(String[] args) {
        final int PORTA = 9876;
        Map<Integer, String> ultimasLeituras = new HashMap<>();

        try (DatagramSocket socket = new DatagramSocket(PORTA)) {
            System.out.println("Servidor UDP escutando na porta " + PORTA);

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
                socket.receive(pacote);

                String mensagem = new String(pacote.getData(), 0, pacote.getLength());
                String[] partes = mensagem.split(",");
                int sensorId = Integer.parseInt(partes[0]);
                String leitura = "Temperatura: " + partes[1] + "C | Umidade: " + partes[2] + "%";

                ultimasLeituras.put(sensorId, leitura);

                System.out.println("Leituras atuais:");
                for (Map.Entry<Integer, String> entry : ultimasLeituras.entrySet()) {
                    System.out.println("Sensor " + entry.getKey() + " -> " + entry.getValue());
                }
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}