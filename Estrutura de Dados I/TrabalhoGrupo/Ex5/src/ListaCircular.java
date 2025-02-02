class ListaCircular {
    private No cabeca;

    public ListaCircular() {
        this.cabeca = new No(-1); 
        this.cabeca.proximo = cabeca; 
    }

    public ListaCircular copiar() {
        ListaCircular novaLista = new ListaCircular();
        if (this.cabeca.proximo == cabeca) { 
            return novaLista;
        }

        No atual = this.cabeca.proximo;
        do {
            novaLista.inserir(atual.dado);
            atual = atual.proximo;
        } while (atual != this.cabeca);

        return novaLista;
    }

    public void inserir(int dado) {
        No novoNo = new No(dado);
        No atual = cabeca;

        while (atual.proximo != cabeca) {
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
        novoNo.proximo = cabeca;
    }

    public int contarElementos() {
        int contador = 0;
        No atual = cabeca.proximo;

        while (atual != cabeca) {
            contador++;
            atual = atual.proximo;
        }
        return contador;
    }

    public static ListaCircular intercalarOrdenado(ListaCircular lista1, ListaCircular lista2) {
        ListaCircular novaLista = new ListaCircular();
        No atual1 = lista1.cabeca.proximo;
        No atual2 = lista2.cabeca.proximo;

        while (atual1 != lista1.cabeca || atual2 != lista2.cabeca) {
            if (atual1 != lista1.cabeca) {
                novaLista.inserirOrdenado(atual1.dado);
                atual1 = atual1.proximo;
            }
            if (atual2 != lista2.cabeca) {
                novaLista.inserirOrdenado(atual2.dado);
                atual2 = atual2.proximo;
            }
        }

        return novaLista;
    }

    public void inserirOrdenado(int dado) {
        No novoNo = new No(dado);
        No atual = cabeca;

        while (atual.proximo != cabeca && atual.proximo.dado < dado) {
            atual = atual.proximo;
        }

        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;
    }

    public void imprimirLista() {
        if (cabeca.proximo == cabeca) {
            System.out.println("A lista está vazia.");
            return;
        }

        System.out.print("Cabeça (" + cabeca.dado + ") -> ");
        No atual = cabeca.proximo;
        do {
            System.out.print(atual.dado + " -> ");
            atual = atual.proximo;
        } while (atual != cabeca);
        System.out.println("(volta para a cabeça)");
    }

    public static ListaCircular concatenarNova(ListaCircular lista1, ListaCircular lista2) {
        ListaCircular novaLista = lista1.copiar();

        if (lista2.cabeca.proximo == lista2.cabeca) return novaLista;

        No atual = lista2.cabeca.proximo;
        do {
            novaLista.inserir(atual.dado);
            atual = atual.proximo;
        } while (atual != lista2.cabeca);

        return novaLista;
    }

    public void inserirNaCabeca(int dado) {
        No novoNo = new No(dado);
        novoNo.proximo = cabeca.proximo;
        cabeca.proximo = novoNo;
    }

    public void atualizarCabeca(int dado) {
        this.cabeca.dado = dado;
    }
}