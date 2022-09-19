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
public class VeterinarioDAO extends DAO{
    
    private static VeterinarioDAO instance;

    private VeterinarioDAO() {
        getConnection();
        createTable();
    }

    public static VeterinarioDAO getInstance() {
        return (instance == null ? (instance = new VeterinarioDAO()) : instance);
    }

    public Veterinario create(int id_cons, int id_end, String nom_vet, String tel_vet) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Veterinario (id_cons, id_end, nom_vet, tel_vet) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, id_cons);
            stmt.setInt(2, id_end);
            stmt.setString(3, nom_vet);
            stmt.setString(4, tel_vet);
            executeUpdate(stmt);

        } catch (SQLException ex) {
            Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Veterinario", "id_vet"));
    }

    public boolean isLastEmptys() {
        Veterinario lastVet = this.retrieveById(lastId("Veterinario", "id_vet"));
        if (lastVet != null) {
            return lastVet.getNom_vet().isBlank();
        }
        return false;
    }

    private Veterinario buildObject(ResultSet rs) {
        Veterinario veterinario = null;
        try {
            veterinario = new Veterinario(rs.getInt("id_vet"), rs.getInt("id_cons"), rs.getInt("id_end"), rs.getString("nom_vet"), rs.getString("tel_vet"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return veterinario;
    }

    public List retrieve(String query) {
        List<Veterinario> veterinarios = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                veterinarios.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return veterinarios;
    }

    public Veterinario retrieveById(int id) {
        List<Veterinario> veterinarios = this.retrieve("SELECT * FROM Veterinario WHERE id_vet = " + id);
        return (veterinarios.isEmpty() ? null : veterinarios.get(0));
    }

}
