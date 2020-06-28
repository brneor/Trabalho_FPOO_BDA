/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Patient;
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
public class PatientDAO implements IGenericsDAO<Patient, Integer> {

    @Override
    public void inserir(Patient obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO Paciente ( cpf, risco, cpf, dataNascimento)"
                + "Values(?,?,?,?)";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getCpf());
        st.setBoolean(2, obj.isRisco());
        st.setDate(3, (Date) obj.getDataNascimento());

        st.executeUpdate();
    }

    @Override
    public void alterar(Patient obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE Paciente "
                + "SET  "
                + "cpf = ?  "
                + "risco = ?  "
                + "dataNascimento = ?  "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getCpf());
        st.setBoolean(2, obj.isRisco());
        st.setDate(3, (Date) obj.getDataNascimento());
        
        st.executeUpdate();
    }

    @Override
    public void apagar(Patient obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "DELETE FROM Paciente "
                + "WHERE id = ?";
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setInt(1, obj.getCpf());
        
        st.executeUpdate();
    }

    @Override
    public Patient buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "SELECT * FROM Paciente p\n"
                + "INNER JOIN Usuario us ON (p.cpf = us.cpf) "
                + "WHERE p.id = ?";
        
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setInt(1, key);
        
        ResultSet rs = st.executeQuery();
        Patient p = null;
        if(rs.next()){
            p = new Patient(rs.getInt("cpf"), 
                    rs.getBoolean("risco"), 
                    rs.getDate("dataNascimento"));
            return p;
        }else {
            return p;
        }
        
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "SELECT count(*) FROM Paciente p "
                  + "INNER JOIN Usuario us ON (p.cpf = us.cpf) ";
        
        PreparedStatement st = c.prepareStatement(sql);
        
        ResultSet rs = st.executeQuery();
        
        return rs.getInt(1);

    }

}
