import java.util.Scanner;

public class MatrizDiferenca {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] A = new int[5][5];
        int[][] B = new int[5][5];
        int[][] DIF = new int[5][5];

        System.out.println("Digite os elementos da matriz A:");
        for (int L = 0; L < 5; L++) {
            for (int c = 0; c < 5; c++) {
                System.out.printf("Digite o elemento A[%d][%d]: ", L + 1, c + 1);
                A[L][c] = scan.nextInt();
            }
        }

        System.out.println("\nDigite os elementos da matriz B:");
        for (int L = 0; L < 5; L++) {
            for (int c = 0; c < 5; c++) {
                System.out.printf("Digite o elemento B[%d][%d]: ", L + 1, c + 1);
                B[L][c] = scan.nextInt();
            }
        }

        for (int L = 0; L < 5; L++) {
            for (int c = 0; c < 5; c++) {
                DIF[L][c] = A[L][c] - B[L][c];
            }
        }

        System.out.println("\n\tMATRIZ DIFERENÇA:");
        for (int L = 0; L < 5; L++) {
            for (int c = 0; c < 5; c++) {
                System.out.printf("%5d", DIF[L][c]);
            }
            System.out.println();
        }

        scan.close();
    }
}
