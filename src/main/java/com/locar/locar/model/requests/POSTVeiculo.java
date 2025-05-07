package com.locar.locar.model.requests;

import com.locar.locar.model.CadastroVeiculo;
import com.locar.locar.model.Documentacao;
import com.locar.locar.model.ManutencaoVeiculo;

public class POSTVeiculo {
    private Documentacao documentacao;
    private CadastroVeiculo cadastroVeiculo;
    private ManutencaoVeiculo manutencaoVeiculo;



    public POSTVeiculo() {
    }
    public POSTVeiculo(Documentacao documentacao, CadastroVeiculo cadastroVeiculo,
            ManutencaoVeiculo manutencaoVeiculo) {
        this.documentacao = documentacao;
        this.cadastroVeiculo = cadastroVeiculo;
        this.manutencaoVeiculo = manutencaoVeiculo;
    }
    public Documentacao getDocumentacao() {
        return documentacao;
    }
    public CadastroVeiculo getCadastroVeiculo() {
        return cadastroVeiculo;
    }
    public ManutencaoVeiculo getManutencaoVeiculo() {
        return manutencaoVeiculo;
    }
}
