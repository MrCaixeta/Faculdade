import java.util.Scanner;

class VerificadorExpressao {

    public static boolean verificarExpressao(String expressao) {
        PilhaDinamica pilha = new PilhaDinamica();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pilha.empilha(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (pilha.estaVazia()) return false; 

                char topo = pilha.desempilha();
                if (!corresponde(topo, c)) return false;
            }
        }
        
        return pilha.estaVazia();
    }

    private static boolean corresponde(char abertura, char fechamento) {
        return (abertura == '(' && fechamento == ')') ||
               (abertura == '[' && fechamento == ']') ||
               (abertura == '{' && fechamento == '}');
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma expressão matemática:");
        String expressao = scan.nextLine();

        if (verificarExpressao(expressao)) {
            System.out.println("Expressão correta.");
        } else {
            System.out.println("Expressão incorreta.");
        }

        scan.close();
    }
}
