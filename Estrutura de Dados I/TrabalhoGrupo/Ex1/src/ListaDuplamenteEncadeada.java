class ListaDuplamenteEncadeada {
    No inicio, fim;

    void inserir(int dado) {
        No novo = new No(dado);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    void imprimir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    void concatenar(ListaDuplamenteEncadeada outra) {
        if (inicio == null) {
            inicio = outra.inicio;
        } else if (outra.inicio != null) {
            fim.proximo = outra.inicio;
            outra.inicio.anterior = fim;
            fim = outra.fim;
        }
        System.out.print("Lista concatenada: ");
        imprimir();
    }

    void separar(int posicao) {
        if (inicio == null || posicao <= 0) return;
        No atual = inicio;
        for (int i = 0; i < posicao - 1 && atual != null; i++) {
            atual = atual.proximo;
        }
        if (atual == null || atual.proximo == null) return;
        ListaDuplamenteEncadeada novaLista = new ListaDuplamenteEncadeada();
        novaLista.inicio = atual.proximo;
        novaLista.fim = fim;
        atual.proximo.anterior = null;
        atual.proximo = null;
        fim = atual;
        System.out.print("Primeira Lista: ");
        imprimir();
        System.out.print("Segunda Lista: ");
        novaLista.imprimir();
    }

    void inserirOrdenado(int dado) {
        No novo = new No(dado);
        if (inicio == null || inicio.dado >= dado) {
            novo.proximo = inicio;
            if (inicio != null) {
                inicio.anterior = novo;
            }
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null && atual.proximo.dado < dado) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            if (atual.proximo != null) {
                atual.proximo.anterior = novo;
            }
            atual.proximo = novo;
            novo.anterior = atual;
        }
    }    

    void concatenarOrdenado(ListaDuplamenteEncadeada outra) {
        ListaDuplamenteEncadeada novaLista = new ListaDuplamenteEncadeada();
    
        No a = this.inicio;
        while (a != null) {
            novaLista.inserirOrdenado(a.dado);
            a = a.proximo;
        }
    
        No b = outra.inicio;
        while (b != null) {
            novaLista.inserirOrdenado(b.dado);
            b = b.proximo;
        }
    
        System.out.print("Lista concatenada e ordenada: ");
        novaLista.imprimir();
    }
    
    
}