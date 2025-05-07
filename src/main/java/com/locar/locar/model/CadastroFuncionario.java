package com.locar.locar.model;

public class CadastroFuncionario {
    private int id_cadastroFuncionario = 0;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String cargo;
    private String senha;
    public CadastroFuncionario() {
    }
    public CadastroFuncionario(int id_cadastroFuncionario, String nome, String cpf, String email, String telefone,
            String cargo, String senha) {
        this.id_cadastroFuncionario = id_cadastroFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.senha = senha;
    }
    public int getId_cadastroFuncionario() {
        return id_cadastroFuncionario;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getCargo() {
        return cargo;
    }
    public String getSenha() {
        return senha;
    }
}
