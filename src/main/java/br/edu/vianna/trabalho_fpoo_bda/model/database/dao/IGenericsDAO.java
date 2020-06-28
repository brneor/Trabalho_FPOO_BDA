/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import java.sql.SQLException;

/**
 *
 * @author natha
 */
public interface IGenericsDAO<C, K> {

    public void inserir(C obj) throws NotConnectionException, SQLException;

    public void alterar(C obj) throws NotConnectionException, SQLException;

    public void apagar(C obj) throws NotConnectionException, SQLException;

    public C buscarPeloId(K key) throws NotConnectionException, SQLException;

    public int quantidade() throws NotConnectionException, SQLException;
}
