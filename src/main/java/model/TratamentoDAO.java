/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;

/**
 *
 * @author Gritti
 */
public class TratamentoDAO extends DAO {

    private static TratamentoDAO instance;

    private TratamentoDAO() {
        getConnection();
        createTable();
    }

    public static TratamentoDAO getInstance() {
        return (instance == null ? (instance = new TratamentoDAO()) : instance);
    }

    public Tratamento create(int id_animal, LocalDate dat_ini, LocalDate dat_fim, int finalizado) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Tratamento (id_animal,dat_ini,dat_fim,finalizado) VALUES( ?,  ?,  ?,  ?)");
            stmt.setInt(1, id_animal);
            stmt.setObject(2,dat_ini);
            stmt.setObject(3,dat_fim);
            stmt.setInt(4, finalizado);
            executeUpdate(stmt);

        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Tratamento", "id_trat"));
    }

    private Tratamento buildObject(ResultSet rs) {
        Tratamento tratamento = null;
        try {
            tratamento = new Tratamento(rs.getInt("id_trat"), rs.getInt("id_animal"),(LocalDate) rs.getObject("dat_ini"),(LocalDate) rs.getObject("dat_fim"), rs.getInt("finalizado"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return tratamento;
    }

    public List retrieve(String query) {
        List<Tratamento> tratamentos = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                tratamentos.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return tratamentos;
    }

    public Tratamento retrieveById(int id) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM Tratamento WHERE id_trat = " + id);
        return (tratamentos.isEmpty() ? null : tratamentos.get(0));
    }

}
