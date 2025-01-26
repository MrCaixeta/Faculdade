class Produto {
    private int codigo;
    private int quantidade;
    private double preco;

    public Produto(int codigo, int quantidade, double preco) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void vender(int quantidadeVendida) {
        this.quantidade -= quantidadeVendida;
    }
}
