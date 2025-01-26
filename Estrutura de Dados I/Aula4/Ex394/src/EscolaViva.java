import java.util.Scanner;

public class EscolaViva {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] nomes = new String[50];
        double[] nota1 = new double[50];
        double[] nota2 = new double[50];
        double[] media = new double[50];
        int quantidadeAlunos = 0;
        boolean[] dadosCadastrados = {false, false, false};

        int opcao;
        do {
            System.out.println("\nESCOLA VIVA");
            System.out.println("1 - Entrar nomes");
            System.out.println("2 - Entrar 1ª nota");
            System.out.println("3 - Entrar 2ª nota");
            System.out.println("4 - Calcular média");
            System.out.println("5 - Listar no display");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Quantos alunos você deseja cadastrar (máximo 50)? ");
                    quantidadeAlunos = scan.nextInt();
                    scan.nextLine(); 
                    if (quantidadeAlunos > 0 && quantidadeAlunos <= 50) {
                        for (int i = 0; i < quantidadeAlunos; i++) {
                            System.out.printf("Digite o nome do aluno %d (máximo 30 caracteres): ", i + 1);
                            nomes[i] = scan.nextLine().toUpperCase();

                            while (nomes[i].length() > 30) {
                                System.out.printf("Nome muito longo! Digite novamente o nome do aluno %d: ", i + 1);
                                nomes[i] = scan.nextLine().toUpperCase();
                            }
                        }
                        dadosCadastrados[0] = true;
                    } else {
                        System.out.println("Número inválido de alunos!");
                    }
                    break;

                case 2:
                    if (!dadosCadastrados[0]) {
                        System.out.println("Nenhum nome foi cadastrado!");
                    } else {
                        for (int i = 0; i < quantidadeAlunos; i++) {
                            System.out.printf("Digite a 1ª nota do aluno %s: ", nomes[i]);
                            nota1[i] = scan.nextDouble();
                        }
                        dadosCadastrados[1] = true;
                    }
                    break;

                case 3:
                    if (!dadosCadastrados[0]) {
                        System.out.println("Nenhum nome foi cadastrado!");
                    } else {
                        for (int i = 0; i < quantidadeAlunos; i++) {
                            System.out.printf("Digite a 2ª nota do aluno %s: ", nomes[i]);
                            nota2[i] = scan.nextDouble();
                        }
                        dadosCadastrados[2] = true;
                    }
                    break;

                case 4:
                    if (!dadosCadastrados[0] || !dadosCadastrados[1] || !dadosCadastrados[2]) {
                        System.out.println("Nem todos os dados foram cadastrados!");
                    } else {
                        for (int i = 0; i < quantidadeAlunos; i++) {
                            media[i] = (3 * nota1[i] + 7 * nota2[i]) / 10;
                        }
                        System.out.println("Médias calculadas com sucesso!");
                    }
                    break;

                case 5:
                    if (!dadosCadastrados[0] || !dadosCadastrados[1] || !dadosCadastrados[2]) {
                        System.out.println("Nem todos os dados foram cadastrados!");
                    } else {
                        System.out.println("\nNOME\t\t\tNOTA1\tNOTA2\tMÉDIA");
                        for (int i = 0; i < quantidadeAlunos; i++) {
                            System.out.printf("%-30s\t%.2f\t%.2f\t%.2f\n", nomes[i], nota1[i], nota2[i], media[i]);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);

        scan.close();
    }
}
