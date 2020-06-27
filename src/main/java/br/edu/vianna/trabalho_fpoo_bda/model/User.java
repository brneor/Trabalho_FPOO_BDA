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
    private int id, cpf;
    private Usertype tipoUsuario;
    private String nome, senha;

    public User(int idLogin, Usertype tipoUsuario, int cpf, String nome, String senha) {
        this.id = idLogin;
        this.tipoUsuario = tipoUsuario;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    public User() {
    }

    public int getIdLogin() {
        return id;
    }

    public void setIdLogin(int idLogin) {
        this.id = idLogin;
    }

    public Usertype getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Usertype tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
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
