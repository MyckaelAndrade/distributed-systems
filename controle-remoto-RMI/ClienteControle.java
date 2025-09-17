import java.rmi.Naming;

public class ClienteControle {

    public static void main(String[] args) {
        try {
            // Use o mesmo IP do computador que está rodando o ServidorTV.
            String servidorIP = "192.168.1.10"; // Troque pelo IP do servidor
            
            // Faz a busca do objeto remoto
            ControleRemoto controle = (ControleRemoto) Naming.lookup("rmi://" + servidorIP + "/ControleRemoto");
            
            System.out.println("Conectado ao servidor da TV!");

            // Testando as funções remotas
            System.out.println(controle.mostrarStatus());
            System.out.println(controle.ligarDesligar());
            System.out.println(controle.aumentarVolume());
            System.out.println(controle.aumentarVolume());
            System.out.println(controle.mudarCanal(5));
            System.out.println(controle.diminuirVolume());
            System.out.println(controle.mostrarStatus());

        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}