class Quarto {
    private int numero;
    private int leitos;
    private double preco;
    private String situacao; // "L" - Livre, "A" - Alugado, "R" - Reservado
    private String nomeHospede;
    private String dataEntrada;
    private String dataSaida;
    private int numeroDiarias;
    private double despesas;

    public Quarto(int numero, int leitos, double preco, String situacao) {
        this.numero = numero;
        this.leitos = leitos;
        this.preco = preco;
        this.situacao = situacao;
        this.despesas = 0.0;
    }

    public String getSituacao() {
        return situacao;
    }

    public void alugarOuReservar(String situacao, String nome, String dataEntrada, String dataSaida, int numeroDiarias) {
        this.situacao = situacao;
        this.nomeHospede = nome;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.numeroDiarias = numeroDiarias;
    }

    public void adicionarDespesa(double valor) {
        this.despesas += valor;
    }

    public double calcularTotal() {
        return (preco * numeroDiarias) + despesas;
    }

    public void liberarQuarto() {
        this.situacao = "L";
        this.nomeHospede = null;
        this.dataEntrada = null;
        this.dataSaida = null;
        this.numeroDiarias = 0;
        this.despesas = 0.0;
    }

    @Override
    public String toString() {
        return "Quarto " + numero + " - Situação: " + situacao +
                (situacao.equals("A") || situacao.equals("R") ?
                        "\nHospede: " + nomeHospede +
                        "\nEntrada: " + dataEntrada +
                        "\nSaída: " + dataSaida +
                        "\nDiárias: " + numeroDiarias : "") +
                "\nLeitos: " + leitos + "\nPreço: R$ " + preco +
                "\nDespesas: R$ " + despesas;
    }
}
