package Ex500;

import java.util.Scanner;

public class Ex500 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int vetorA[] = new int[5];
        int vetorB[] = new int[5];
        int vetorResultado[] = new int[5];
        int opcao = 0;

        do {
            System.out.println("\nDigite 1 para escolher vetor A\n" +
                    "Digite 2 para escolher vetor B\n" +
                    "Digite 3 para Imprime os Vetores\n" +
                    "Digite 4 para somar os Vetores\n" +
                    "Digite 5 para subtrair os Vetores\n" +
                    "Digite 6 para sair do programa");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    for (int i = 0; i < vetorA.length; i++) {
                        System.out.println("Digite o " + (i + 1) + "º número  do vetor A:");
                        vetorA[i] = scan.nextInt();
                    }
                    break;

                case 2:
                    for (int i = 0; i < vetorB.length; i++) {
                        System.out.println("Digite o " + (i + 1) + "º número  do vetor B:");
                        vetorB[i] = scan.nextInt();
                    }

                    break;

                case 3:
                    System.out.println("\nVetor A: ");

                    for(int i=0; i < vetorA.length; i++){
                        System.out.println(vetorA[i]);

                    }

                    System.out.println("\nVetor B: ");

                    for(int i=0; i< vetorB.length; i++){
                        System.out.println(vetorB[i]);
                    }

                    break;

                case 4:
                    System.out.println("\nA soma é:");

                    for(int i=0; i < vetorResultado.length; i++){
                        vetorResultado[i] = vetorA[i] + vetorB[i];
                        System.out.println(vetorResultado[i]);
                    }

                    break;

                case 5:
                    System.out.println("\nA subtração é: ");

                    for(int i=0; i < vetorResultado.length; i++){
                        vetorResultado[i] = vetorA[i] - vetorB[i];
                        System.out.println(vetorResultado[i]);
                    }

                    break;

                case 6:

                    break;

                default:
                    System.out.println("\nOpção invalida!");

                    break;
            }

        } while (opcao != 6);

        scan.close();
    }
}
