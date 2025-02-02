import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaDinamica fila = new FilaDinamica();
        int opcao;

        do {
            System.out.println("\n===== MENU FILA DINÂMICA =====");
            System.out.println("1  Inserir elemento na fila");
            System.out.println("2  Remover elemento da fila");
            System.out.println("3  Mostrar fila");
            System.out.println("0  Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite um número para adicionar: ");
                    int valor = scanner.nextInt();
                    fila.enqueue(valor);
                    break;
                case 2:
                    fila.dequeue();
                    break;
                case 3:
                    fila.printQueue();
                    break;
                case 0:
                    System.out.println("Finalizado!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
