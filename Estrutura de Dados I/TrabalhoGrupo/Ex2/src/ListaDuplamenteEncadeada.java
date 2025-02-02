class ListaDuplamenteEncadeada {
    No cabeca; 
    int tamanho; 

    public ListaDuplamenteEncadeada() {
        cabeca = new No(-1); 
        cabeca.proximo = cabeca;
        cabeca.anterior = cabeca;
        tamanho = 0;
    }

    public void inserir(int dado) {
        No novo = new No(dado);
        No ultimo = cabeca.anterior;

        ultimo.proximo = novo;
        novo.anterior = ultimo;
        novo.proximo = cabeca;
        cabeca.anterior = novo;

        tamanho++;
    }

    public No buscar(int dado) {
        No atual = cabeca.proximo;
        while (atual != cabeca) {
            if (atual.dado == dado) {
                return atual; 
            }
            atual = atual.proximo;
        }
        return null; 
    }

    public void remover(int dado) {
        No nodo = buscar(dado);
        if (nodo != null) {
            nodo.anterior.proximo = nodo.proximo;
            nodo.proximo.anterior = nodo.anterior;
            tamanho--;
            System.out.println("Elemento " + dado + " removido.");
        } else {
            System.out.println("Elemento " + dado + " não encontrado.");
        }
    }

    public void imprimir() {
        if (tamanho == 0) {
            System.out.println("Lista vazia!");
            return;
        }
        No atual = cabeca.proximo;
        while (atual != cabeca) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public int tamanho() {
        return tamanho;
    }
}