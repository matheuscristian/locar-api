package com.locar.locar.model;

public class CadastroVeiculo {
    private int id_cadastroVeiculo = 0;
    private String marca;
    private String modelo;
    private String ano;
    private String cor;
    private String placa;
    private Double valorTotal;
    private Short statusOcupacao;
    private String renavam;
    private String tipoCambio;
    private Integer capacidade;
    private int documentacao_id_documentacao = 0;
    public CadastroVeiculo() {
    }
    public CadastroVeiculo(int id_cadastroVeiculo, String marca, String modelo, String ano, String cor, String placa,
            Double valorTotal, Short statusOcupacao, String renavam, String tipoCambio, Integer capacidade,
            int documentacao_id_documentacao) {
        this.id_cadastroVeiculo = id_cadastroVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.valorTotal = valorTotal;
        this.statusOcupacao = statusOcupacao;
        this.renavam = renavam;
        this.tipoCambio = tipoCambio;
        this.capacidade = capacidade;
        this.documentacao_id_documentacao = documentacao_id_documentacao;
    }
    public int getId_cadastroVeiculo() {
        return id_cadastroVeiculo;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getAno() {
        return ano;
    }
    public String getCor() {
        return cor;
    }
    public String getPlaca() {
        return placa;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public Short getStatusOcupacao() {
        return statusOcupacao;
    }
    public String getRenavam() {
        return renavam;
    }
    public String getTipoCambio() {
        return tipoCambio;
    }
    public Integer getCapacidade() {
        return capacidade;
    }
    public int getDocumentacao_id_documentacao() {
        return documentacao_id_documentacao;
    }

    
}
