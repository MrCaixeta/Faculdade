import java.util.ArrayList;
import java.util.Scanner;

public class FabricaDeQueijo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final int MAX_PRODUTOS = 50;
        ArrayList<Produto> produtos = new ArrayList<>();
        double totalVendas = 0.0;

        while (produtos.size() < MAX_PRODUTOS) {
            System.out.print("Digite o código do produto ou -1 para encerrar o cadastro: ");
            int codigo = scan.nextInt();
            if (codigo == -1) {
                break;
            }

            System.out.print("Digite a quantidade do produto: ");
            int quantidade = scan.nextInt();

            System.out.print("Digite o preço do produto: ");
            double preco = scan.nextDouble();

            produtos.add(new Produto(codigo, quantidade, preco));
        }

        while (true) {
            System.out.print("Digite o código do produto para venda ou 0 para encerrar: ");
            int codigoVenda = scan.nextInt();
            if (codigoVenda == 0) {
                break;
            }

            Produto produtoEncontrado = null;
            for (Produto p : produtos) {
                if (p.getCodigo() == codigoVenda) {
                    produtoEncontrado = p;
                    break;
                }
            }

            if (produtoEncontrado == null) {
                System.out.println("Produto não cadastrado!");
                continue;
            }

            System.out.print("Digite a quantidade desejada: ");
            int quantidadeVenda = scan.nextInt();

            if (produtoEncontrado.getQuantidade() >= quantidadeVenda) {
                produtoEncontrado.vender(quantidadeVenda);
                double valorVenda = quantidadeVenda * produtoEncontrado.getPreco();
                totalVendas += valorVenda;
                System.out.printf("Venda realizada! Valor: R$ %.2f\n", valorVenda);
            } else {
                System.out.println("Estoque insuficiente!");
            }
        }

        System.out.printf("\nTotal vendido no dia: R$ %.2f\n", totalVendas);

        produtos.sort((p1, p2) -> Integer.compare(p2.getQuantidade(), p1.getQuantidade()));

        System.out.println("\nEstoque final:");
        for (Produto p : produtos) {
            System.out.printf("Código: %d, Quantidade: %d, Preço: R$ %.2f\n",
                    p.getCodigo(), p.getQuantidade(), p.getPreco());
        }

        scan.close();
    }
}

