/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Exam;
import br.edu.vianna.trabalho_fpoo_bda.model.ExamResult;
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
public class TestDAO implements IGenericsDAO<Test, Integer> {

    @Override
    public void inserir(Test obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO Teste ( id, idExame)"
                + "Values(?,?)";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getId());
        st.setInt(2, obj.getExame().getIdExame());

        st.executeUpdate();
    }

    @Override
    public void alterar(Test obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE Teste "
                + "SET  "
                + "id = ?  "
                + "idExame = ? "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getId());
        st.setInt(2, obj.getExame().getIdExame());

        st.executeUpdate();
    }

    @Override
    public void apagar(Test obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "DELETE FROM Teste "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getId());

        st.executeUpdate();
    }

    @Override
    public Test buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM Teste as t "
                + "INNER JOIN Exame as ex ON (t.id = ex.idTeste) "
                + "WHERE t.id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);

        ResultSet rs = st.executeQuery();
        
        ExamResult exResult = new ExamResult(rs.getInt("id"), rs.getString("descricao"));
        
        
        

        Test test = null;
        if (rs.next()) {
           
 
            return test;
        }
        return test;

    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(*) FROM Teste test "
                + "INNER JOIN Exame as ex ON (t.id = ex.idTeste) ";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

}
