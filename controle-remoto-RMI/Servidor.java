import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Controle controle = new ControleRemoto();
            Naming.rebind("rmi://localhost/Controle", controle);
            System.out.println("Servidor RMI iniciado e pronto para execução!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
