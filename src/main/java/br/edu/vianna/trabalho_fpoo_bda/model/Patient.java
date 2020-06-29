/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model;

import java.util.Date;

/**
 *
 * @author breno
 */
public class Patient {
    private String cpf;
    private boolean risco;
    private Date dataNascimento;
    private String nome;

    public Patient() {
    }

    public Patient(String cpf, boolean risco, Date dataNascimento, String nome) {
        this.cpf = cpf;
        this.risco = risco;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isRisco() {
        return risco;
    }

    public void setRisco(boolean risco) {
        this.risco = risco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
