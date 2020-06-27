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
    private int id;
    private Patient paciente;
    private Professional profissional; 
    private Material material;
    private boolean realizado;
    private String cidade;
    private Date data, hora;    

    public Collect() {
    }

    public Collect(int idColeta, Patient paciente, Professional profissional, Material material, boolean realizado, String cidade, Date dataColeta, Date horaColeta) {
        this.id = idColeta;
        this.paciente = paciente;
        this.profissional = profissional;
        this.material = material;
        this.realizado = realizado;
        this.cidade = cidade;
        this.data = dataColeta;
        this.hora = horaColeta;
    }

    public int getIdColeta() {
        return id;
    }

    public void setIdColeta(int idColeta) {
        this.id = idColeta;
    }

    public Patient getPaciente() {
        return paciente;
    }

    public void setPaciente(Patient paciente) {
        this.paciente = paciente;
    }

    public Professional getProfissional() {
        return profissional;
    }

    public void setProfissional(Professional profissional) {
        this.profissional = profissional;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public boolean isRealizado() {
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
        return data;
    }

    public void setDataColeta(Date dataColeta) {
        this.data = dataColeta;
    }

    public Date getHoraColeta() {
        return hora;
    }

    public void setHoraColeta(Date horaColeta) {
        this.hora = horaColeta;
    }
    
    
}
