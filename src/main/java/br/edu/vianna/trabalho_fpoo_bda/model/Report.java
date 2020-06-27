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
public class Report {
    private int id;
    private Patient paciente;
    private Exam exame;

    public Report() {
    }

    public Report(int id, Patient paciente, Exam exame) {
        this.id = id;
        this.paciente = paciente;
        this.exame = exame;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPaciente() {
        return paciente;
    }

    public void setPaciente(Patient paciente) {
        this.paciente = paciente;
    }

    public Exam getExame() {
        return exame;
    }

    public void setExame(Exam exame) {
        this.exame = exame;
    }
    
    
}
