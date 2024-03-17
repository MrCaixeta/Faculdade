package Ex351;
import java.util.Scanner;

public class Ex351 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String nomes[] = new String[5];

        for(int i=0; i<5; i++){
            System.out.println("Digite um nome: ");
            nomes[i] = scan.nextLine();
        }
        
        System.out.println("Digite o número da pessoa: ");
        int numero = scan.nextInt();

        do{
            System.out.println("Número inválido!");
            
            System.out.println("Digite o número da pessoa: ");
            numero = scan.nextInt();

        }while (numero>5 || numero<1); 

        System.out.println("O nome pertence a pessoa: " + nomes[numero - 1]);

        scan.close();

    }
}
