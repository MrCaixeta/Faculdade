public class TorreDeHanoi {
    static int movimentos = 0;

    public static void resolverHanoi(int n, char origem, char auxiliar, char destino) {
        if (n == 1) {
            movimentos++;
            return;
        }
        resolverHanoi(n - 1, origem, destino, auxiliar);
        movimentos++;
        resolverHanoi(n - 1, auxiliar, origem, destino);
    }

    public static void main(String[] args) {
        int discos = 41; 
        movimentos = 0;

        long inicio = System.currentTimeMillis(); 
        resolverHanoi(discos, 'A', 'B', 'C');
        long fim = System.currentTimeMillis(); 

        long tempoDecorrido = fim - inicio;
        long milissegundos = tempoDecorrido % 1000;
        long segundos = (tempoDecorrido / 1000) % 60;
        long minutos = (tempoDecorrido / (1000 * 60)) % 60;
        long horas = (tempoDecorrido / (1000 * 60 * 60)) % 24;

        System.out.printf("Tempo gasto: %02d:%02d:%02d:%03d\n", horas, minutos, segundos, milissegundos);
        System.out.println("Quantidade de movimentos: " + movimentos);
    }
}
