/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author g247468
 */
public class Controller {

    //Cliente Controller
    public void addCliente(int id_cli, int id_end, String nom_cli, String email_cli) {
        ClienteDAO.create(id_cli, id_end, nom_cli, email_cli);
    }

    public List<Cliente> getAllClientes() {
        return ClienteDAO.retrieveAll();
    }
}
