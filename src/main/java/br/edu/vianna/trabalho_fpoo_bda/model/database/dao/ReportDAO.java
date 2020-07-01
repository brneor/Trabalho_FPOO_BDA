/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Report;
import br.edu.vianna.trabalho_fpoo_bda.model.database.connection.ConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author natha
 */
public class ReportDAO implements IGenericsDAO<Report, Integer> {

    @Override
    public void inserir(Report obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO Relatorio ( idPaciente, idExame)"
                + "Values(?,?)";

        PreparedStatement st = c.prepareStatement(sql);

        //Inserido id do paciente
        st.setString(1, obj.getPaciente().getCpf());
        //Inserido id do exame
        st.setInt(2, obj.getExame().getId());

        st.executeUpdate();

    }

    @Override
    public void alterar(Report obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE Relatorio "
                + "SET  "
                + "idPaciente = ?  "
                + "idExame = ? "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        //Inserido id do paciente
        st.setString(1, obj.getPaciente().getCpf());
        //Inserido id do exame
        st.setInt(2, obj.getExame().getId());

        st.setInt(3, obj.getId());

        st.executeUpdate();
    }

    @Override
    public void apagar(Report obj) throws NotConnectionException, SQLException {

        Connection c = ConnectionSingleton.getConnection();

        String sql = "DELETE FROM Relatorio "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);
        //Deleta relatorio com id passado

        st.setInt(1, obj.getId());

        st.executeUpdate();

    }

    @Override
    public Report buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM Relatorio as re\n"
                + "INNER JOIN Paciente p ON (re.idPaciente = p.cpf) "
                + "INNER JOIN Exame ex ON (re.idExame = ex.id) "
                + "WHERE re.id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);

        ResultSet rs = st.executeQuery();

        Report rep = null;
        if (rs.next()) {
            return rep;
        } else {
            return rep;
        }
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT  count(*)  FROM Relatorio as re\n"
                + "INNER JOIN Paciente p ON (re.idPaciente = p.cpf) "
                + "INNER JOIN Exame ex ON (re.idExame = ex.id) ";
             

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);

    }

}
