import java.util.Scanner;

public class calcularArea {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe a base do retângulo:");
        var base = scanner.nextInt();
        System.out.println("Informe a altura do retângulo:");
        var altura = scanner.nextInt();
        System.out.printf("A área do retângulo é: %s m²\n", altura * base );
    }
}
