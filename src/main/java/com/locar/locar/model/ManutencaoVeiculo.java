package com.locar.locar.model;

public class ManutencaoVeiculo {
    private int id_manutencaoVeiculo = 0;
    private String dataManutencao;
    private String tipoManutencao;
    private Double custo;
    private String observacao;
    private int cadastroVeiculo_id_cadastroVeiculo = 0;
    
    public ManutencaoVeiculo() {
    }
    public ManutencaoVeiculo(int id_manutencaoVeiculo, String dataManutencao, String tipoManutencao, Double custo,
            String observacao, int cadastroVeiculo_id_cadastroVeiculo) {
        this.id_manutencaoVeiculo = id_manutencaoVeiculo;
        this.dataManutencao = dataManutencao;
        this.tipoManutencao = tipoManutencao;
        this.custo = custo;
        this.observacao = observacao;
        this.cadastroVeiculo_id_cadastroVeiculo = cadastroVeiculo_id_cadastroVeiculo;
    }
    public int getId_manutencaoVeiculo() {
        return id_manutencaoVeiculo;
    }
    public String getDataManutencao() {
        return dataManutencao;
    }
    public String getTipoManutencao() {
        return tipoManutencao;
    }
    public Double getCusto() {
        return custo;
    }
    public String getObservacao() {
        return observacao;
    }
    public int getCadastroVeiculo_id_cadastroVeiculo() {
        return cadastroVeiculo_id_cadastroVeiculo;
    }
    
}
