class ListaDuplamenteEncadeada {
    No inicio;
    No fim;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirNoFinal(String nome) {
        No novoNo = new No(nome);

        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    public void inserirNoInicio(String nome) {
        No novoNo = new No(nome);

        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
    }

    public void inserirPorPosicao(String nome, int posicao) {
        if (posicao == 1) {
            inserirNoInicio(nome);
            return;
        }

        No novoNo = new No(nome);
        No atual = inicio;
        int index = 1; // Ajustando para começar na posição 1

        while (atual != null && index < posicao - 1) {
            atual = atual.proximo;
            index++;
        }

        if (atual == null) {
            inserirNoFinal(nome);  // Inserir no final se a posição for maior que o tamanho da lista
        } else {
            novoNo.proximo = atual.proximo;
            novoNo.anterior = atual;
            if (atual.proximo != null) {
                atual.proximo.anterior = novoNo;
            }
            atual.proximo = novoNo;
        }
    }

    public void exibir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.nome + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public int contarElementos() {
        int contador = 0;
        No atual = inicio;
        while (atual != null) {
            contador++;
            atual = atual.proximo;
        }
        return contador;
    }

    public void removerPorPosicao(int posicao) {
        if (inicio == null) return;

        if (posicao == 1) {
            removerPrimeiro();
            return;
        }

        No atual = inicio;
        int index = 1; // Ajustando para começar na posição 1

        while (atual != null && index < posicao) {
            atual = atual.proximo;
            index++;
        }

        if (atual != null) {
            if (atual.anterior != null) {
                atual.anterior.proximo = atual.proximo;
            }
            if (atual.proximo != null) {
                atual.proximo.anterior = atual.anterior;
            }
            if (atual == fim) {
                fim = atual.anterior;
            }
            atual = null; // Liberar memória
        }
    }

    public void removerPrimeiro() {
        if (inicio != null) {
            if (inicio.proximo != null) {
                inicio.proximo.anterior = null;
            }
            inicio = inicio.proximo;
            if (inicio == null) {
                fim = null;
            }
        }
    }

    public void removerUltimo() {
        if (fim != null) {
            if (fim.anterior != null) {
                fim.anterior.proximo = null;
            }
            fim = fim.anterior;
            if (fim == null) {
                inicio = null;
            }
        }
    }

    public void apagarTodos() {
        inicio = null;
        fim = null;
    }
}
