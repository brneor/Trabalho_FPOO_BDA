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
public class Collect {
    private int idColeta, idPaciente, idProfissional, idMaterial;
    private boolean realizado;
    private String cidade;
    private Date dataColeta, horaColeta;

    public Collect(int idColeta, int idPaciente, int idProfissional, 
        int idMaterial, boolean realizado, String cidade, 
        Date dataColeta, Date horaColeta) {
        
        this.idColeta = idColeta;
        this.idPaciente = idPaciente;
        this.idProfissional = idProfissional;
        this.idMaterial = idMaterial;
        this.realizado = realizado;
        this.cidade = cidade;
        this.dataColeta = dataColeta;
        this.horaColeta = horaColeta;
    }
    
    
    
    public Collect() {
        
    }

    public int getIdColeta() {
        return idColeta;
    }

    public void setIdColeta(int idColeta) {
        this.idColeta = idColeta;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
    }

    public Date getHoraColeta() {
        return horaColeta;
    }

    public void setHoraColeta(Date horaColeta) {
        this.horaColeta = horaColeta;
    }
    
    
}
