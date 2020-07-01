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
    private int pacientesAtendidos;
    private int testesUtilizados;
    private int examesDetectados;
    private int examesNaoDetectados;
    private int pacientesRecoleta;
    private int examesInconclusivos;
    private int examesInvalidos;

    public Report() {
    }

    public Report(int pacientesAtendidos, int testesUtilizados, int examesDetectados, int examesNaoDetectados, int pacientesRecoleta, int examesInconclusivos, int examesInvalidos) {
        this.pacientesAtendidos = pacientesAtendidos;
        this.testesUtilizados = testesUtilizados;
        this.examesDetectados = examesDetectados;
        this.examesNaoDetectados = examesNaoDetectados;
        this.pacientesRecoleta = pacientesRecoleta;
        this.examesInconclusivos = examesInconclusivos;
        this.examesInvalidos = examesInvalidos;
    }

    public int getPacientesAtendidos() {
        return pacientesAtendidos;
    }

    public void setPacientesAtendidos(int pacientesAtendidos) {
        this.pacientesAtendidos = pacientesAtendidos;
    }

    public int getTestesUtilizados() {
        return testesUtilizados;
    }

    public void setTestesUtilizados(int testesUtilizados) {
        this.testesUtilizados = testesUtilizados;
    }

    public int getExamesDetectados() {
        return examesDetectados;
    }

    public void setExamesDetectados(int examesDetectados) {
        this.examesDetectados = examesDetectados;
    }

    public int getExamesNaoDetectados() {
        return examesNaoDetectados;
    }

    public void setExamesNaoDetectados(int examesNaoDetectados) {
        this.examesNaoDetectados = examesNaoDetectados;
    }

    public int getPacientesRecoleta() {
        return pacientesRecoleta;
    }

    public void setPacientesRecoleta(int pacientesRecoleta) {
        this.pacientesRecoleta = pacientesRecoleta;
    }

    public int getExamesInconclusivos() {
        return examesInconclusivos;
    }

    public void setExamesInconclusivos(int examesInconclusivos) {
        this.examesInconclusivos = examesInconclusivos;
    }

    public int getExamesInvalidos() {
        return examesInvalidos;
    }

    public void setExamesInvalidos(int examesInvalidos) {
        this.examesInvalidos = examesInvalidos;
    }
    
    
}
