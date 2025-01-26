import java.util.Scanner;

public class Matriz12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matriz = new int[5][5];
        int soma = 0;

        System.out.println("Digite os elementos da matriz:");
        for (int linha = 0; linha < 5; linha++) {
            for (int coluna = 0; coluna < 5; coluna++) {
                System.out.printf("Elemento [%d][%d]: ", linha + 1, coluna + 1);
                matriz[linha][coluna] = scan.nextInt();
            }
        }

        System.out.println("\nToda a matriz:");
        for (int linha = 0; linha < 5; linha++) {
            for (int coluna = 0; coluna < 5; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }

        for (int linha = 1; linha < 5; linha++) { 
            for (int coluna = 5 - linha; coluna < 5; coluna++) { 
                if (matriz[linha][coluna] % 2 != 0) {
                    soma += Math.pow(matriz[linha][coluna], 2); 
                }
            }
        }

        double raizQuadrada = Math.sqrt(soma);
        System.out.printf("\nRaiz quadrada da soma dos quadrados dos números ímpares: %.2f\n", raizQuadrada);

        scan.close();
    }
}
