class ListaCircular {
    private No cabeca;

    public ListaCircular() {
        this.cabeca = null;
    }

    public ListaCircular copiar() {
        ListaCircular novaLista = new ListaCircular();
        if (this.cabeca == null) {
            return novaLista;
        }

        No atual = this.cabeca;
        do {
            novaLista.inserir(atual.dado);
            atual = atual.proximo;
        } while (atual != this.cabeca);
        
        return novaLista;
    }

    public void inserir(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
            cabeca.proximo = cabeca; 
        } else {
            No atual = cabeca;
            while (atual.proximo != cabeca) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
            novoNo.proximo = cabeca;
        }
    }

    public int contarElementos() {
        if (cabeca == null) {
            return 0;
        }
        int contagem = 1;
        No atual = cabeca;
        while (atual.proximo != cabeca) {
            contagem++;
            atual = atual.proximo;
        }
        return contagem;
    }

    public static ListaCircular intercalarOrdenado(ListaCircular lista1, ListaCircular lista2) {
        ListaCircular novaLista = new ListaCircular();
        No atual1 = lista1.cabeca;
        No atual2 = lista2.cabeca;

        if (atual1 == null) return lista2.copiar();
        if (atual2 == null) return lista1.copiar();

        do {
            novaLista.inserirOrdenado(atual1.dado);
            atual1 = atual1.proximo;
        } while (atual1 != lista1.cabeca);

        do {
            novaLista.inserirOrdenado(atual2.dado);
            atual2 = atual2.proximo;
        } while (atual2 != lista2.cabeca);

        return novaLista;
    }

    public void inserirOrdenado(int dado) {
        No novoNo = new No(dado);

        if (cabeca == null) {
            cabeca = novoNo;
            cabeca.proximo = cabeca;
            return;
        }

        No atual = cabeca;
        No anterior = null;

        do {
            if (atual.dado >= dado) break;
            anterior = atual;
            atual = atual.proximo;
        } while (atual != cabeca);

        if (anterior == null) {
            novoNo.proximo = cabeca;
            while (atual.proximo != cabeca) atual = atual.proximo;
            atual.proximo = novoNo;
            cabeca = novoNo;
        } else {
            anterior.proximo = novoNo;
            novoNo.proximo = atual;
        }
    }

    public void imprimirLista() {
        if (cabeca == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        No atual = cabeca;
        do {
            System.out.print(atual.dado + " -> ");
            atual = atual.proximo;
        } while (atual != cabeca);
        System.out.println("(volta para o início)");
    }

    public static ListaCircular concatenarNova(ListaCircular lista1, ListaCircular lista2) {
        ListaCircular novaLista = lista1.copiar(); 

        if (lista2.cabeca == null) return novaLista; 

        No atual = lista2.cabeca;
        do {
            novaLista.inserir(atual.dado);
            atual = atual.proximo;
        } while (atual != lista2.cabeca);

        return novaLista;
    }

    public void inserirNaCabeca(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
            cabeca.proximo = cabeca; 
        } else {
            No atual = cabeca;
            while (atual.proximo != cabeca) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
            novoNo.proximo = cabeca;
            cabeca = novoNo; 
        }
    }
}