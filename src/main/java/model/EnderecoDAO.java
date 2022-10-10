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
public class EnderecoDAO extends DAO {

    private static EnderecoDAO instance;

    private EnderecoDAO() {
        getConnection();
        createTable();
    }

    public static EnderecoDAO getInstance() {
        return (instance == null ? (instance = new EnderecoDAO()) : instance);
    }

    public Endereco create(String rua_end, String bairro_end, String cidade_end, String cep_end) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Endereco (rua_end, bairro_end, cidade_end, cep_end) VALUES (?, ?, ?, ?)");
            stmt.setString(1, rua_end);
            stmt.setString(2, bairro_end);
            stmt.setString(3, cidade_end);
            stmt.setString(4, cep_end);
            executeUpdate(stmt);

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Endereco", "id_end"));
    }

    private Endereco buildObject(ResultSet rs) {
        Endereco endereco = null;
        try {
            endereco = new Endereco(rs.getInt("id_end"), rs.getString("rua_end"), rs.getString("bairro_end"), rs.getString("cidade_end"), rs.getString("cep_end"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return endereco;
    }

    public List retrieve(String query) {
        List<Endereco> enderecos = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                enderecos.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return enderecos;
    }

    public Endereco retrieveById(int id) {
        List<Endereco> enderecos = this.retrieve("SELECT * FROM Endereco WHERE id_end = " + id);
        return (enderecos.isEmpty() ? null : enderecos.get(0));
    }
}
