import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        int opcao, dado;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Buscar elemento");
            System.out.println("3 - Remover elemento");
            System.out.println("4 - Imprimir lista");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    dado = scan.nextInt();
                    lista.inserir(dado);
                    System.out.println("Elemento " + dado + " inserido.");
                    break;
                case 2:
                    System.out.print("Digite o elemento a ser buscado: ");
                    dado = scan.nextInt();
                    No resultado = lista.buscar(dado);
                    if (resultado != null) {
                        System.out.println("Elemento " + dado + " encontrado.");
                    } else {
                        System.out.println("Elemento " + dado + " não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o elemento a ser removido: ");
                    dado = scan.nextInt();
                    lista.remover(dado);
                    break;
                case 4:
                    System.out.print("Lista atual: ");
                    lista.imprimir();
                    break;
                case 5:
                    System.out.println("Fim");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 5);

        scan.close();
    }
}
