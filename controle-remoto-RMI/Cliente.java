import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Controle controle = (Controle) Naming.lookup("rmi://localhost/Controle");
            Scanner scanner = new Scanner(System.in);
            int opcao;
            do {
                System.out.println("\n===== CONTROLE REMOTO =====");
                System.out.println("(1) Ligar TV");
                System.out.println("(2) Desligar TV");
                System.out.println("(3) Aumentar Volume");
                System.out.println("(4) Diminuir Volume");
                System.out.println("(5) Trocar Canal");
                System.out.println("(0) Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println(controle.ligar());
                        break;
                    case 2:
                        System.out.println(controle.desligar());
                        break;
                    case 3:
                        System.out.println(controle.aumentarVolume());
                        break;
                    case 4:
                        System.out.println(controle.diminuirVolume());
                        break;
                    case 5:
                        System.out.print("Digite o número do canal: ");
                        int canal = scanner.nextInt();
                        System.out.println(controle.trocarCanal(canal));
                        break;
                    case 0:
                        System.out.println("Encerrando cliente...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (opcao != 0);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
