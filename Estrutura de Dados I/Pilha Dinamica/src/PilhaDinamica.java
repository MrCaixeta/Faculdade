class PilhaDinamica {
    private No topo;

    public PilhaDinamica() {
        this.topo = null;
    }

    public void empilha(char dado) {
        No novoNo = new No(dado);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public char desempilha() {
        if (estaVazia()) {
            return '\0';
        }
        char dado = topo.dado;
        topo = topo.proximo;
        return dado;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public char topo() {
        return estaVazia() ? '\0' : topo.dado;
    }
}
