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
public class Professional {
    private int id;
    private ProfessionalType tipo;
    private String nome;

    public Professional() {
    }

    public Professional(int id, ProfessionalType tipo, String nome) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProfessionalType getTipo() {
        return tipo;
    }

    public void setTipo(ProfessionalType tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
