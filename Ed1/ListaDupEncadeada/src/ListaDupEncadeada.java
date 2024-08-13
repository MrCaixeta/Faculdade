class ListaDuplamenteEncadeada {
    No inicio;
    No fim;
    int tamanho;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void inserirNoFinal(String valor) {
        No novoNo = new No(valor);
        if (this.inicio == null) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            this.fim.proximo = novoNo;
            novoNo.anterior = this.fim;
            this.fim = novoNo;
        }
        this.tamanho++;
    }

    public void inserirNoInicio(String valor) {
        No novoNo = new No(valor);
        if (this.inicio == null) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            novoNo.proximo = this.inicio;
            this.inicio.anterior = novoNo;
            this.inicio = novoNo;
        }
        this.tamanho++;
    }

    public void inserirNaPosicao(String valor, int posicao) {
        No novoNo = new No(valor);
        if (posicao <= 1) { // Inserir no início (posição 1)
            inserirNoInicio(valor);
        } else if (posicao > this.tamanho) { // Inserir no final
            inserirNoFinal(valor);
        } else { // Inserir no meio
            No atual = this.inicio;
            int indice = 1;
            while (atual != null && indice < posicao) {
                atual = atual.proximo;
                indice++;
            }
            novoNo.anterior = atual.anterior;
            novoNo.proximo = atual;
            if (atual.anterior != null) {
                atual.anterior.proximo = novoNo;
            }
            atual.anterior = novoNo;
        }
        this.tamanho++;
    }

    public void exibir() {
        No atual = this.inicio;
        System.out.println("Quantidade de elementos na lista: " + this.tamanho);
        int posicao = 1;
        while (atual != null) {
            System.out.print(posicao + ": " + atual.valor + " ");
            atual = atual.proximo;
            posicao++;
        }
        System.out.println();
    }

    public void removerPorPosicao(int posicao) {
        if (posicao < 1 || posicao > this.tamanho) {
            System.out.println("Posição inválida!");
            return;
        }

        No atual = this.inicio;
        int indice = 1;
        while (atual != null && indice < posicao) {
            atual = atual.proximo;
            indice++;
        }

        if (atual != null) {
            if (atual.anterior != null) {
                atual.anterior.proximo = atual.proximo;
            } else {
                this.inicio = atual.proximo;
            }
            if (atual.proximo != null) {
                atual.proximo.anterior = atual.anterior;
            } else {
                this.fim = atual.anterior;
            }
            this.tamanho--;
        }
    }

    public void removerPrimeiro() {
        if (this.inicio != null) {
            this.inicio = this.inicio.proximo;
            if (this.inicio != null) {
                this.inicio.anterior = null;
            } else {
                this.fim = null;
            }
            this.tamanho--;
        }
    }

    public void removerUltimo() {
        if (this.fim != null) {
            this.fim = this.fim.anterior;
            if (this.fim != null) {
                this.fim.proximo = null;
            } else {
                this.inicio = null;
            }
            this.tamanho--;
        }
    }

    public void limpar() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
}