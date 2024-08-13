import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        while (true) {
            try {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Inserir nome na próxima posição disponível");
                System.out.println("2. Inserir nome no início da lista");
                System.out.println("3. Inserir nome no final da lista");
                System.out.println("4. Inserir nome em uma posição específica");
                System.out.println("5. Exibir lista");
                System.out.println("6. Remover nome da lista por posição");
                System.out.println("7. Remover o primeiro elemento da lista");
                System.out.println("8. Remover o último elemento da lista");
                System.out.println("9. Limpar lista");
                System.out.println("10. Sair");
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Limpa a linha de entrada

                if (opcao == 1) {
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    lista.inserirNoFinal(nome);
                } else if (opcao == 2) {
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    lista.inserirNoInicio(nome);
                } else if (opcao == 3) {
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    lista.inserirNoFinal(nome);
                } else if (opcao == 4) {
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a posição (iniciando em 1): ");
                    int posicao = scanner.nextInt();
                    scanner.nextLine();  // Limpa a linha de entrada
                    lista.inserirNaPosicao(nome, posicao);
                } else if (opcao == 5) {
                    lista.exibir();
                } else if (opcao == 6) {
                    System.out.print("Digite a posição do elemento a ser removido: ");
                    int posicao = scanner.nextInt();
                    scanner.nextLine();  // Limpa a linha de entrada
                    lista.removerPorPosicao(posicao);
                } else if (opcao == 7) {
                    lista.removerPrimeiro();
                    System.out.println("Primeiro elemento removido.");
                } else if (opcao == 8) {
                    lista.removerUltimo();
                    System.out.println("Último elemento removido.");
                } else if (opcao == 9) {
                    lista.limpar();
                    System.out.println("Lista foi limpa.");
                } else if (opcao == 10) {
                    break;
                } else {
                    System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine();  // Limpa a linha de entrada
            }
        }

        scanner.close();
    }
}