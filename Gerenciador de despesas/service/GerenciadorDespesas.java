package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Categoria;
import model.Despesa;

public class GerenciadorDespesas {
    private List<Despesa> despesas = new ArrayList<>();

    public void adicionarDespesa(Despesa d) {
        despesas.add(d);
    }

    public List<Despesa> listarDespesas() {
        return despesas;
    }

    public double calcularTotal() {
        return despesas.stream().mapToDouble(Despesa::getValor).sum();
    }

    public List<Despesa> filtrarPorCategoria(Categoria categoria) {
        return despesas.stream()
                .filter(d -> d.getCategoria() == categoria)
                .collect(Collectors.toList());
    }
}
