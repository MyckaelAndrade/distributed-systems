import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Sensor {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 9876;
        final int SENSOR_ID = 1;
        Random random = new Random();

        try (DatagramSocket socket = new DatagramSocket()) {
            while (true) {
                float temperatura = 20 + random.nextFloat() * 15;
                float umidade = 30 + random.nextFloat() * 50;
                String mensagem = SENSOR_ID + "," + temperatura + "," + umidade;

                byte[] buffer = mensagem.getBytes();
                InetAddress serverAddr = InetAddress.getByName(SERVER_ADDRESS);
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddr, SERVER_PORT);
                socket.send(packet);

                System.out.println("Enviado: " + mensagem);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}