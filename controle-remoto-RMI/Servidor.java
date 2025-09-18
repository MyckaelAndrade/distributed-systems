import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // inicia o RMI Registry na porta 1099
            ControleRemoto controle = new ControleRemotoImpl();
            Naming.rebind("rmi://193.168.119.1/ControleRemoto", controle);
            System.out.println("Servidor RMI pronto!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
