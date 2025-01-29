public class ListaDuplamenteEncadeada {
    private No inicio = null;
    private No fim = null;

    public void inserirOrdenado(int valor) {
        No novoNo = new No(valor);

        if (inicio == null) { 
            inicio = fim = novoNo;
            return;
        }

        No atual = inicio;
        while (atual != null && atual.valor < valor) {
            atual = atual.proximo;
        }

        if (atual == inicio) { 
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        } else if (atual == null) { 
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        } else { 
            No anterior = atual.anterior;
            anterior.proximo = novoNo;
            novoNo.anterior = anterior;
            novoNo.proximo = atual;
            atual.anterior = novoNo;
        }
    }

    public void imprimirOrdemCrescente() {
        No atual = inicio;
        System.out.print("\nLista crescente:\n");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void imprimirOrdemDecrescente() {
        No atual = fim;
        System.out.print("\nLista decrescente:\n");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.anterior;
        }
        System.out.println();
    }

    public void removerPrimos() {
        No atual = inicio;
        while (atual != null) {
            if (ehPrimo(atual.valor)) {
                if (atual == inicio) { 
                    inicio = atual.proximo;
                    if (inicio != null) inicio.anterior = null;
                } else if (atual == fim) { 
                    fim = atual.anterior;
                    if (fim != null) fim.proximo = null;
                } else { 
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
            }
            atual = atual.proximo;
        }
    }

    private boolean ehPrimo(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
