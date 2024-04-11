import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Refeitorio {
    public static void main(String[] args){
        Queue<Object> filaRefeitorio = new LinkedList<>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Informe o tipo de pessoa: \nDigite 1 se for aluno\nDigite 2 se for professor\nDigite 3 se for tecnico\nDigite s para sair");
            String tipoPessoa = scan.nextLine();

            if (tipoPessoa.equalsIgnoreCase("s")) {
                break;
            }

            switch (tipoPessoa.toLowerCase()) {
                case "1":
                    System.out.println("Informe o nome: ");
                    String nomeAluno = scan.nextLine();

                    System.out.println("Informe numero de matricula: ");
                    int matricula = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Informe o curso: ");
                    String curso = scan.nextLine();

                    Aluno aluno = new Aluno(nomeAluno, matricula, curso);
                    filaRefeitorio.add(aluno);

                    break;
                
                case "2":
                    System.out.println("Informe o nome: ");
                    String nomeProf = scan.nextLine();

                    System.out.println("Informe o numero do SIAPE: ");
                    int siapeProf = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Informe o titulo: ");
                    String titulo = scan.nextLine();

                    Professor professor = new Professor(nomeProf, siapeProf, titulo);
                    filaRefeitorio.add(professor);

                    break;
                case "3":
                    System.out.println("Informe o nome: ");
                    String nomeTec = scan.nextLine();

                    System.out.println("Informe o numero do SIAPE: ");
                    int siapeTec = scan.nextInt();
                    scan.nextLine();

                    TecnicoAdm tecnico = new TecnicoAdm(nomeTec, siapeTec);
                    filaRefeitorio.add(tecnico);
                    break;

                default:
                    System.out.println("Valor invalido!!");
                    break;
            }
            System.out.println("\nFila do refeitorio: ");
            for (Object pessoa : filaRefeitorio){
                System.out.println(pessoa);
            }
            System.out.println();
        }
        
        System.out.println("\nEntrando no refeitorio: ");
        while (!filaRefeitorio.isEmpty()) {
            Object pessoaAtual = filaRefeitorio.poll();
            System.out.println("Entrou no refeitorio: " + pessoaAtual);
        }
        System.out.println("\nTodos entraram no refeitorio!!");
        scan.close();
    }
}
