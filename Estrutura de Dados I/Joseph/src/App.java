import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            pessoas.add(new Pessoa(i, "Pessoa " + i, "Telefone " + i, "Endereco " + i, "CPF" + i));
        }

        Random random = new Random();
        while (pessoas.size() > 1) {
            int m = random.nextInt(pessoas.size()) + 1; 
            eliminarPessoa(pessoas, m);
        }

        System.out.println("A pessoa sobrevivente é: " + pessoas.get(0));
    }

    private static void eliminarPessoa(List<Pessoa> pessoas, int m) {
        int index = 0;
        while (pessoas.size() > 1) {
            index = (index + m - 1) % pessoas.size();
            System.out.println("Eliminada: " + pessoas.get(index));
            pessoas.remove(index);
        }
    }
}
