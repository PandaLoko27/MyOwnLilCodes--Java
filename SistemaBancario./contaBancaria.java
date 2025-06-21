public class ContaBancaria {
    private double saldo;
    private double limiteChequeEspecial;
    private double chequeEspecialDisponivel;
    private double valorUsadoChequeEspecial;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;

        if (depositoInicial <= 500.00) {
            this.limiteChequeEspecial = 50.00;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }

        this.chequeEspecialDisponivel = limiteChequeEspecial;
        this.valorUsadoChequeEspecial = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public double getChequeEspecialDisponivel() {
        return chequeEspecialDisponivel;
    }

    public boolean estaUsandoChequeEspecial() {
        return chequeEspecialDisponivel < limiteChequeEspecial;
    }

    public void consultarSaldo() {
        System.out.printf("Saldo atual: R$ %.2f\n", saldo);
    }

    public void consultarChequeEspecial() {
        System.out.printf("Limite do cheque especial: R$ %.2f\n", limiteChequeEspecial);
        System.out.printf("Valor disponível do cheque especial: R$ %.2f\n", chequeEspecialDisponivel);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }

        if (valorUsadoChequeEspecial > 0) {
            double taxa = valorUsadoChequeEspecial * 0.2;
            double totalAPagar = valorUsadoChequeEspecial + taxa;

            if (valor >= totalAPagar) {
                valor -= totalAPagar;
                chequeEspecialDisponivel = limiteChequeEspecial;
                valorUsadoChequeEspecial = 0;
                saldo += valor;
                System.out.println("Cheque especial quitado com sucesso.");
            } else {
                double pago = valor / 1.2;
                valorUsadoChequeEspecial -= pago;
                chequeEspecialDisponivel += pago;
                System.out.println("Parte do cheque especial foi quitada.");
                return;
            }
        } else {
            saldo += valor;
        }

        System.out.println("Depósito realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return;
        }

        if (valor <= saldo) {
            saldo -= valor;
        } else if (valor <= saldo + chequeEspecialDisponivel) {
            double restante = valor - saldo;
            saldo = 0;
            chequeEspecialDisponivel -= restante;
            valorUsadoChequeEspecial += restante;
        } else {
            System.out.println("Saldo insuficiente (incluindo cheque especial).");
            return;
        }

        System.out.println("Saque realizado com sucesso.");
    }

    public void pagarBoleto(double valor) {
        System.out.println("Pagando boleto de R$ " + valor);
        sacar(valor);
    }
}
