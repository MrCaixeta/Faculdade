import java.util.Scanner;
import java.util.Stack;

public class InverteLetras {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = scan.nextLine();

        String resultado = inverterLetras(frase);

        System.out.println("\nResultado:");
        System.out.println(resultado);

        scan.close();
    }

    public static String inverterLetras(String frase) {
        String[] palavras = frase.split(" "); 
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            resultado.append(inverterPalavra(palavra)).append(" "); 
        }

        return resultado.toString().trim();
    }

    public static String inverterPalavra(String palavra) {
        Stack<Character> pilha = new Stack<>();

        for (char c : palavra.toCharArray()) {
            pilha.push(c);
        }

        StringBuilder palavraInvertida = new StringBuilder();
        while (!pilha.isEmpty()) {
            palavraInvertida.append(pilha.pop());
        }

        return palavraInvertida.toString();
    }
}
