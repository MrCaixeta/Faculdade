import java.util.Scanner;

public class ElementosComuns {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] vet1 = new int[10]; 
        int[] vet2 = new int[20]; 
        int[] vetc = new int[10];
        int i, c, d, L = 0;
        
        System.out.println("\nEntrada de dados do vetor 1 (10 elementos):");
        for (i = 0; i <= 9; i++) {
            System.out.println("Entre com o " + (i + 1) + "º elemento:");
            vet1[i] = scan.nextInt();
        }
        
        System.out.println("\nEntrada de dados do vetor 2 (20 elementos):");
        for (i = 0; i <= 19; i++) {
            System.out.println("Entre com o " + (i + 1) + "º elemento:");
            vet2[i] = scan.nextInt();
        }
        
        for (i = 0; i <= 9; i++) {
            vetc[i] = -999999999; 
        }
        
        for (i = 0; i <= 9; i++) {
            c = 0;
            while (vet1[i] != vet2[c] && c < 19) {
                c++;
            }
            if (vet1[i] == vet2[c]) {
                d = 0;
                while (vet1[i] != vetc[d] && d < L) {
                    d++;
                }
                if (d == L) { 
                    vetc[d] = vet1[i];
                    L++;
                }
            }
        }
        
        if (L > 0) {
            System.out.println("\nElementos comuns:");
            for (i = 0; i < L; i++) {
                System.out.println(vetc[i]);
            }
        } else {
            System.out.println("\nNão existem elementos comuns.");
        }
        
        scan.close();
    }
}
