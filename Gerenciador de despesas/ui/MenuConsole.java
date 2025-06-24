package ui;

import java.time.LocalDate;
import java.util.Scanner;
import model.Categoria;
import model.Despesa;
import service.GerenciadorDespesas;

public class MenuConsole {
    private GerenciadorDespesas gerente = new GerenciadorDespesas();
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n===== GERENCIADOR DE DESPESAS =====");
            System.out.println("1. Adicionar despesa");
            System.out.println("2. Listar despesas");
            System.out.println("3. Filtrar por categoria");
            System.out.println("4. Mostrar total gasto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> adicionarDespesa();
                case 2 -> listarDespesas();
                case 3 -> filtrarCategoria();
                case 4 -> mostrarTotal();
                case 0 -> System.out.println("\nAté a próxima :)");
                default -> System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);
    }

    private void adicionarDespesa() {
        System.out.print("\nValor: R$ ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.println("\nCategoria:");
        for (Categoria c : Categoria.values()) {
            System.out.println("- " + c);
        }
        System.out.print("\nDigite a categoria: ");
        String cat = scanner.nextLine().toUpperCase();
        Categoria categoria = Categoria.valueOf(cat);

        System.out.print("Data (AAAA-MM-DD): ");
        String dataStr = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataStr);

        Despesa d = new Despesa(valor, categoria, descricao, data);
        gerente.adicionarDespesa(d);
        System.out.println("\nDespesa adicionada com sucesso!");
    }

    private void listarDespesas() {
        System.out.println("\n=== Lista de Despesas ===");
        gerente.listarDespesas().forEach(System.out::println);
    }

    private void filtrarCategoria() {
        System.out.print("Categoria para filtrar: ");
        String cat = scanner.nextLine().toUpperCase();
        Categoria categoria = Categoria.valueOf(cat);

        System.out.println("\n=== Despesas em " + categoria + " ===");
        gerente.filtrarPorCategoria(categoria).forEach(System.out::println);
    }

    private void mostrarTotal() {
        System.out.printf("\nTotal gasto: R$ %.2f%n", gerente.calcularTotal());
    }
}
