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
public class Patient extends User {
    private String cpf;
    private boolean risco;
    private Date dataNascimento;

    public Patient(String cpf, boolean risco, Date dataNascimento) {
        this.risco = risco;
        this.dataNascimento = dataNascimento;
    }

    public Patient() {
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
    
    
}
