public class ListaOrdenadaMain {
    public static void main(String[] args) {
        int[] vetor = new int[1000];
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        for (int i = 0; i < 1000; i++) {
            vetor[i] = (int) (Math.random() * 19999) - 9999;
        }

        System.out.print("Vetor gerado: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println();

        for (int num : vetor) {
            lista.inserirOrdenado(num);
        }

        lista.imprimirOrdemCrescente();
        lista.imprimirOrdemDecrescente();

        lista.removerPrimos();
        System.out.println("\nLista após remoção dos números primos:");
        lista.imprimirOrdemCrescente();
    }
}
