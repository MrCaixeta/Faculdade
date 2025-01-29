import java.util.Scanner;

public class OrdenaNomes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nomes = new String[5]; 
        for (int L = 0; L < 5; L++) {
            System.out.print("Digite o nome " + (L + 1) + ": ");
            nomes[L] = scan.nextLine();
        }

        ordena(nomes);

        System.out.println("\n\nNOMES ORDENADOS:");
        for (int L = 0; L < 5; L++) {
            System.out.println((L + 1) + " - " + nomes[L]);
        }

        scan.close();
    }

    public static void ordena(String[] vet) {
        int tam = vet.length;
        for (int i = 0; i < tam - 1; i++) {
            int menorIndice = i;
            for (int j = i + 1; j < tam; j++) {
                if (vet[j].compareToIgnoreCase(vet[menorIndice]) < 0) { 
                    menorIndice = j;
                }
            }
            if (menorIndice != i) {
                String temp = vet[i];
                vet[i] = vet[menorIndice];
                vet[menorIndice] = temp;
            }
        }
    }
}
