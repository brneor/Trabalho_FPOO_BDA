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
public class ProfessionalType {
    private int id;
    private String descricao;

    public ProfessionalType(int idTipoProfissional, String descricao) {
        this.id = idTipoProfissional;
        this.descricao = descricao;
    }

    public ProfessionalType() {
    }

    public int getIdTipoProfissional() {
        return id;
    }

    public void setIdTipoProfissional(int idTipoProfissional) {
        this.id = idTipoProfissional;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
