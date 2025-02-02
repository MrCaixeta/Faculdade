class FilaDinamica {
    private Node frente, tras;

    public FilaDinamica() {
        this.frente = this.tras = null;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public void enqueue(int valor) {
        Node novoNo = new Node(valor);
        if (tras == null) {
            frente = tras = novoNo;
        } else {
            tras.proximo = novoNo;
            tras = novoNo;
        }
        System.out.println(valor + " adicionado à fila!");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("A fila está vazia! Nada para remover.");
            return;
        }
        int valor = frente.valor;
        frente = frente.proximo;
        if (frente == null) {
            tras = null;
        }
        System.out.println(valor + " removido da fila.");
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("A fila está vazia!");
            return;
        }
        Node atual = frente;
        System.out.print("Fila: ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}