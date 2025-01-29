import java.util.Scanner;
import java.util.Arrays;

public class BuscaBinaria {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] num = new int[10]; 
        
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            num[i] = scan.nextInt();
        }

        System.out.print("\nDigite o número para busca: ");
        int n = scan.nextInt();

        ordena(num);

        int c = busca(num, n);

        System.out.println("\nVETOR ORDENADO:");
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + " - " + num[i]);
        }

        if (c != -1) {
            System.out.println("\nPosição no vetor: " + (c + 1));
        } else {
            System.out.println("\nNÃO ENCONTRADO");
        }

        scan.close();
    }

    public static void ordena(int[] vetor) {
        Arrays.sort(vetor);
    }

    public static int busca(int[] vetor, int chave) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == chave) {
                return meio; 
            } else if (vetor[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1; 
    }
}
