package com.locar.locar.model;

public class CadastroUsuario {
    private int id_cadastroUsuario = 0;
    private String nome = null;
    private String cpf = null;
    private String telefone = null;
    private String email = null;
    private String dataDeNascimento = null;
    private int comprovanteCNH_id_comprovanteCNH = 0;
    public CadastroUsuario() {
    }
    public CadastroUsuario(int id_cadastroUsuario, String nome, String cpf, String telefone, String email,
            String dataDeNascimento, Integer comprovanteCNH_id_comprovanteCNH) {
        this.id_cadastroUsuario = id_cadastroUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.comprovanteCNH_id_comprovanteCNH = comprovanteCNH_id_comprovanteCNH;
    }
    public int getId_cadastroUsuario() {
        return id_cadastroUsuario;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    public String getDataDeNascimento() {
        return dataDeNascimento;
    }
    public Integer getComprovanteCNH_id_comprovanteCNH() {
        return comprovanteCNH_id_comprovanteCNH;
    }

    
}
