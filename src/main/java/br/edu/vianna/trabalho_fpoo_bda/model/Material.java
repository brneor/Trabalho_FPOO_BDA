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
public class Material {
    private int id;
    private String descricao;

    public Material(int idMaterial, String descricao) {
        this.id = idMaterial;
        this.descricao = descricao;
    }

    public Material() {
    }

    public int getIdMaterial() {
        return id;
    }

    public void setIdMaterial(int idMaterial) {
        this.id = idMaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
