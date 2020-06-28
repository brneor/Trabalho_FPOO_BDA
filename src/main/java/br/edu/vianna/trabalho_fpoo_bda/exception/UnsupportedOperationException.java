/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.exception;

/**
 *
 * @author breno
 */
public class UnsupportedOperationException extends Exception {
    public UnsupportedOperationException() {
        super("Operação não suportada.");
    }
}
