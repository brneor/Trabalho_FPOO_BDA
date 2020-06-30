/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Professional;
import br.edu.vianna.trabalho_fpoo_bda.model.ProfessionalType;
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
public class ProfessionalDAO implements IGenericsDAO<Professional, Integer> {

    @Override
    public void inserir(Professional obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO ProfissionalSaude ( id, idTipoProfissional, nome)"
                + "Values(?,?, ?)";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getId());
        st.setInt(2, obj.getTipo().getIdTipoProfissional());//pegando o id do tipo profissional
        st.setString(3, obj.getNome());

        st.executeUpdate();
    }

    @Override
    public void alterar(Professional obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE ProfissionalSaude "
                + "SET  "
                + "id = ?  "
                + "idTipoProfissional = ? "
                + "nome = ?  "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getId());
        st.setInt(2, obj.getTipo().getIdTipoProfissional());
        st.setString(3, obj.getNome());
        st.setInt(4, obj.getId());

        st.executeUpdate();
    }

    @Override
    public void apagar(Professional obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        //deletando profissional pelo id
        String sql = "DELETE FROM ProfissionalSaude "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getId());

        st.executeUpdate();
    }

    @Override
    public Professional buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        // Busca Profissional e seu tipo
        String sql = "SELECT p.id as idProfissional, p.idTipoProfissional, p.nome, "
                + "tp.id as idTipo, tp.descricao FROM ProfissionalSaude as p " 
                + "INNER JOIN tipoProfissional as tp ON p.idTipoProfissional = tp.id "
                + "where p.id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);
        
        ResultSet rs = st.executeQuery();

        Professional p = new Professional();

        if (rs.next()) {            
            p.setId(rs.getInt("idProfissional"));
            p.setNome(rs.getString("nome"));
            p.setTipo(new ProfessionalType(rs.getInt("idTipo"), rs.getString("descricao")));
        }

        return p;
    }

    public ArrayList<Professional> buscar(String nome) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        // Busca Profissional e seu tipo
        String sql = "SELECT p.id as idProfissional, p.idTipoProfissional, p.nome, "
                + "tp.id as idTipo, tp.descricao FROM ProfissionalSaude as p " 
                + "INNER JOIN tipoProfissional as tp ON p.idTipoProfissional = tp.id "
                + "where nome like ? order by nome;";

        PreparedStatement st = c.prepareStatement(sql);

        st.setString(1, "%"+nome+"%");
        
        ResultSet rs = st.executeQuery();

        ArrayList<Professional> profissionais = new ArrayList<>();

        while (rs.next()) {            
            Professional p = new Professional();
            p.setId(rs.getInt("idProfissional"));
            p.setNome(rs.getString("nome"));
            p.setTipo(new ProfessionalType(rs.getInt("idTipo"), rs.getString("descricao")));
           
            profissionais.add(p);
        }

        return profissionais;
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        //Retornando quantidade de profissional
        String sql = "SELECT count(*) FROM ProfissionalSaude as p\n"
                + "INNER JOIN tipoProfissional as tP ON (p.idTipoProfissional  = tp.id) ";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();
        
        return rs.getInt(1);
    }
}
