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

    public Professional() {
    }

    public Professional(int id, ProfessionalType tipo) {
        this.id = id;
        this.tipo = tipo;
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
}
