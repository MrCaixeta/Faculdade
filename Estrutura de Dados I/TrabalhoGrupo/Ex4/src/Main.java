import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCircularDuplamenteEncadeada list1 = new ListaCircularDuplamenteEncadeada();
        ListaCircularDuplamenteEncadeada list2 = new ListaCircularDuplamenteEncadeada();

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
            System.out.println("9. Sair");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Quantos elementos deseja adicionar na lista 1? ");
                    int count1 = sc.nextInt();
                    for (int i = 0; i < count1; i++) {
                        System.out.print("Digite o valor do elemento: ");
                        list1.insert(sc.nextInt());
                    }
                    break;

                case 2:
                    System.out.print("Quantos elementos deseja adicionar na lista 2? ");
                    int count2 = sc.nextInt();
                    for (int i = 0; i < count2; i++) {
                        System.out.print("Digite o valor do elemento: ");
                        list2.insert(sc.nextInt());
                    }
                    break;

                case 3:
                    System.out.print("Digite o valor para inserir à esquerda da cabeça da lista 1: ");
                    list1.insertAtHead(sc.nextInt());
                    break;

                case 4:
                    ListaCircularDuplamenteEncadeada concatenatedList = ListaCircularDuplamenteEncadeada.concatenateNew(list1, list2);
                    System.out.println("Lista concatenada: ");
                    concatenatedList.printList();
                    break;

                case 5:
                    ListaCircularDuplamenteEncadeada intercalatedList = ListaCircularDuplamenteEncadeada.interleaveSorted(list1, list2);
                    System.out.println("Lista intercalada ordenada: ");
                    intercalatedList.printList();
                    break;

                case 6:
                    System.out.println("Número de elementos na lista 1: " + list1.countElements());
                    break;

                case 7:
                    list2 = list1.copy();
                    System.out.println("Lista 1 copiada para a lista 2.");
                    break;

                case 8:
                    System.out.println("Lista 1: ");
                    list1.printList();
                    System.out.println("Lista 2: ");
                    list2.printList();
                    break;

                case 9:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
