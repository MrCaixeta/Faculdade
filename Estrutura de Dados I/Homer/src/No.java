class No {
    String nome;
    No anterior;
    No proximo;

    public No(String nome) {
        this.nome = nome;
        this.anterior = null;
        this.proximo = null;
    }
}