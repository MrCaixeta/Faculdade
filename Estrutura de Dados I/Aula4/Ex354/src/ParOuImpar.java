import java.util.Scanner;

public class ParOuImpar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] num = new int[15]; 
        int L;
        
       
        for (L = 0; L <= 14; L++) {
            System.out.println("Digite o " + (L + 1) + "º número:");
            num[L] = scan.nextInt();
        }
        
        System.out.println("\nRELAÇÃO DOS NÚMEROS");
        for (L = 0; L <= 14; L++) {
            System.out.print((L + 1) + "- " + num[L]);
            if (num[L] % 2 == 0) {
                System.out.println(" é PAR");
            } else {
                System.out.println(" é ÍMPAR");
            }
        }
        
        scan.close();
    }
}
