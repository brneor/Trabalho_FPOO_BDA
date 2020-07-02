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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natha
 */
public class CollectDAO implements IGenericsDAO<Collect, Integer> {

    @Override
    public void inserir(Collect obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO Coleta (idPaciente, idProfissionalSaude, idMaterial, exameRealizado, dataColeta, horaColeta, cidade)"
                + "Values(?,?,?,?,?,?,?)";

        PreparedStatement st = c.prepareStatement(sql);

        st.setString(1, obj.getPaciente().getCpf());
        st.setInt(2, obj.getProfissional().getId());
        st.setInt(3, obj.getMaterial().getIdMaterial());
        st.setBoolean(4, obj.isExameRealizado());
        st.setObject(5, obj.getDataColeta());
        st.setObject(6, obj.getHoraColeta());
        st.setString(7, obj.getCidade());

        st.executeUpdate();

    }

    @Override
    public void alterar(Collect obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE Coleta "
                + "SET  "
                + "exameRealizado = ?  "
                + "cidade = ?  "
                + "dataColeta = ?  "
                + "horaColeta = ?  "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setBoolean(1, obj.isExameRealizado());
        st.setString(2, obj.getCidade());
        st.setObject(3, obj.getDataColeta());
        st.setObject(4, obj.getHoraColeta());

        st.executeUpdate();
    }

    @Override
    public void apagar(Collect obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "DELETE FROM Coleta "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getId());

        st.executeUpdate();
    }

    @Override
    public Collect buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "SELECT "
            + " c.id, "
            + " c.idPaciente, "
            + " c.idProfissionalSaude, "
            + " c.idMaterial, "
            + " c.exameRealizado, "
            + " c.dataColeta, "
            + " c.horaColeta, "
            + " c.cidade, "
            + " p.nome as nomePaciente, "
            + " p.dataNascimento, "
            + " p.risco as pacienteRisco, "
            + " ps.idTipoProfissional, "
            + " ps.nome as nomeProfissional, "
            + " tp.descricao as tipoProfissional, "
            + " m.descricao as material "
            + "FROM Coleta as c "
            + "INNER JOIN Paciente p ON c.idPaciente = p.cpf "
            + "INNER JOIN ProfissionalSaude ps ON c.idProfissionalSaude = ps.id "
            + "INNER JOIN tipoProfissional as tp on ps.idTipoProfissional = tp.id "
            + "INNER JOIN Material m ON c.idMaterial = m.id "
            + "WHERE c.id = ?"; 
        
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setInt(1, key);
        
        ResultSet rs = st.executeQuery();
        
        Collect coleta = new Collect();
        
        if (rs.next()) {
            SimpleDateFormat sdfShort = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
            
            Patient p = new Patient();
            p.setCpf(rs.getString("idPaciente"));
            try {
                p.setDataNascimento(sdfShort.parse(rs.getString("dataNascimento")));
            } catch (ParseException ex) {
                Logger.getLogger(CollectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.setNome(rs.getString("nomePaciente"));
            p.setRisco(rs.getInt("pacienteRisco") == 1);
            
            ProfessionalType tipo = new ProfessionalType();
            tipo.setIdTipoProfissional(rs.getInt("idTipoProfissional"));
            tipo.setDescricao(rs.getString("tipoProfissional"));
            
            Professional pf = new Professional();
            pf.setId(rs.getInt("idProfissionalSaude"));
            pf.setNome(rs.getString("nomeProfissional"));
            pf.setTipo(tipo);
            
            Material m = new Material();
            m.setIdMaterial(rs.getInt("idMaterial"));
            m.setDescricao("material");
            
            coleta.setId(rs.getInt("id"));
            coleta.setPaciente(p);
            coleta.setProfissional(pf);
            coleta.setMaterial(m);
            try {
                coleta.setDataColeta(sdfShort.parse(rs.getString("dataColeta")));
            } catch (ParseException ex) {
                Logger.getLogger(CollectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                coleta.setHoraColeta(sdfTime.parse(rs.getString("horaColeta")));
            } catch (ParseException ex) {
                Logger.getLogger(CollectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            coleta.setCidade(rs.getString("cidade"));
            
        }
        
        return coleta;
    }
    
    public ArrayList<Collect> buscarPorPaciente(String nome) throws NotConnectionException, SQLException, ParseException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "SELECT "
            + " c.id, "
            + " c.idPaciente, "
            + " c.idProfissionalSaude, "
            + " c.idMaterial, "
            + " c.exameRealizado, "
            + " c.dataColeta, "
            + " c.horaColeta, "
            + " c.cidade, "
            + " p.nome as nomePaciente, "
            + " p.dataNascimento, "
            + " p.risco as pacienteRisco, "
            + " ps.idTipoProfissional, "
            + " ps.nome as nomeProfissional, "
            + " tp.descricao as tipoProfissional, "
            + " m.descricao as material "
            + "FROM Coleta as c "
            + "INNER JOIN Paciente p ON c.idPaciente = p.cpf "
            + "INNER JOIN ProfissionalSaude ps ON c.idProfissionalSaude = ps.id "
            + "INNER JOIN tipoProfissional as tp on ps.idTipoProfissional = tp.id "
            + "INNER JOIN Material m ON c.idMaterial = m.id "
            + "WHERE p.nome like ? and c.exameRealizado = 0 order by p.nome"; 
        
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setString(1, "%" + nome + "%");
        
        ResultSet rs = st.executeQuery();
        
        ArrayList<Collect> coletas = new ArrayList<>();
        
        while (rs.next()) {
            SimpleDateFormat sdfShort = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
            
            Patient p = new Patient();
            p.setCpf(rs.getString("idPaciente"));
            p.setDataNascimento(sdfShort.parse(rs.getString("dataNascimento")));
            p.setNome(rs.getString("nomePaciente"));
            p.setRisco(rs.getInt("pacienteRisco") == 1);
            
            ProfessionalType tipo = new ProfessionalType();
            tipo.setIdTipoProfissional(rs.getInt("idTipoProfissional"));
            tipo.setDescricao(rs.getString("tipoProfissional"));
            
            Professional pf = new Professional();
            pf.setId(rs.getInt("idProfissionalSaude"));
            pf.setNome(rs.getString("nomeProfissional"));
            pf.setTipo(tipo);
            
            Material m = new Material();
            m.setIdMaterial(rs.getInt("idMaterial"));
            m.setDescricao("material");
            
            Collect cl = new Collect();
            cl.setId(rs.getInt("id"));
            cl.setPaciente(p);
            cl.setProfissional(pf);
            cl.setMaterial(m);
            cl.setDataColeta(sdfShort.parse(rs.getString("dataColeta")));
            cl.setHoraColeta(sdfTime.parse(rs.getString("horaColeta")));
            cl.setCidade(rs.getString("cidade"));
            
            coletas.add(cl);
            
        }
        
        return coletas;
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
    
    public void setRealizado(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "update Coleta set exameRealizado = 1 where id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);

        st.executeUpdate();
    }

}
