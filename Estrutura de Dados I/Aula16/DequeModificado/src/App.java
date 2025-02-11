import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento();

        while (true) {
            System.out.println("Digite em um dos formatos a seguir: (C PT 1 / C RBC 22 / P 1 / S para sair): ");
            String comando = scan.nextLine();
            if (comando.equals("S"))
                break;

            String[] partes = comando.split(" ");
            if (partes[0].equals("C")) {
                estacionamento.chegadaCarro(partes[1], Integer.parseInt(partes[2]));
            } else if (partes[0].equals("P")) {
                estacionamento.partidaCarro(Integer.parseInt(partes[1]));
            }
            estacionamento.estadoEstacionamento();
        }
        scan.close();
    }
}
