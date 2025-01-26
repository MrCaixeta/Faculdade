import java.util.Scanner;

public class ReservaPassagens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int nv; 
        String[] nome = new String[1000];
        int[] voos = new int[1000]; 
        String id, nvd;
        
        System.out.println("\nEntre com o número de voos:");
        nv = scan.nextInt();
        scan.nextLine();
        
      
        for (int i = 0; i < nv; i++) {
            System.out.println("\nEntre com a identificação do voo " + (i + 1) + ":");
            nome[i] = scan.nextLine();
            System.out.println("\nEntre com a quantidade de lugares disponíveis no voo " + nome[i] + ":");
            voos[i] = scan.nextInt();
            scan.nextLine();
        }
        
     
        System.out.println("\nEntre com o número do voo desejado ou @ para terminar:");
        nvd = scan.nextLine();
        
        while (!nvd.equals("@")) {
            int i = 0;
           
            while (i < nv && !nome[i].equals(nvd)) {
                i++;
            }
            
            if (i < nv && nome[i].equals(nvd)) { 
                if (voos[i] > 0) {
                    voos[i]--; 
                    System.out.println("\nQual o número da identidade do cliente?");
                    id = scan.nextLine();
                    System.out.println("\nIdentidade: " + id + " Voo: " + nvd + "\n");
                } else {
                    System.out.println("\nNão existem mais lugares neste voo.\n");
                }
            } else {
                System.out.println("\nNão existe este voo\n");
            }
            
            System.out.println("\n\nEntre com o número do voo desejado ou @ para terminar:");
            nvd = scan.nextLine();
        }
        
        System.out.println("\n");
        scan.close();
    }
}
