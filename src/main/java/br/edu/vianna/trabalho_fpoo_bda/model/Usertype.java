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
public class Usertype {
    private int id;
    private String descricao;

    public Usertype(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Usertype() {
    }

    public int getId() {
        return id;
    }

    public void setId(int idTipoUsuario) {
        this.id = idTipoUsuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
