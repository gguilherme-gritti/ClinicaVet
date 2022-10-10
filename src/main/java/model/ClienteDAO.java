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
public class ClienteDAO extends DAO {

    private static ClienteDAO instance;

    private ClienteDAO() {
        getConnection();
        createTable();
    }

    public static ClienteDAO getInstance() {
        return (instance == null ? (instance = new ClienteDAO()) : instance);
    }

    public Cliente create(int id_end, String nom_cli, String email_cli) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Cliente (id_end, nom_cli, email_cli) VALUES (?,?,?)");
            stmt.setInt(1, id_end);
            stmt.setString(2, nom_cli);
            stmt.setString(3, email_cli);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("Cliente", "id_cli"));
    }

    public boolean isLastEmpty() {
        Cliente lastClient = this.retrieveById(lastId("Cliente", "id_cli"));
        if (lastClient != null) {
            return lastClient.getNom_cli().isBlank();
        }
        return false;
    }

    private Cliente buildObject(ResultSet rs) {
        Cliente cliente = null;
        try {
            cliente = new Cliente(rs.getInt("id_cli"), rs.getInt("id_end"), rs.getString("nom_cli"), rs.getString("email_cli"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return cliente;
    }

    public List retrieve(String query) {
        List<Cliente> clientes = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                clientes.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return clientes;
    }

    public List retrieveLast() {
        return this.retrieve("SELECT * FROM Cliente WHERE id_cli = " + lastId("Cliente", "id_cli"));
    }

    public Cliente retrieveById(int id) {
        List<Cliente> clientes = this.retrieve("SELECT * FROM Cliente WHERE id_cli = " + id);
        return (clientes.isEmpty() ? null : clientes.get(0));
    }

    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM Cliente WHERE nome LIKE '%" + nome + "%'");
    }

    public void update(Cliente cliente) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE Cliente SET nom_cli=?, email_cli=? WHERE id_cli=?");
            stmt.setString(1, cliente.getNom_cli());
            stmt.setString(2, cliente.getEmail_cli());
            stmt.setInt(3, cliente.getId_cli());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Cliente cliente) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM Cliente WHERE id_cli = ?");
            stmt.setInt(1, cliente.getId_cli());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
