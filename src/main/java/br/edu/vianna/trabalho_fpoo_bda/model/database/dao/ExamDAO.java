/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Collect;
import br.edu.vianna.trabalho_fpoo_bda.model.Exam;
import br.edu.vianna.trabalho_fpoo_bda.model.ExamResult;
import br.edu.vianna.trabalho_fpoo_bda.model.Material;
import br.edu.vianna.trabalho_fpoo_bda.model.Patient;
import br.edu.vianna.trabalho_fpoo_bda.model.Professional;
import br.edu.vianna.trabalho_fpoo_bda.model.ProfessionalType;
import br.edu.vianna.trabalho_fpoo_bda.model.Test;
import br.edu.vianna.trabalho_fpoo_bda.model.database.connection.ConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class ExamDAO implements IGenericsDAO<Exam, Integer> {

    @Override
    public void inserir(Exam obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO Exame ( idTeste,idResultadoExame, idPaciente, idColeta, )"
                + "Values(?,?,?,?,?)";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getTeste().getId());
        st.setInt(2, obj.getResultadoExame().getIdResultadoExame());
        st.setString(3, obj.getPaciente().getCpf());
        st.setInt(4, obj.getCollect().getIdColeta());
        st.setObject(5, obj.getData());

        st.executeUpdate();
    }

    @Override
    public void alterar(Exam obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE Exame "
                + "SET  "
                + "idTeste = ?  "
                + "idResultadoExame = ? "
                + "idPaciente = ?  "
                + "idColeta = ?  "
                + "dataExame = ? "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getTeste().getId());
        st.setInt(2, obj.getResultadoExame().getIdResultadoExame());
        st.setInt(3, obj.getCollect().getIdColeta());
        st.setInt(4, obj.getId());
        st.setObject(5, obj.getData());

        st.executeUpdate();
    }

    @Override
    public void apagar(Exam obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "DELETE FROM Exame "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getId());

        st.executeUpdate();
    }

    @Override
    public Exam buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM Exame as ex "
                + "WHERE ex.id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);

        ResultSet rs = st.executeQuery();

        Exam ex = null;
        if (rs.next()) {

        }

        return ex;
    }
    
    public ArrayList<Exam> buscarPorPaciente(String nome) throws NotConnectionException, SQLException, ParseException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "select \n"
            + "e.id as idExame, "
            + "e.idTeste, "
            + "e.idResultadoExame, "
            + "e.idPaciente as pacienteCpf, "
            + "e.idColeta, "
            + "e.dataExame, "
            + "rt.descricao as resultadoExame, "
            + "p.risco as pacienteRisco, "
            + "p.dataNascimento as pacienteNascimento, "
            + "p.nome as pacienteNome, "
            + "c.idProfissionalSaude, "
            + "c.idMaterial, "
            + "c.exameRealizado, "
            + "c.dataColeta, "
            + "c.horaColeta, "
            + "c.cidade, "
            + "m.descricao as material, "
            + "ps.id as idProfissional, "
            + "ps.nome as nomeProfissional, "
            + "tp.descricao as tipoProfissional, "
            + "tp.id as idTipoProfissional "
            + "from Exame as e "
            + "inner join ResultadoExame as rt on e.idResultadoExame = rt.id "
            + "inner join Paciente as p on e.idPaciente = p.cpf "
            + "inner join Coleta as c on e.idColeta = c.id "
            + "inner join Material as m on c.idMaterial = m.id "
            + "inner join ProfissionalSaude as ps on c.idProfissionalSaude = ps.id "
            + "inner join tipoProfissional as tp on ps.idTipoProfissional = tp.id "
            + "where p.nome like ? order by p.nome";
        
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setString(1, "%"+nome+"%");
        
        ResultSet rs = st.executeQuery();

        ArrayList<Exam> exames = new ArrayList<>();
        
        while (rs.next()) {
            SimpleDateFormat sdfShort = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
            
            Patient p = new Patient();
            p.setCpf(rs.getString("pacienteCpf"));
            p.setDataNascimento(sdfShort.parse(rs.getString("pacienteNascimento")));
            p.setNome(rs.getString("pacienteNome"));
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
            cl.setIdColeta(rs.getInt("idColeta"));
            cl.setPaciente(p);
            cl.setProfissional(pf);
            cl.setMaterial(m);
            cl.setDataColeta(sdfShort.parse(rs.getString("dataColeta")));
            cl.setHoraColeta(sdfTime.parse(rs.getString("horaColeta")));
            cl.setCidade(rs.getString("cidade"));
            
            ExamResult er = new ExamResult();
            er.setIdResultadoExame(rs.getInt("idResultadoExame"));
            er.setDescricao(rs.getString("resultadoExame"));
            
            Exam ex = new Exam();
            ex.setId(rs.getInt("idExame"));
            ex.setCollect(cl);
            ex.setPaciente(p);
            ex.setResultadoExame(er);
            ex.setTeste(new Test(rs.getInt("idTeste"), ex));
            ex.setData(rs.getDate("dataExame"));
            
            exames.add(ex);
        }

        return exames;
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(*) FROM Exam ex";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

}
