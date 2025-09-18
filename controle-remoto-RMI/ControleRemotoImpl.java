import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ControleRemotoImpl extends UnicastRemoteObject implements ControleRemoto {
    private boolean ligado;
    private int volume;
    private int canal;

    public ControleRemotoImpl() throws RemoteException {
        super();
        this.ligado = false;
        this.volume = 10;
        this.canal = 1;
    }

    @Override
    public void ligar() throws RemoteException {
        if (!ligado) {
            ligado = true;
            System.out.println("TV ligada!");
        } else {
            System.out.println("TV já está ligada.");
        }
    }

    @Override
    public void desligar() throws RemoteException {
        if (ligado) {
            ligado = false;
            System.out.println("TV desligada!");
        } else {
            System.out.println("TV já está desligada.");
        }
    }

    @Override
    public void aumentarVolume() throws RemoteException {
        if (ligado) {
            volume++;
            System.out.println("Volume aumentado para: " + volume);
        } else {
            System.out.println("A TV está desligada!");
        }
    }

    @Override
    public void diminuirVolume() throws RemoteException {
        if (ligado) {
            if (volume > 0) {
                volume--;
                System.out.println("Volume diminuído para: " + volume);
            } else {
                System.out.println("Volume já está no mínimo.");
            }
        } else {
            System.out.println("A TV está desligada!");
        }
    }

    @Override
    public void trocarCanal(int canal) throws RemoteException {
        if (ligado) {
            this.canal = canal;
            System.out.println("Canal trocado para: " + canal);
        } else {
            System.out.println("A TV está desligada!");
        }
    }
}
