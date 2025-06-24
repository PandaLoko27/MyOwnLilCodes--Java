package model;

import java.time.LocalDate;

public class Despesa {
    private double valor;
    private Categoria categoria;
    private String descricao;
    private LocalDate data;

    public Despesa(double valor, Categoria categoria, String descricao, LocalDate data) {
        this.valor = valor;
        this.categoria = categoria;
        this.descricao = descricao;
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return String.format("R$ %.2f | %s | %s | %s",
                valor, categoria, descricao, data);
    }
}
