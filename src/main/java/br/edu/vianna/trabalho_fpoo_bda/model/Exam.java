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
public class Exam {
    private int idExame, idTeste, idResultadoExame, idPaciente;

    public Exam(int idExame, int idTeste, int idResultadoExame, int idPaciente) {
        this.idExame = idExame;
        this.idTeste = idTeste;
        this.idResultadoExame = idResultadoExame;
        this.idPaciente = idPaciente;
    }

    public Exam() {
    }
    
   
    public int getIdExame() {
        return idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    public int getIdTeste() {
        return idTeste;
    }

    public void setIdTeste(int idTeste) {
        this.idTeste = idTeste;
    }

    public int getIdResultadoExame() {
        return idResultadoExame;
    }

    public void setIdResultadoExame(int idResultadoExame) {
        this.idResultadoExame = idResultadoExame;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    
}
