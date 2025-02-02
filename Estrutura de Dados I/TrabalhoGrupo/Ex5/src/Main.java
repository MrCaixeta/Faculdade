import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCircular lista1 = new ListaCircular();
        ListaCircular lista2 = new ListaCircular();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir elementos na lista 1");
            System.out.println("2. Inserir elementos na lista 2");
            System.out.println("3. Inserir um elemento à esquerda da cabeça da lista 1");
            System.out.println("4. Concatenar as listas (criar nova lista)");
            System.out.println("5. Intercalar as listas de forma ordenada");
            System.out.println("6. Contar o número de elementos na lista 1");
            System.out.println("7. Copiar a lista 1 para a lista 2");
            System.out.println("8. Imprimir as listas");
            System.out.println("9. Atualizar o valor do nó cabeça da lista 1");
            System.out.println("10. Sair");

            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    System.out.print("Quantos elementos deseja adicionar na lista 1? ");
                    int qtd1 = sc.nextInt();
                    for (int i = 0; i < qtd1; i++) {
                        System.out.print("Digite o valor do elemento: ");
                        lista1.inserir(sc.nextInt());
                    }
                    break;

                case 2:
                    System.out.print("Quantos elementos deseja adicionar na lista 2? ");
                    int qtd2 = sc.nextInt();
                    for (int i = 0; i < qtd2; i++) {
                        System.out.print("Digite o valor do elemento: ");
                        lista2.inserir(sc.nextInt());
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor para inserir à esquerda da cabeça da lista 1: ");
                    lista1.inserirNaCabeca(sc.nextInt());
                    break;

                case 4:
                    ListaCircular listaConcatenada = ListaCircular.concatenarNova(lista1, lista2);
                    System.out.println("Lista concatenada: ");
                    listaConcatenada.imprimirLista();
                    break;

                case 5:
                    ListaCircular listaIntercalada = ListaCircular.intercalarOrdenado(lista1, lista2);
                    System.out.println("Lista intercalada ordenada: ");
                    listaIntercalada.imprimirLista();
                    break;

                case 6:
                    System.out.println("Número de elementos na lista 1: " + lista1.contarElementos());
                    break;

                case 7:
                    lista2 = lista1.copiar();
                    System.out.println("Lista 1 copiada para a lista 2.");
                    break;

                case 8:
                    System.out.println("Lista 1: ");
                    lista1.imprimirLista();
                    System.out.println("Lista 2: ");
                    lista2.imprimirLista();
                    break;

                case 9:
                    System.out.print("Digite o novo valor do nó cabeça: ");
                    lista1.atualizarCabeca(sc.nextInt());
                    System.out.println("Valor do nó cabeça atualizado.");
                    break;

                case 10:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}