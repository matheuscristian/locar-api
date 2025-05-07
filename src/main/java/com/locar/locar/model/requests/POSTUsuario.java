package com.locar.locar.model.requests;

import com.locar.locar.model.CadastroUsuario;
import com.locar.locar.model.ComprovanteCNH;

public class POSTUsuario {
    private CadastroUsuario cadastroUsuario;
    private ComprovanteCNH comprovanteCNH;
    public POSTUsuario() {
    }
    public POSTUsuario(CadastroUsuario cadastroUsuario, ComprovanteCNH comprovanteCNH) {
        this.cadastroUsuario = cadastroUsuario;
        this.comprovanteCNH = comprovanteCNH;
    }
    public CadastroUsuario getCadastroUsuario() {
        return cadastroUsuario;
    }
    public ComprovanteCNH getComprovanteCNH() {
        return comprovanteCNH;
    }
}
