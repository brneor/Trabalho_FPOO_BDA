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
import br.edu.vianna.trabalho_fpoo_bda.model.Report;
import br.edu.vianna.trabalho_fpoo_bda.model.Test;
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

        Exam ex = new Exam();
        Report rep = new Report();
        Test test = new Test();
        ExamResult res = new ExamResult();
        Patient p = new Patient();
        Collect co = new Collect();
        Professional prof = new Professional();
        ProfessionalType profT = new ProfessionalType();
        Material m =  new Material();
        if (rs.next()) {
            rep.setId(rs.getInt("id"));
            ex.setId(rs.getInt("id"));
            test.setId(rs.getInt("id"));
            test.setExame(ex);
            ex.setTeste(test);
            res.setIdResultadoExame(rs.getInt("id"));
            res.setDescricao(rs.getString("descricao"));
            ex.setResultadoExame(res);
            p.setCpf(rs.getString("cpf"));
            p.setRisco(rs.getBoolean("risco"));
            p.setDataNascimento(rs.getDate("dataNascimento"));
            p.setNome(rs.getString("nome"));
            ex.setPaciente(p);
            prof.setId(rs.getInt("id"));
            profT.setIdTipoProfissional(rs.getInt("id"));
            profT.setDescricao(rs.getString("descricao"));
            prof.setTipo(profT);
            prof.setNome(rs.getString("nome"));
            co.setIdColeta(rs.getInt("id"));
            co.setPaciente(p);
            co.setProfissional(prof);
            co.setCidade(rs.getString("cidade"));
            co.setDataColeta(rs.getDate("dataColeta"));
            co.setHoraColeta(rs.getDate("horaColeta"));
            co.setExameRealizado(rs.getBoolean("exameRealizado"));
            m.setIdMaterial(rs.getInt("id"));
            m.setDescricao(rs.getString("descricao"));
            co.setMaterial(m);
            ex.setCollect(co);
            rep.setExame(ex);
            
            return rep;
        }

        return rep;
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

    //Retorna quantidade de paciente
    public int quantidadePacienteAtendido() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(p.cpf) FROM Paciente as p\n"
                + "INNER JOIN Relatorio as r on p.cpf = r.idPaciente  "
                + "INNER JOIN Exame as ex on (ex.id = r.idExame)";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retorna quantidade de testes utilizados
    public int testesUtilizados() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(t.id) FROM Relatorio as r\n"
                + "INNER JOIN Exame as ex ON (ex.id = r.idExame) "
                + "INNER JOIN Teste as t ON (t.id = ex.idTeste) ";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retorna quantidade de exames detectados
    public int totalExameDetectado() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(res.descricao) FROM Relatorio as re\n"
                + "INNER JOIN Exame as ex ON (re.idExame =  ex.id)  "
                + "INNER JOIN ResultadoExame as res ON  (res.id = ex.idResultadoExame)"
                + "WHERE res.descricao LIKE '%Detectado%'";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retorna quantidade de exame nao detectado
    public int totalExameNaoDetectado() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(res.descricao) FROM Relatorio as re\n"
                + "INNER JOIN Exame as ex ON (re.idExame =  ex.id)  "
                + "INNER JOIN ResultadoExame as res ON  (res.id = ex.idResultadoExame)"
                + "WHERE res.descricao LIKE '%Não detectado%";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retorna total de recoletas
    public int totalRecoleta() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "select count(p.cpf) FROM Paciente as p\n"
                + "INNER JOIN Relatorio as re ON (p.cpf = re.idPaciente)  "
                + "INNER JOIN Exame as ex ON (re.idExame =  ex.id)  "
                + "INNER JOIN ResultadoExame as res ON  (res.id = ex.idResultadoExame)  "
                + "WHERE res.descricao LIKE '%Recoleta%'";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retorna de exames inconclusivos
    public int totalInconclusivo() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "select count(p.cpf) FROM Paciente as p\n "
                + "INNER JOIN Relatorio as re ON (p.cpf = re.idPaciente) "
                + "INNER JOIN Exame as ex ON (re.idExame =  ex.id) "
                + "INNER JOIN ResultadoExame as res ON  (res.id = ex.idResultadoExame) "
                + "WHERE res.descricao LIKE '%Inconclusivo%'";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retonra total de exames invalidos
    public int totalInvalido() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = " select count(res.descricao) FROM Relatorio as re\n "
                + "INNER JOIN Exame as ex ON (re.idExame =  ex.id)  "
                + "INNER JOIN ResultadoExame as res ON  (res.id = ex.idResultadoExame)  "
                + "WHERE res.descricao LIKE '%Inválido%'";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

}
