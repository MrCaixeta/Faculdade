import java.util.Scanner;

public class HotelFazenda {

    static final int TOTAL_QUARTOS = 50;
    static Quarto[] quartos = new Quarto[TOTAL_QUARTOS];
    static boolean quartosCadastrados = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        inicializarQuartos();

        do {
            System.out.println("\n--- Hotel Fazenda Sucesso ---");
            System.out.println("1. Cadastrar quartos");
            System.out.println("2. Listar todos os quartos");
            System.out.println("3. Listar quartos ocupados");
            System.out.println("4. Alugar/Reservar quarto");
            System.out.println("5. Inserir despesas extras");
            System.out.println("6. Calcular despesa do quarto");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarQuartos(scanner);
                    break;
                case 2:
                    listarTodosQuartos();
                    break;
                case 3:
                    listarQuartosOcupados();
                    break;
                case 4:
                    alugarOuReservarQuarto(scanner);
                    break;
                case 5:
                    inserirDespesasExtras(scanner);
                    break;
                case 6:
                    calcularDespesaDoQuarto(scanner);
                    break;
                case 7:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }

    static void inicializarQuartos() {
        for (int i = 0; i < TOTAL_QUARTOS; i++) {
            quartos[i] = new Quarto(i + 1, 5, 30.0, "L");
        }
    }

    static void cadastrarQuartos(Scanner scanner) {
        if (quartosCadastrados) {
            System.out.println("Quartos já cadastrados!");
            return;
        }

        for (int i = 0; i < TOTAL_QUARTOS; i++) {
            System.out.println("Cadastro do quarto " + (i + 1));
            System.out.print("Quantidade de leitos: ");
            int leitos = scanner.nextInt();
            System.out.print("Preço do quarto: ");
            double preco = scanner.nextDouble();
            quartos[i] = new Quarto(i + 1, leitos, preco, "L");
            System.out.println("Quarto " + (i + 1) + " cadastrado com sucesso!");

            System.out.print("Deseja cadastrar o próximo quarto? (s/n): ");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("n")) {
                System.out.println("Cadastro interrompido.");
                break;
            }
        }

        quartosCadastrados = true;
        System.out.println("Cadastro de quartos finalizado!");
    }

    static void listarTodosQuartos() {
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    static void listarQuartosOcupados() {
        for (Quarto quarto : quartos) {
            if ("A".equals(quarto.getSituacao()) || "R".equals(quarto.getSituacao())) {
                System.out.println(quarto);
            }
        }
    }

    static void alugarOuReservarQuarto(Scanner scanner) {
        System.out.print("Digite A (aluguel) ou R (reserva): ");
        String acao = scanner.next();
        while (!acao.equalsIgnoreCase("A") && !acao.equalsIgnoreCase("R")) {
            System.out.print("Resposta inválida! Digite A (aluguel) ou R (reserva): ");
            acao = scanner.next();
        }

        listarQuartosLivres();

        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        if (numeroQuarto < 1 || numeroQuarto > TOTAL_QUARTOS) {
            System.out.println("Número do quarto inválido!");
            return;
        }

        Quarto quarto = quartos[numeroQuarto - 1];
        if (!"L".equals(quarto.getSituacao())) {
            System.out.println("Quarto não está disponível!");
            return;
        }

        System.out.print("Digite o nome do hóspede: ");
        scanner.nextLine(); // Consumir quebra de linha
        String nome = scanner.nextLine();
        System.out.print("Digite a data de entrada (dd/mm/aaaa): ");
        String dataEntrada = scanner.nextLine();
        System.out.print("Digite a data de saída (dd/mm/aaaa): ");
        String dataSaida = scanner.nextLine();
        System.out.print("Digite o número de diárias: ");
        int numeroDiarias = scanner.nextInt();

        quarto.alugarOuReservar(acao.equalsIgnoreCase("A") ? "A" : "R", nome, dataEntrada, dataSaida, numeroDiarias);
        System.out.println("Operação realizada com sucesso!");
    }

    static void listarQuartosLivres() {
        for (Quarto quarto : quartos) {
            if ("L".equals(quarto.getSituacao())) {
                System.out.println(quarto);
            }
        }
    }

    static void inserirDespesasExtras(Scanner scanner) {
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        if (numeroQuarto < 1 || numeroQuarto > TOTAL_QUARTOS) {
            System.out.println("Número do quarto inválido!");
            return;
        }

        Quarto quarto = quartos[numeroQuarto - 1];
        System.out.print("Digite o valor da despesa: ");
        double valorDespesa = scanner.nextDouble();
        quarto.adicionarDespesa(valorDespesa);
        System.out.println("Despesa adicionada com sucesso!");
    }

    static void calcularDespesaDoQuarto(Scanner scanner) {
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        if (numeroQuarto < 1 || numeroQuarto > TOTAL_QUARTOS) {
            System.out.println("Número do quarto inválido!");
            return;
        }

        Quarto quarto = quartos[numeroQuarto - 1];
        double total = quarto.calcularTotal();
        System.out.printf("Total de despesas do quarto: R$ %.2f\n", total);

        quarto.liberarQuarto();
        System.out.println("Quarto liberado com sucesso!");
    }
}