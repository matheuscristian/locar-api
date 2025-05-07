package com.locar.locar.model;

public class ComprovanteCNH {
    private int id_comprovanteCNH;
    private String numeroIdentificacao = null;
    private String dataValidade = null;
    private String statusCNH = null;
    private String ufEmissao = null;
    private String categoria = null;
    public ComprovanteCNH() {
    }
    public ComprovanteCNH(int id_comprovanteCNH, String numeroIdentificacao, String dataValidade, String statusCNH,
            String ufEmissao, String categoria) {
        this.id_comprovanteCNH = id_comprovanteCNH;
        this.numeroIdentificacao = numeroIdentificacao;
        this.dataValidade = dataValidade;
        this.statusCNH = statusCNH;
        this.ufEmissao = ufEmissao;
        this.categoria = categoria;
    }
    public int getId_comprovanteCNH() {
        return id_comprovanteCNH;
    }
    public String getNumeroIdentificacao() {
        return numeroIdentificacao;
    }
    public String getDataValidade() {
        return dataValidade;
    }
    public String getStatusCNH() {
        return statusCNH;
    }
    public String getUfEmissao() {
        return ufEmissao;
    }
    public String getCategoria() {
        return categoria;
    }

    
}
