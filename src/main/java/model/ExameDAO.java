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

/**
 *
 * @author Gritti
 */
public class ExameDAO extends DAO{

    private static ExameDAO instance;

    private ExameDAO() {
        getConnection();
        createTable();
    }

    public static ExameDAO getInstance() {
        return (instance == null ? (instance = new ExameDAO()) : instance);
    }

    public Exame create(int id_cons, String des_exame) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Exame (id_cons, des_exame) VALUES (?, ?)");
            stmt.setInt(1, id_cons);
            stmt.setString(2, des_exame);
            executeUpdate(stmt);

        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Exame", "id_exam"));
    }

    public boolean isLastEmpty() {
        Exame lastExam = this.retrieveById(lastId("Exame", "id_exam"));
        if (lastExam != null) {
            return lastExam.getDes_exame().isBlank();
        }
        return false;
    }

    private Exame buildObject(ResultSet rs) {
        Exame exame = null;
        try {
            exame = new Exame(rs.getInt("id_exam"), rs.getInt("id_cons"), rs.getString("des_exame"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exame;
    }

    public List retrieve(String query) {
        List<Exame> exames = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                exames.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exames;
    }

    public Exame retrieveById(int id) {
        List<Exame> exames = this.retrieve("SELECT * FROM Exame WHERE id_exam = " + id);
        return (exames.isEmpty() ? null : exames.get(0));
    }
    
}
