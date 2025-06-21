import java.util.Scanner;

public class BibliotecaAcesso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita autorização do visitante
        System.out.println("Você está autorizado? (true/false):");
        boolean autorizado = scanner.nextBoolean();

        // Solicita idade do visitante
        System.out.println("Informe sua idade:");
        int idade = scanner.nextInt();

        // Verifica as condições para liberar o acesso
        if (!autorizado) {
            System.out.println("Acesso negado");
        } else if (idade < 18) {
            System.out.println("Idade insuficiente");
        } else {
            System.out.println("Acesso permitido");
        }

        scanner.close();
    }
}
