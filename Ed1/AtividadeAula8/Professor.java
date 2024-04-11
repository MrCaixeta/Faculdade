public class Professor {
    private String nomeProf;
    private int siapeProf;
    private String titulo;
    
    public Professor(String nomeProf, int siapeProf, String titulo) {
        this.nomeProf = nomeProf;
        this.siapeProf = siapeProf;
        this.titulo = titulo;
    }
    public String getNome() {
        return nomeProf;
    }
    public int getSiape() {
        return siapeProf;
    }
    public String getTitulo() {
        return titulo;
    }
}
