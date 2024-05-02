import java.util.Scanner;

public class BancoVirtual {
    private static Cliente cliente;

    public static void main(String[] args) {
        inicializarCliente();

        exibirMenu();
    }

    private static void inicializarCliente() {
        cliente = new Cliente("Júlia Teles", "Corrente", 1000.00);
    }

    private static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n***********************");
            System.out.println("Dados iniciais do cliente:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Tipo conta: " + cliente.getTipoConta());
            System.out.println("Saldo inicial: R$ " + cliente.getSaldo());
            System.out.println("***********************");
            System.out.println("\nOperações");
            System.out.println("1- Consultar saldos");
            System.out.println("2- Receber valor");
            System.out.println("3- Transferir valor");
            System.out.println("4- Sair");
            System.out.print("\nDigite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    receberValor();
                    break;
                case 3:
                    transferirValor();
                    break;
                case 4:
                    System.out.println("Encerrando a aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void consultarSaldo() {
        System.out.println("\nSaldo atual: R$ " + cliente.getSaldo());
    }

    private static void receberValor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInforme o valor a receber: ");
        double valor = scanner.nextDouble();
        cliente.setSaldo(cliente.getSaldo() + valor);
        System.out.println("Saldo atualizado: R$ " + cliente.getSaldo());
    }

    private static void transferirValor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInforme o valor que deseja transferir: ");
        double valor = scanner.nextDouble();
        if (valor > cliente.getSaldo()) {
            System.out.println("Não há saldo suficiente para fazer essa transferência.");
        } else {
            cliente.setSaldo(cliente.getSaldo() - valor);
            System.out.println("Saldo atualizado: R$ " + cliente.getSaldo());
        }
    }
}
