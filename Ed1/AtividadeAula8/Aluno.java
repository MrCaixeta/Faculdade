public class Aluno {
    private String nomeAluno;
    private int matricula;
    private String curso;
    public Aluno(String nomeAluno, int matricula, String curso) {
        this.nomeAluno = nomeAluno;
        this.matricula = matricula;
        this.curso = curso;
    }
    public String getNome() {
        return nomeAluno;
    }
    public int getMatricula() {
        return matricula;
    }
    public String getCurso() {
        return curso;
    }
}