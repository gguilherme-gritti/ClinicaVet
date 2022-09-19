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
 * @author g247468
 */
public class AnimalDAO extends DAO {

    private static AnimalDAO instance;

    private AnimalDAO() {
        getConnection();
        createTable();
    }

    public static AnimalDAO getInstance() {
        return (instance == null ? (instance = new AnimalDAO()) : instance);
    }

    public Animal create(int id_cli, int esp_id, String nome_animal, int idade_animal, int sexo_animal) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Animal (id_cli, esp_id, nome_animal, idade_animal, sexo_animal) VALUES (?,?,?,?,?)");
            stmt.setInt(1, id_cli);
            stmt.setInt(2, esp_id);
            stmt.setString(3, nome_animal);
            stmt.setInt(4, idade_animal);
            stmt.setInt(5, sexo_animal);
            executeUpdate(stmt);

        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Animal", "id_ani"));
    }

    public boolean isLastEmpty() {
        Animal lastAnimal = this.retrieveById(lastId("Animal", "id_ani"));
        if (lastAnimal != null) {
            return lastAnimal.getNome_animal().isBlank();
        }
        return false;
    }

    private Animal buildObject(ResultSet rs) {
        Animal animal = null;
        try {
            animal = new Animal(rs.getInt("id_ani"), rs.getInt("id_cli"), rs.getInt("esp_id"), rs.getString("nome_animal"), rs.getInt("idade_animal"), rs.getInt("sexo_animal"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animal;
    }

    public List retrieve(String query) {
        List<Animal> animais = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                animais.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animais;
    }

    public Animal retrieveById(int id) {
        List<Animal> animais = this.retrieve("SELECT * FROM Animal WHERE id_ani = " + id);
        return (animais.isEmpty() ? null : animais.get(0));
    }

}
