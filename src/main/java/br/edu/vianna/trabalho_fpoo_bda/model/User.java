/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model;

/**
 *
 * @author natha
 */
public class User {
    private String login;
    private int cpf;
    private Usertype tipoUsuario;
    private String nome, senha;

    public User(String login, Usertype tipoUsuario, int cpf, String nome, String senha) {
        this.login = login;
        this.tipoUsuario = tipoUsuario;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    public User() {
    }

    public User(String login, int cpf, Usertype tipoUsuario, String nome, String senha) {
        this.login = login;
        this.cpf = cpf;
        this.tipoUsuario = tipoUsuario;
        this.nome = nome;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Usertype getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Usertype tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
