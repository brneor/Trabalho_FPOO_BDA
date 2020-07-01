/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model;

import java.util.Date;

/**
 *
 * @author natha
 */
public class Exam {
    private int id;
    private Test teste;
    private ExamResult resultadoExame;
    private Patient paciente;
    private Collect collect;
    private Date data;

    public Exam() {
    }

    public Exam(int id, Test teste, ExamResult resultadoExame, Patient paciente, Collect collect, Date data) {
        this.id = id;
        this.teste = teste;
        this.resultadoExame = resultadoExame;
        this.paciente = paciente;
        this.collect = collect;
        this.data = data;
    }

    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    public int getId() {
        return id;
    }

    public void setId(int idExame) {
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

    public Collect getCollect() {
        return collect;
    }

    public void setCollect(Collect collect) {
        this.collect = collect;
    }

}
