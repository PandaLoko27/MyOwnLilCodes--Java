import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor para abertura da conta: R$ ");
        double valorInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(valorInicial);

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar cheque especial");
            System.out.println("3. Depositar dinheiro");
            System.out.println("4. Sacar dinheiro");
            System.out.println("5. Pagar boleto");
            System.out.println("6. Verificar uso do cheque especial");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    conta.consultarChequeEspecial();
                    break;
                case 3:
                    System.out.print("Digite o valor para depósito: R$ ");
                    conta.depositar(scanner.nextDouble());
                    break;
                case 4:
                    System.out.print("Digite o valor para saque: R$ ");
                    conta.sacar(scanner.nextDouble());
                    break;
                case 5:
                    System.out.print("Digite o valor do boleto: R$ ");
                    conta.pagarBoleto(scanner.nextDouble());
                    break;
                case 6:
                    if (conta.estaUsandoChequeEspecial()) {
                        System.out.println("Você está utilizando o cheque especial.");
                    } else {
                        System.out.println("Você não está utilizando o cheque especial.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
