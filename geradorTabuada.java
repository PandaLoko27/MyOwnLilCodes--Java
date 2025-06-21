import java.util.Scanner;

public class ExerciseOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número para a tabuada: ");
        int n = sc.nextInt();

        for(int i = 1; i <= 10; i++){
            System.out.println(n + " x " + i + " = " + (n * i));
        }

        System.out.println("Obrigado por usar o programa!");
    }
}
