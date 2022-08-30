/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g247468
 */
public class ClienteDAO extends DAO {

    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> retrieveAll() {
        return clientes;
    }

    public void retrieveById(int id_cli) {

    }

    public void create(int id_end, String nom_cli, String email_cli) {
        
    }

    public boolean update() {
        return true;
    }

    public boolean delete() {
        return true;
    }

}
