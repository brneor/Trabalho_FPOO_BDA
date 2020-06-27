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
public class ExamResult {
    private int idResultadoExame;
    private String descricao;

    public ExamResult(int idResultadoExame, String descricao) {
        this.idResultadoExame = idResultadoExame;
        this.descricao = descricao;
    }

    public ExamResult() {
    }

    public int getIdResultadoExame() {
        return idResultadoExame;
    }

    public void setIdResultadoExame(int idResultadoExame) {
        this.idResultadoExame = idResultadoExame;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
