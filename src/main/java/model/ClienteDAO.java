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

    static List<Cliente> clientes = new ArrayList<>();

    public static List<Cliente> retrieveAll() {
        return clientes;
    }

    public static Cliente retrieveById(int id_cli) {
        for(Cliente cli: clientes){
            if(cli.getId_cli() == id_cli){
                return cli;
            }
        }
        
        return new Cliente(99, 99, "Cliente Não encontrado", "nao@encontrado.com");
    }

    public static void create(int id_cli, int id_end, String nom_cli, String email_cli) {
        clientes.add(new Cliente(id_cli, id_end, nom_cli, email_cli));
    }

    public boolean update() {
        return true;
    }

    public boolean delete() {
        return true;
    }

}
