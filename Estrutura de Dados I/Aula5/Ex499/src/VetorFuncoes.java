import java.util.Scanner;
import java.util.Arrays;

public class VetorFuncoes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] num = new int[5];
        int op;
        boolean flag = false;

        Arrays.fill(num, 0);

        do {
            System.out.println("\n\nMENU VETOR - FUNÇÃO");
            System.out.println("1. Dados do VETOR");
            System.out.println("2. Ordena VETOR");
            System.out.println("3. Imprime VETOR");
            System.out.println("4. Sai do programa");
            System.out.print("OPÇÃO: ");
            op = scan.nextInt();

            switch (op) {
                case 1:
                    entrada(num, scan);
                    flag = true;
                    break;
                case 2:
                    if (flag) {
                        ordena(num);
                    } else {
                        System.out.println("\nEscolha primeiro a opção 1 para preencher o vetor.");
                    }
                    break;
                case 3:
                    if (flag) {
                        imprime(num);
                    } else {
                        System.out.println("\nEscolha primeiro a opção 1 para preencher o vetor.");
                    }
                    break;
                case 4:
                    System.out.println("\nSaindo do Algoritmo...");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (op != 4);

        scan.close();
    }

    public static void entrada(int[] vetor, Scanner scan) {
        System.out.println("\nDigite 5 números para preencher o vetor:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            vetor[i] = scan.nextInt();
        }
    }

    public static void ordena(int[] vetor) {
        Arrays.sort(vetor);
        System.out.println("\nVetor ordenado com sucesso!");
    }

    public static void imprime(int[] vetor) {
        System.out.println("\nValores do vetor:");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
