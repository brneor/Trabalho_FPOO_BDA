/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Material;
import br.edu.vianna.trabalho_fpoo_bda.model.database.connection.ConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author natha
 */
public class MaterialDAO implements IGenericsDAO<Material, Integer> {

    @Override
    public void inserir(Material obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO Material ( id, descricao)"
                + "Values(?,?)";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdMaterial());
        st.setString(2, obj.getDescricao());

        st.executeUpdate();
    }

    @Override
    public void alterar(Material obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE Material "
                + "SET  "
                + "id = ?  "
                + "descricao = ?  "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdMaterial());
        st.setString(2, obj.getDescricao());
        st.setInt(3, obj.getIdMaterial());
    }

    @Override
    public void apagar(Material obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "DELETE FROM Material "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdMaterial());
    }

    @Override
    public Material buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM Material m\n"
                + "INNER JOIN Coleta col  ON (m.id = col.id) "
                + "WHERE p.id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);

        ResultSet rs = st.executeQuery();

        Material m = null;
        if (rs.next()) {
            m = new Material(rs.getInt("id"),
                    rs.getString("descricao"));

            return m;
        } else {
            return m;
        }

    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(*) FROM Material m "
                + "INNER JOIN Coleta c ON (m.id = c.id) ";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        return rs.getInt(1);
    }

}
