package com.locar.locar.model;

public class LocacaoDados {
    private int id_locacaoDados = 0;
    private Double valorTotal;
    private String status;
    private String dataSaida;
    private String dataDevolucao;
    private int cadastroUsuario_id_cadastroUsuario = 0;
    private int cadastroFuncionario_id_cadastroFuncionario = 0;
    private int cadastroVeiculo_id_cadastroVeiculo = 0;
    public LocacaoDados() {
    }
    public LocacaoDados(int id_locacaoDados, Double valorTotal, String status, String dataSaida, String dataDevolucao,
            int cadastroUsuario_id_cadastroUsuario, int cadastroFuncionario_id_cadastroFuncionario,
            int cadastroVeiculo_id_cadastroVeiculo) {
        this.id_locacaoDados = id_locacaoDados;
        this.valorTotal = valorTotal;
        this.status = status;
        this.dataSaida = dataSaida;
        this.dataDevolucao = dataDevolucao;
        this.cadastroUsuario_id_cadastroUsuario = cadastroUsuario_id_cadastroUsuario;
        this.cadastroFuncionario_id_cadastroFuncionario = cadastroFuncionario_id_cadastroFuncionario;
        this.cadastroVeiculo_id_cadastroVeiculo = cadastroVeiculo_id_cadastroVeiculo;
    }
    public int getId_locacaoDados() {
        return id_locacaoDados;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public String getStatus() {
        return status;
    }
    public String getDataSaida() {
        return dataSaida;
    }
    public String getDataDevolucao() {
        return dataDevolucao;
    }
    public int getCadastroUsuario_id_cadastroUsuario() {
        return cadastroUsuario_id_cadastroUsuario;
    }
    public int getCadastroFuncionario_id_cadastroFuncionario() {
        return cadastroFuncionario_id_cadastroFuncionario;
    }
    public int getCadastroVeiculo_id_cadastroVeiculo() {
        return cadastroVeiculo_id_cadastroVeiculo;
    }

    
}
