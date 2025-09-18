import java.rmi.Naming;

public class Cliente {
    public static void main(String[] args) {
        try {
            ControleRemoto controle = (ControleRemoto) Naming.lookup("rmi://localhost/ControleRemoto");

            controle.ligar();
            controle.aumentarVolume();
            controle.aumentarVolume();
            controle.trocarCanal(5);
            controle.diminuirVolume();
            controle.desligar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
