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
public class ConsultaDAO extends DAO{

    private static ConsultaDAO instance;

    private ConsultaDAO() {
        getConnection();
        createTable();
    }

    public static ConsultaDAO getInstance() {
        return (instance == null ? (instance = new ConsultaDAO()) : instance);
    }

    public Consulta create(int id_trat, LocalDate dat_con) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Consulta (id_trat, dat_con) VALUES (?, ?)");
            stmt.setInt(1, id_trat);
            stmt.setObject(2, dat_con);
            executeUpdate(stmt);

        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Consulta", "id_cons"));
    }

    private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        try {
            consulta = new Consulta(rs.getInt("id_cons"), rs.getInt("id_trat"), (LocalDate) rs.getObject("dat_con"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consulta;
    }

    public List retrieve(String query) {
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consultas;
    }

    public Consulta retrieveById(int id) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM Consulta WHERE id_cons = " + id);
        return (consultas.isEmpty() ? null : consultas.get(0));
    }
    
}
