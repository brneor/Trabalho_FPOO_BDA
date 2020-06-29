/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Exam;
import br.edu.vianna.trabalho_fpoo_bda.model.Test;
import br.edu.vianna.trabalho_fpoo_bda.model.database.connection.ConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author natha
 */
public class ExamDAO implements IGenericsDAO<Exam, Integer>{

    @Override
    public void inserir(Exam obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "INSERT INTO Exame ( idTeste, idResultadoExame, idPaciente, idColeta)"
                + "Values(?,?,?,?)";
        
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setInt(1, obj.getTeste().getId());
        st.setInt(2, obj.getResultadoExame().getIdResultadoExame());
        st.setInt(3, obj.getCollect().getIdColeta());
        
        st.executeUpdate();
    }

    @Override
    public void alterar(Exam obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        
        String sql = "UPDATE Exame "
                + "SET  "
                + "idTeste = ?  "
                + "idResultadoExame = ? "
                + "idPaciente = ?  "
                + "idColeta = ?  "
                + "WHERE id = ?";
        
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setInt(1, obj.getTeste().getId());
        st.setInt(2, obj.getResultadoExame().getIdResultadoExame());
        st.setInt(3, obj.getCollect().getIdColeta());
        st.setInt(4, obj.getIdExame());
        
        st.executeUpdate();
    }

    @Override
    public void apagar(Exam obj) throws NotConnectionException, SQLException {
         Connection c = ConnectionSingleton.getConnection();
         
          String sql = "DELETE FROM Exame "
                + "WHERE id = ?";
          
          PreparedStatement st = c.prepareStatement(sql);
          
          st.setInt(1, obj.getIdExame());
          
          st.executeUpdate();
    }

    @Override
    public Exam buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
         String sql = "SELECT * FROM Exame as ex\n"
                + "INNER JOIN Relatorio as r ON (ex.id = r.idExame) "
                + "WHERE ex.id = ?";
         
         PreparedStatement st = c.prepareStatement(sql);
         
         st.setInt(1, key);
         
         ResultSet rs = st.executeQuery();
         
        return null;
        
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
