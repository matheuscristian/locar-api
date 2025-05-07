package com.locar.locar.model;

public class Taxa {
    private int id_taxa = 0;
    private String descricao;
    private Double valorTotal;
    public Taxa() {
    }
    public Taxa(int id_taxa, String descricao, Double valorTotal) {
        this.id_taxa = id_taxa;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
    }
    public int getId_taxa() {
        return id_taxa;
    }
    public String getDescricao() {
        return descricao;
    }
    public Double getValorTotal() {
        return valorTotal;
    }

    
}
