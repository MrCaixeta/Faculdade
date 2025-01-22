class Pessoa {
    private int numero;
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;

    public Pessoa(int numero, String nome, String telefone, String endereco, String cpf) {
        this.numero = numero;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Pessoa {" + "numero: " + numero + ", nome: " + nome + ", telefone: " + telefone + ", endereco: " + endereco + ", cpf: " + cpf + "}";
    }
}