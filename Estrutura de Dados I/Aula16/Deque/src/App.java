import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento(10);
        
        while (true) {
            System.out.println("Digite C mais nº placa (ex: C 1, C 245) ou P mais nº placa (ex: P 1, P 245) ou 'S' para sair:");
            String comando = scan.nextLine();
            if (comando.equalsIgnoreCase("S")) break;
            
            String[] partes = comando.split(" ");
            char operacao = partes[0].charAt(0);
            int placa = Integer.parseInt(partes[1]);
            
            if (operacao == 'C') {
                estacionamento.chegadaCarro(placa);
            } else if (operacao == 'P') {
                estacionamento.partidaCarro(placa);
            }
            
            estacionamento.exibirEstacionamento();
        }
        scan.close();
    }
}
