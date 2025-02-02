import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ListaDuplamenteEncadeada listaA = new ListaDuplamenteEncadeada();
        ListaDuplamenteEncadeada listaB = new ListaDuplamenteEncadeada();
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar elementos nas listas: ");
            System.out.println("2 - Concatenar listas: ");
            System.out.println("3 - Separar lista: ");
            System.out.println("4 - Concatenar e ordenar listas: ");
            System.out.println("5 - Encerrar");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Quantos elementos deseja adicionar na lista A? ");
                    int n = scan.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Digite o elemento: ");
                        listaA.inserir(scan.nextInt());
                    }
                    System.out.print("Quantos elementos deseja adicionar na lista B? ");
                    n = scan.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Digite o elemento: ");
                        listaB.inserir(scan.nextInt());
                    }
                    break;
                case 2:
                    listaA.concatenar(listaB);
                    break;
                case 3:
                    System.out.print("Informe a posição para separar a lista A: ");
                    int pos = scan.nextInt();
                    listaA.separar(pos);
                    break;
                    
                case 4:
                    listaA.concatenarOrdenado(listaB);
                    break;
                case 5:
                    System.out.println("Fim");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        scan.close();
    }
}
