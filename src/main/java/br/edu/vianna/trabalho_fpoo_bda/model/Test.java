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
public class Test {
    private int id;
    private Exam exame;

    public Test() {
    }

    public Test(int id, Exam exame) {
        this.id = id;
        this.exame = exame;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exam getExame() {
        return exame;
    }

    public void setExame(Exam exame) {
        this.exame = exame;
    }
}
