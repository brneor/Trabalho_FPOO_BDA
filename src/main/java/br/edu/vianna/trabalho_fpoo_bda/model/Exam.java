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
    private int id;
    private Test teste;
    private ExamResult resultadoExame;
    private Patient paciente;

    public Exam() {
    }

    public Exam(int idExame, Test teste, ExamResult resultadoExame, Patient paciente) {
        this.id = idExame;
        this.teste = teste;
        this.resultadoExame = resultadoExame;
        this.paciente = paciente;
    }

    public int getIdExame() {
        return id;
    }

    public void setIdExame(int idExame) {
        this.id = idExame;
    }

    public Test getTeste() {
        return teste;
    }

    public void setTeste(Test teste) {
        this.teste = teste;
    }

    public ExamResult getResultadoExame() {
        return resultadoExame;
    }

    public void setResultadoExame(ExamResult resultadoExame) {
        this.resultadoExame = resultadoExame;
    }

    public Patient getPaciente() {
        return paciente;
    }

    public void setPaciente(Patient paciente) {
        this.paciente = paciente;
    }
}
