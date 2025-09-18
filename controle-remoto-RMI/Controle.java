import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Controle extends Remote {
    String ligar() throws RemoteException;
    String desligar() throws RemoteException;
    String aumentarVolume() throws RemoteException;
    String diminuirVolume() throws RemoteException;
    String trocarCanal(int canal) throws RemoteException;
}