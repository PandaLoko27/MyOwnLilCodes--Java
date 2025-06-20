import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite sua altura (em metros): ");
        double altura = input.nextDouble();

        System.out.print("Digite seu peso (em kg): ");
        double peso = input.nextDouble();

        // Cálculo do IMC
        double imc = peso / (altura * altura);

        System.out.printf("Seu IMC é: %.2f\n", imc);

        // Verificação da faixa do IMC
        if (imc <= 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc <= 24.9) {
            System.out.println("Peso ideal");
        } else if (imc <= 29.9) {
            System.out.println("Levemente acima do peso");
        } else if (imc <= 34.9) {
            System.out.println("Obesidade Grau I");
        } else if (imc <= 39.9) {
            System.out.println("Obesidade Grau II (Severa)");
        } else {
            System.out.println("Obesidade III (Mórbida)");
        }

        input.close();
    }
}
