/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.ExamResult;
import br.edu.vianna.trabalho_fpoo_bda.model.database.connection.ConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author natha
 */
public class ExamResultDAO implements IGenericsDAO<ExamResult, Integer> {

    @Override
    public void inserir(ExamResult obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO ResultadoExame ( id, descricao)"
                + "Values(?,?)";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdResultadoExame());
        st.setString(2, obj.getDescricao());

        st.executeUpdate();
    }

    @Override
    public void alterar(ExamResult obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE ResultadoExame "
                + "SET  "
                + "id = ?  "
                + "descricao = ?  "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdResultadoExame());
        st.setString(2, obj.getDescricao());

        st.executeUpdate();
    }

    @Override
    public void apagar(ExamResult obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "DELETE FROM ResultadoExame "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdResultadoExame());

        st.executeUpdate();
    }

    @Override
    public ExamResult buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM ResultadoExame  rE\n"
                + "INNER JOIN Exame ex (ex.idResultadoExame = rE.id) "
                + "WHERE p.id = ?";
        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);

        ResultSet rs = st.executeQuery();

        ExamResult exR = null;
        if (rs.next()) {
            exR = new ExamResult(rs.getInt("id"),
                    rs.getString("descricao"));

            return exR;
        } else {
            return exR;
        }
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(*) FROM ResultadoExame rE "
                + "INNER JOIN Exame ex ON (ex.idResultadoExame = rE.id) ";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        return rs.getInt(1);
    }

}