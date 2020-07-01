/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.trabalho_fpoo_bda.model.database.dao;

import br.edu.vianna.trabalho_fpoo_bda.exception.NotConnectionException;
import br.edu.vianna.trabalho_fpoo_bda.model.Report;
import br.edu.vianna.trabalho_fpoo_bda.model.database.connection.ConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author natha
 */
public class ReportDAO implements IGenericsDAO<Report, Integer> {

    @Override
    public void inserir(Report obj) throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void alterar(Report obj) throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void apagar(Report obj) throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Report buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        throw new UnsupportedOperationException();      
    }

    //Retorna quantidade de paciente
    public int quantidadePacienteAtendido(Date data) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(p.cpf) FROM Paciente as p\n"
                + "INNER JOIN Exame as ex on ex.idPaciente = p.cpf where "
                + "ex.dataExame = ?";

        PreparedStatement st = c.prepareStatement(sql);
        
        st.setObject(1, data);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retorna quantidade de testes utilizados
    public int testesUtilizados(Date data) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "select count(*) from Teste as t left join Exame as e "
                + " on t.idExame = e.id where e.DataExame = ?";

        PreparedStatement st = c.prepareStatement(sql);
        
        st.setObject(1, data);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retorna quantidade de exames detectados
    public int totalExameDetectado(Date data) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "select count(*) from Exame as ex inner join ResultadoExame as res " 
                + "on ex.idResultadoExame = res.id "
                + "WHERE res.descricao = \"Detectado\" and ex.dataExame = ?";

        PreparedStatement st = c.prepareStatement(sql);
        
        st.setObject(1, data);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retorna quantidade de exame nao detectado
    public int totalExameNaoDetectado(Date data) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "select count(*) from Exame as ex inner join ResultadoExame as res " 
                + "on ex.idResultadoExame = res.id "
                + "WHERE res.descricao = \"Não detectado\" and ex.dataExame = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setObject(1, data);
        
        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retorna total de recoletas
    public int totalRecoleta(Date data) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "select count(*) from Exame as ex inner join ResultadoExame as res " 
                + "on ex.idResultadoExame = res.id "
                + "WHERE res.descricao = \"Recoleta\" and ex.dataExame = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setObject(1, data);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retorna de exames inconclusivos
    public int totalInconclusivo(Date data) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "select count(*) from Exame as ex inner join ResultadoExame as res " 
                + "on ex.idResultadoExame = res.id "
                + "WHERE res.descricao = \"Inconclusivo\" and ex.dataExame = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setObject(1, data);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    //retonra total de exames invalidos
    public int totalInvalido(Date data) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "select count(*) from Exame as ex inner join ResultadoExame as res " 
                + "on ex.idResultadoExame = res.id "
                + "WHERE res.descricao = \"Inválido\" and ex.dataExame = ?";

        PreparedStatement st = c.prepareStatement(sql);
        
        st.setObject(1, data);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

}
