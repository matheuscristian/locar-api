package com.locar.locar.model;

public class Devolucao {
    private int id_devolucao;   
    private String dataDevolucao;
    private Double combustivelRestante;
    private String statusVeiculo;
    private String observacao;
    public Devolucao() {
    }
    public Devolucao(int id_devolucao, String dataDevolucao, Double combustivelRestante, String statusVeiculo,
            String observacao) {
        this.id_devolucao = id_devolucao;
        this.dataDevolucao = dataDevolucao;
        this.combustivelRestante = combustivelRestante;
        this.statusVeiculo = statusVeiculo;
        this.observacao = observacao;
    }
    public int getId_devolucao() {
        return id_devolucao;
    }
    public String getDataDevolucao() {
        return dataDevolucao;
    }
    public Double getCombustivelRestante() {
        return combustivelRestante;
    }
    public String getStatusVeiculo() {
        return statusVeiculo;
    }
    public String getObservacao() {
        return observacao;
    }

    
}
