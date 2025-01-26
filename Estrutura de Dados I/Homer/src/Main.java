import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir nome");
            System.out.println("2. Inserir nome no início");
            System.out.println("3. Inserir nome no final");
            System.out.println("4. Inserir nome por posição");
            System.out.println("5. Exibir quantidade de elementos e nomes");
            System.out.println("6. Remover nome por posição");
            System.out.println("7. Remover nome da primeira posição");
            System.out.println("8. Remover nome da última posição");
            System.out.println("9. Apagar todos os elementos");
            System.out.println("10. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    lista.inserirNoFinal(nome);
                    break;

                case 2:
                    System.out.print("Digite o nome: ");
                    nome = scanner.nextLine();
                    lista.inserirNoInicio(nome);
                    break;

                case 3:
                    System.out.print("Digite o nome: ");
                    nome = scanner.nextLine();
                    lista.inserirNoFinal(nome);
                    break;

                case 4:
                    System.out.print("Digite o nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Digite a posição: ");
                    int posicao = scanner.nextInt();
                    lista.inserirPorPosicao(nome, posicao);
                    break;

                case 5:
                    System.out.println("Quantidade de elementos: " + lista.contarElementos());
                    System.out.print("Elementos: ");
                    lista.exibir();
                    break;

                case 6:
                    System.out.print("Digite a posição do nome a ser removido: ");
                    posicao = scanner.nextInt();
                    lista.removerPorPosicao(posicao);
                    break;

                case 7:
                    lista.removerPrimeiro();
                    break;

                case 8:
                    lista.removerUltimo();
                    break;

                case 9:
                    lista.apagarTodos();
                    break;

                case 10:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 10);

        scanner.close();
    }
}