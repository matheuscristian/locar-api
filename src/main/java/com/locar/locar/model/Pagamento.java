package com.locar.locar.model;

public class Pagamento {
    private int id_pagamento;
    private Double valorTotal;
    private String data;
    private String metodoPagamento;
    private int devolucao_id_devolucao;
    private int taxa_id_taxa;
    private int locacaoDados_id_locacaoDados;
    public Pagamento() {
    }
    public Pagamento(int id_pagamento, Double valorTotal, String data, String metodoPagamento,
            int devolucao_id_devolucao, int taxa_id_taxa, int locacaoDados_id_locacaoDados) {
        this.id_pagamento = id_pagamento;
        this.valorTotal = valorTotal;
        this.data = data;
        this.metodoPagamento = metodoPagamento;
        this.devolucao_id_devolucao = devolucao_id_devolucao;
        this.taxa_id_taxa = taxa_id_taxa;
        this.locacaoDados_id_locacaoDados = locacaoDados_id_locacaoDados;
    }
    public int getId_pagamento() {
        return id_pagamento;
    }
    public Double getValorTotal() {
        return valorTotal;
    }
    public String getData() {
        return data;
    }
    public String getMetodoPagamento() {
        return metodoPagamento;
    }
    public int getDevolucao_id_devolucao() {
        return devolucao_id_devolucao;
    }
    public int getTaxa_id_taxa() {
        return taxa_id_taxa;
    }
    public int getLocacaoDados_id_locacaoDados() {
        return locacaoDados_id_locacaoDados;
    }

    
}
