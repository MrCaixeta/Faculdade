package Ex460;

import java.util.Scanner;

public class Ex460 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int numero = 0;
        int dobro = 0;
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Digite um número: ");
            numero = scan.nextInt();
            dobro = dobro(numero);
            System.out.println("O dobro de " + numero + " é " + dobro);
        }

        scan.close();
    }

    public static int dobro(int x) {
        return x * 2;
    }
}
