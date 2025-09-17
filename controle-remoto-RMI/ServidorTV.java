import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorTV extends UnicastRemoteObject implements ControleRemoto {

    private boolean ligada = false;
    private int volume = 20;
    private int canal = 1;

    public ServidorTV() throws RemoteException {
        super();
    }

    @Override
    public String ligarDesligar() throws RemoteException {
        this.ligada = !this.ligada;
        if (this.ligada) {
            return "TV ligada.";
        } else {
            return "TV desligada.";
        }
    }

    @Override
    public String aumentarVolume() throws RemoteException {
        if (!this.ligada) return "TV está desligada.";
        if (volume < 100) volume++;
        return "Volume: " + volume;
    }

    @Override
    public String diminuirVolume() throws RemoteException {
        if (!this.ligada) return "TV está desligada.";
        if (volume > 0) volume--;
        return "Volume: " + volume;
    }

    @Override
    public String mudarCanal(int novoCanal) throws RemoteException {
        if (!this.ligada) return "TV está desligada.";
        if (novoCanal > 0) {
            this.canal = novoCanal;
            return "Canal mudado para " + this.canal;
        }
        return "Canal inválido.";
    }

    @Override
    public String mostrarStatus() throws RemoteException {
        return "Status da TV:\n" +
               "Ligada: " + (ligada ? "Sim" : "Não") + "\n" +
               "Volume: " + volume + "\n" +
               "Canal: " + canal;
    }

    public static void main(String[] args) {
        try {
            // Este é o IP do computador que rodará o servidor.
            // Para testar na mesma máquina, use "localhost".
            String servidorIP = "192.168.1.10"; // Troque por seu IP
            
            // Define o IP do servidor para que o RMI Registry saiba onde encontrar o objeto.
            System.setProperty("java.rmi.server.hostname", servidorIP);
            
            ServidorTV tv = new ServidorTV();
            Naming.rebind("rmi://" + servidorIP + "/ControleRemoto", tv);
            
            System.out.println("Servidor da TV pronto no IP: " + servidorIP);
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}