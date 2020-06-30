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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class PatientDAO implements IGenericsDAO<Patient, Integer> {

    @Override
    public void inserir(Patient obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO Paciente ( cpf, risco, dataNascimento, nome)"
                + "Values(?,?,?,?)";

        PreparedStatement st = c.prepareStatement(sql);

        st.setString(1, obj.getCpf());
        st.setBoolean(2, obj.isRisco());
        st.setObject(3, obj.getDataNascimento());
        st.setString(4, obj.getNome());

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
                + "nome = ? "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setString(1, obj.getCpf());
        st.setBoolean(2, obj.isRisco());
        st.setObject(3, obj.getDataNascimento());
        st.setString(4, obj.getNome());
        
        st.executeUpdate();
    }

    @Override
    public void apagar(Patient obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "DELETE FROM Paciente "
                + "WHERE id = ?";
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setString(1, obj.getCpf());
        
        st.executeUpdate();
    }

    @Override
    public Patient buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException();
    }
    
    public Patient buscarPeloCpf(String cpf) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "SELECT * FROM Paciente p "
                + "WHERE cpf = ?";
        
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setString(1, cpf);
        
        ResultSet rs = st.executeQuery();
        
        Patient p = new Patient();
        
        if (rs.next()) {
            p.setCpf(rs.getString("cpf"));
            p.setDataNascimento(rs.getDate("dataNascimento"));
            p.setNome(rs.getString("nome"));
            p.setRisco(rs.getInt("risco") == 1);
        }
        
        return p;
    }
    
    public ArrayList<Patient> buscar(String nome) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "SELECT * FROM Paciente p "
                + "WHERE nome like ? order by nome";
        
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setString(1, "%"+nome+"%");
        
        ResultSet rs = st.executeQuery();
        
        ArrayList<Patient> pacientes = new ArrayList<>();
        
        while (rs.next()) {            
            Patient p = new Patient();
            p.setCpf(rs.getString("cpf"));
            p.setDataNascimento(rs.getDate("dataNascimento"));
            p.setNome(rs.getString("nome"));
            p.setRisco(rs.getInt("risco") == 1);

            pacientes.add(p);
        }
        
        return pacientes;
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
