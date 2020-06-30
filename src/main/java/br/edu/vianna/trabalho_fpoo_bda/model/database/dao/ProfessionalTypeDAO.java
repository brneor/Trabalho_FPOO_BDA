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
public class ProfessionalTypeDAO implements IGenericsDAO<ProfessionalType, Integer> {

    @Override
    public void inserir(ProfessionalType obj) throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void alterar(ProfessionalType obj) throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void apagar(ProfessionalType obj) throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ProfessionalType buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "SELECT * from tipoProfissional where id = ?";
    
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setInt(1, key);
        
        ResultSet rs = st.executeQuery();
        
        ProfessionalType pt = new ProfessionalType();
        
        if (rs.next()) {
            pt.setIdTipoProfissional(rs.getInt("id"));
            pt.setDescricao("descricao");
        }
        
        return pt;
    }

    public ArrayList<ProfessionalType> listar() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        

        // Lista todos os tipos
        String sql = "SELECT * FROM tipoProfissional";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        
        ArrayList<ProfessionalType> tipos = new ArrayList<>();
        
        while (rs.next()) {
            ProfessionalType t = new ProfessionalType();
            
            t.setIdTipoProfissional(rs.getInt("id"));
            t.setDescricao(rs.getString("descricao"));
            
            tipos.add(t);
        }
        
        return tipos;
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
