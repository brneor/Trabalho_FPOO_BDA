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
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class ExamResultDAO implements IGenericsDAO<ExamResult, Integer> {

    @Override
    public void inserir(ExamResult obj) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void alterar(ExamResult obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE ResultadoExame "
                + "SET  "
                + "id = ?  "
                + "descricao = ? "
                + "WHERE id  = ?";

        PreparedStatement st = c.prepareStatement(sql);
        
        st.setInt(1, obj.getId());
        st.setString(2, obj.getDescricao());
        
        st.executeUpdate();
    }

    @Override
    public void apagar(ExamResult obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "DELETE FROM ResultadoExame "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getId());

        st.executeUpdate();
    }

    @Override
    public ExamResult buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM ResultadoExame as res "
                + "INNER JOIN Exame as ex ON (res.id = ex.idResultadoExame) "
                + "WHERE res.id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);

        ResultSet rs = st.executeQuery();

        ExamResult ex = null;
        if (rs.next()) {
            ex = new ExamResult(rs.getInt("id"),
                    rs.getString("descricao"));

            return ex;
        } else {
            return ex;
        }
    }
    
    public ArrayList<ExamResult> listar() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        // Lista todos os resultados de exame
        String sql = "SELECT * FROM ResultadoExame";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        ArrayList<ExamResult> resultados = new ArrayList<>();

        while (rs.next()) {
            ExamResult e = new ExamResult();

            e.setId(rs.getInt("id"));
            e.setDescricao(rs.getString("descricao"));

            resultados.add(e);
        }

        return resultados;
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(*) FROM ResultadoExame res"
                + "INNER JOIN Exame as ex ON (res.id = ex.idResultadoExame)";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        rs.next();

        return rs.getInt(1);
    }

}
