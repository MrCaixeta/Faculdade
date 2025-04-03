import java.util.ArrayList;
import java.util.Random;

class AlgoritmoGenetico {
    
    static final String Target = "Lucas"; 
    static final int TAMANHO_POPULACAO = 100; 
    static final int MAXIMO_GERACOES = 1000;
    static final double TAXA_MUTACAO = 0.01; 

    public static void main(String[] args) {
        // Cria população inicial
        ArrayList<String> populacao = inicializarPopulacao();
        int geracao = 0;
        
        while (geracao < MAXIMO_GERACOES) {
            ArrayList<String> novaPopulacao = new ArrayList<>();
            for (int i = 0; i < TAMANHO_POPULACAO; i++) {
                String pai1 = selecionar(populacao);
                String pai2 = selecionar(populacao);
                String filho = cruzamento(pai1, pai2);
                filho = mutacao(filho);
                novaPopulacao.add(filho);
            }
            
            // Substitui a população antiga pela nova
            populacao = novaPopulacao;
            geracao++;
            
            // Obtém o melhor indivíduo da geração e calcula a similaridade
            String melhor = obterMelhorSolucao(populacao);
            double similaridade = calcularSimilaridade(melhor);
            System.out.printf("Geração: %d | Melhor: %s | Similaridade: %.2f%%%n", geracao, melhor, similaridade);
            
            if (melhor.equals(Target)) {
                break;
            }
        }
    }

    // Cria uma população inicial aleatória
    public static ArrayList<String> inicializarPopulacao() {
        ArrayList<String> populacao = new ArrayList<>();
        for (int i = 0; i < TAMANHO_POPULACAO; i++) {
            populacao.add(gerarStringAleatoria(Target.length()));
        }
        return populacao;
    }

    // Gera uma string aleatória
    public static String gerarStringAleatoria(int tamanho) {
        Random aleatorio = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            char caractereAleatorio;
            do {
                caractereAleatorio = (char) (aleatorio.nextInt(127)); // tabela ASCII
            } while (!caracactereValido(caractereAleatorio)); 
            str.append(caractereAleatorio);
        }
        return str.toString();
    }

    // Verifica se o caractere é válido
    public static boolean caracactereValido(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ';
    }

    // Calcula o quão perto um indivíduo está da resposta
    public static int aptidao(String individuo) {
        int aptidao = 0;
        for (int i = 0; i < Target.length(); i++) {
            if (individuo.charAt(i) == Target.charAt(i)) {
                aptidao++;
            }
        }
        return aptidao;
    }

    // Seleciona um indivíduo da população com base na aptidão
    public static String selecionar(ArrayList<String> populacao) {
        Random aleatorio = new Random();
        int aptidaoTotal = 0;
        for (String individuo : populacao) {
            aptidaoTotal += aptidao(individuo);
        }
        
        int aptidaoAleatoria = aleatorio.nextInt(aptidaoTotal);
        int aptidaoAcumulada = 0;
        for (String individuo : populacao) {
            aptidaoAcumulada += aptidao(individuo);
            if (aptidaoAcumulada >= aptidaoAleatoria) {
                return individuo;
            }
        }
        return populacao.get(aleatorio.nextInt(populacao.size())); 
    }

    // Cruzamento entre dois indivíduos
    public static String cruzamento(String pai1, String pai2) {
        int pontoCruzamento = pai1.length() / 2;
        return pai1.substring(0, pontoCruzamento) + pai2.substring(pontoCruzamento);
    }

    // Mutação em um indivíduo
    public static String mutacao(String individuo) {
        Random aleatorio = new Random();
        StringBuilder mutado = new StringBuilder(individuo);
        for (int i = 0; i < individuo.length(); i++) {
            if (aleatorio.nextDouble() < TAXA_MUTACAO) {
                char caractereAleatorio;
                do {
                    caractereAleatorio = (char) (aleatorio.nextInt(127)); 
                } while (!caracactereValido(caractereAleatorio)); 
                mutado.setCharAt(i, caractereAleatorio);
            }
        }
        return mutado.toString();
    }

    // Obtém o melhor indivíduo da geração atual
    public static String obterMelhorSolucao(ArrayList<String> populacao) {
        String melhor = populacao.get(0);
        for (String individuo : populacao) {
            if (aptidao(individuo) > aptidao(melhor)) {
                melhor = individuo;
            }
        }
        return melhor;
    }

    // Calcula a similaridade com a resposta
    public static double calcularSimilaridade(String individuo) {
        return (aptidao(individuo) / (double) Target.length()) * 100;
    }
}
