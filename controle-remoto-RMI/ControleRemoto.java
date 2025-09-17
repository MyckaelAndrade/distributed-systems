import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControleRemoto extends Remote {
    String ligarDesligar() throws RemoteException;
    String aumentarVolume() throws RemoteException;
    String diminuirVolume() throws RemoteException;
    String mudarCanal(int novoCanal) throws RemoteException;
    String mostrarStatus() throws RemoteException;
}