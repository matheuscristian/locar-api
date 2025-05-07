package com.locar.locar.model;

public class Documentacao {
    private int id_documentacao = 0;
    private String ipva;
    private String seguroVencimento;
    private Double quilometragemAtual;
    private String dataAquisicao;
    private String vistoria;
    public Documentacao() {
    }
    public Documentacao(int id_documentacao, String ipva, String seguroVencimento, Double quilometragemAtual,
            String dataAquisicao, String vistoria) {
        this.id_documentacao = id_documentacao;
        this.ipva = ipva;
        this.seguroVencimento = seguroVencimento;
        this.quilometragemAtual = quilometragemAtual;
        this.dataAquisicao = dataAquisicao;
        this.vistoria = vistoria;
    }
    public int getId_documentacao() {
        return id_documentacao;
    }
    public String getIpva() {
        return ipva;
    }
    public String getSeguroVencimento() {
        return seguroVencimento;
    }
    public Double getQuilometragemAtual() {
        return quilometragemAtual;
    }
    public String getDataAquisicao() {
        return dataAquisicao;
    }
    public String getVistoria() {
        return vistoria;
    }
}
