package com.locar.locar.model.requests;

import com.locar.locar.model.Devolucao;
import com.locar.locar.model.LocacaoDados;
import com.locar.locar.model.Pagamento;

public class POSTLocacao {
    private LocacaoDados locacaoDados;
    private Pagamento pagamento;
    private Devolucao devolucao;
    public POSTLocacao() {
    }
    public POSTLocacao(LocacaoDados locacaoDados, Pagamento pagamento, Devolucao devolucao) {
        this.locacaoDados = locacaoDados;
        this.pagamento = pagamento;
        this.devolucao = devolucao;
    }
    public LocacaoDados getLocacaoDados() {
        return locacaoDados;
    }
    public Pagamento getPagamento() {
        return pagamento;
    }
    public Devolucao getDevolucao() {
        return devolucao;
    }
}
