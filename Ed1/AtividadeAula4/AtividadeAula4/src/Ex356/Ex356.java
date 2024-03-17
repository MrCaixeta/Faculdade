package Ex356;
import java.util.Scanner;

public class Ex356 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String nome[] = new String[15];
        double notaProva1[] = new double[15];
        double notaProva2[] = new double[15];
        double media[] = new double[15];
        String situacao[] = new String[15];
        

        for(int i=0; i<15; i++){
            System.out.println("Digite o nome do " + (i+1) + "º aluno:  ");
            nome[i] = scan.nextLine();

            System.out.println("Digite a primeira nota do " + (i+1) + "º aluno:  ");
            notaProva1[i] = scan.nextDouble();

            System.out.println("Digite a primeira nota do " + (i+1) + "º aluno:  ");
            notaProva2[i] = scan.nextDouble();

            scan.nextLine();

            media[i] = (notaProva1[i] + notaProva2[i]) / 2;

            if(media[i]< 6){
                situacao[i] = "RP";
            }else{
                situacao[i] = "AP";
            }
 
        }

    System.out.println("\nNome\tNota1\tNota2\tMédia\tSituação");

        for(int i=0; i<15; i++){
            System.out.print(nome[i] + "\t");
            System.out.print(notaProva1[i] + "\t");
            System.out.print(notaProva2[i] + "\t");
            System.out.print(media[i] + "\t");
            System.out.println(situacao[i]);
        }
        
    scan.close();

    }
}
