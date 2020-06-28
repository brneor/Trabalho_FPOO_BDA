/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Collect;
import br.edu.vianna.trabalho_fpoo_bda.model.Material;
import br.edu.vianna.trabalho_fpoo_bda.model.Patient;
import br.edu.vianna.trabalho_fpoo_bda.model.Professional;
import br.edu.vianna.trabalho_fpoo_bda.model.ProfessionalType;
import br.edu.vianna.trabalho_fpoo_bda.model.database.connection.ConnectionSingleton;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author natha
 */
public class CollectDAO implements IGenericsDAO<Collect, Integer> {

    @Override
    public void inserir(Collect obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO Coleta (realizado, cidade,dataColeta, horaColeta)"
                + "Values(?,?,?,?)";

        PreparedStatement st = c.prepareStatement(sql);

        st.setBoolean(1, obj.isRealizado());
        st.setString(2, obj.getCidade());
        st.setDate(3, (Date) obj.getDataColeta());
        st.setDate(4, (Date) obj.getHoraColeta());

        st.executeUpdate();

    }

    @Override
    public void alterar(Collect obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE Coleta "
                + "SET  "
                + "realizado = ?  "
                + "cidade = ?  "
                + "dataColeta = ?  "
                + "horaColeta = ?  "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setBoolean(1, obj.isRealizado());
        st.setString(2, obj.getCidade());
        st.setDate(3, (Date) obj.getDataColeta());
        st.setDate(4, (Date) obj.getHoraColeta());

        st.executeUpdate();
    }

    @Override
    public void apagar(Collect obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "DELETE FROM Coleta "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdColeta());

        st.executeUpdate();
    }

    @Override
    public Collect buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM Coleta c\n"
                + "INNER JOIN Paciente p ON (c.idPaciente = p.cpf) "
                + "INNER JOIN  ProfissionalSaude prf ON (c.idProfissionalSaude = prf.idProfissionalSaude) "
                + "INNER JOIN   Material m ON (c.idMaterial = m.id) "
                + "WHERE c.id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);

        ResultSet rs = st.executeQuery();

        Collect co = null;
        if (rs.next()) {
            co = new Collect(rs.getInt("id"),
                    new Patient(rs.getString("cpf"), rs.getBoolean("risco"), rs.getDate("dataNascimento")),
                    new Professional(rs.getInt("idProfissionalSaude"), new ProfessionalType(rs.getInt("id"), rs.getString("descricao"))),
                    new Material(rs.getInt("id"), rs.getString("descricao")),
                    rs.getBoolean("realizado"),
                    rs.getString("cidade"),
                    rs.getDate("dataColeta"),
                    rs.getDate("horaColeta"));

            return co;
        } else {
            return co;
        }

        return new Collect();
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        String sql = "SELECT count(*) FROM Coleta c "
                + "INNER JOIN Exame ex ON (c.id = ex.idColeta) ";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        return rs.getInt(1);
    }

}
