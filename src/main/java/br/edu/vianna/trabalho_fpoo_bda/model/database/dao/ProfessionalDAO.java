/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Professional;
import br.edu.vianna.trabalho_fpoo_bda.model.database.connection.ConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author natha
 */
public class ProfessionalDAO implements IGenericsDAO<Professional, Integer>{

    @Override
    public void inserir(Professional obj) throws NotConnectionException, SQLException {
         Connection c = ConnectionSingleton.getConnection();
         
         String sql = "INSERT INTO ProfessionalSaude ( idProfissionalSaude, descricao)"
                + "Values(?,?)";
         
         PreparedStatement st = c.prepareStatement(sql);
         
         st.setInt(1, obj.getId());
         st.setString(2, obj.get);
    }

    @Override
    public void alterar(Professional obj) throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(Professional obj) throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Professional buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
