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

    public Cliente create(String nom_cli, String email_cli, String cidade_cli, String estado_cli, String rua_cli, String bairro_cli, String cep_cli) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO Cliente (nom_cli, email_cli, cidade_cli, estado_cli, rua_cli, bairro_cli, cep_cli) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, nom_cli);
            stmt.setString(2, email_cli);
            stmt.setString(3, cidade_cli);
            stmt.setString(4, estado_cli);
            stmt.setString(5, rua_cli);
            stmt.setString(6, bairro_cli);
            stmt.setString(7, cep_cli);
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
            cliente = new Cliente(rs.getInt("id_cli"), rs.getString("nom_cli"), rs.getString("email_cli"), rs.getString("cidade_cli"), rs.getString("estado_cli"),
                    rs.getString("rua_cli"), rs.getString("bairro_cli"), rs.getString("cep_cli"));
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

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM Cliente");
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
            stmt = DAO.getConnection().prepareStatement("UPDATE Cliente SET nom_cli=?, email_cli=?, cidade_cli=?, estado_cli=?,"
                    + "rua_cli=?, bairro_cli=?, cep_cli=? WHERE id_cli=?");
            stmt.setString(1, cliente.getNom_cli());
            stmt.setString(2, cliente.getEmail_cli());
            stmt.setString(3, cliente.getCidade_cli());
            stmt.setString(4, cliente.getEstado_cli());
            stmt.setString(5, cliente.getRua_cli());
            stmt.setString(6, cliente.getBairro_cli());
            stmt.setString(7, cliente.getCep_cli());
            stmt.setInt(8, cliente.getId_cli());
            
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
