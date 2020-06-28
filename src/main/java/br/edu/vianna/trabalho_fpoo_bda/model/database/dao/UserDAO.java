/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.User;
import br.edu.vianna.trabalho_fpoo_bda.model.Usertype;
import br.edu.vianna.trabalho_fpoo_bda.model.database.connection.ConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author natha
 */
public class UserDAO implements IGenericsDAO<User, Integer> {

    @Override
    public void inserir(User obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO Usuario ( login, cpf, senha, nome )"
                + "Values(?,?,?,?)";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdLogin());
        st.setInt(2, obj.getCpf());
        st.setString(3, obj.getSenha());
        st.setString(4, obj.getNome());

        st.executeUpdate();
        
    }

    @Override
    public void alterar(User obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE Usuario "
                + "SET  "
                + "login = ?  "
                + "cpf = ?  "
                + "nome = ?  "
                + "senha = ?  "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdLogin());
        st.setInt(2, obj.getCpf());
        st.setString(3, obj.getNome());
        st.setString(4, obj.getSenha());
        st.setInt(5, obj.getIdLogin());
        
        st.executeUpdate();
    }

    @Override
    public void apagar(User obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "DELETE FROM Usuario "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdLogin());
        
        st.executeUpdate();
    }

    @Override
    public User buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM Usuario user\n"
                + "INNER JOIN tipoUsuario tpUser ON (user.login = tpUser.id) "
                + "WHERE p.id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);

        ResultSet rs = st.executeQuery();

        User user = null;
        if (rs.next()) {
            user = new User(rs.getInt("login"),
                    new Usertype(rs.getInt("id"), rs.getString("descricao")),
                    rs.getInt("cpf"),
                    rs.getString("nome"),
                    rs.getString("senha"));

            return user;
        } else {
            return user;
        }

    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(*) FROM Usuario user "
                + "INNER JOIN tipoUsuario tpUser ON (user.login = tpUser.id) ";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }
}
