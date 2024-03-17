package Ex470;

import java.util.Scanner;

public class Ex470 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numero = 0; 
        int numeroPrimo = 0;

        System.out.println("Digite um número maior que 0:");
        numero = scan.nextInt();
        
        numeroPrimo = verificaPrimo(numero);
        
        if (numeroPrimo == 0) {
            System.out.println("O " + numero + " é primo");
        } else {
            System.out.println("O" + numero + " não é primo");
        }

        scan.close();
    }

    public static int verificaPrimo(int n) {
        int c = 0;
        int p = 2;
        
        while (c == 0 && p <= n / 2) {
            if (n % p == 0) {
                c = 1;
            }
            p++;
        }

        return c;
    }
}
