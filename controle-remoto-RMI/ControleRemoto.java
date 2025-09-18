import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ControleRemoto extends UnicastRemoteObject implements Controle {
    private boolean ligado;
    private int volume;
    private int canal;

    public ControleRemoto() throws RemoteException {
        super();
        this.ligado = false;
        this.volume = 0;
        this.canal = 1;
    }

    @Override
    public String ligar() throws RemoteException {
        if (this.ligado) return "TV ligada!";
        this.ligado = true;
        return "TV já está ligada.";
    }

    @Override
    public String desligar() throws RemoteException {
        if (this.ligado) return  "TV desligada!";
        this.ligado = false;
        return "TV já está desligada.";
    }

    @Override
    public String aumentarVolume() throws RemoteException {
        if (this.ligado) return "Volume aumentado para: " + this.volume;
        this.volume++;
        return "A TV está desligada!";
    }

    @Override
    public String diminuirVolume() throws RemoteException {
        if (this.ligado) {
            if (this.volume > 0) {
                this.volume--;
                return "Volume diminuído para: " + this.volume;
            } return "Volume já está no mínimo.";
        } return "A TV está desligada!";
    }

    @Override
    public String trocarCanal(int canal) throws RemoteException {
        if (this.ligado) {
            this.canal = canal;
            return "Canal trocado para: " + this.canal;
        } return "A TV está desligada!";
    }
}
