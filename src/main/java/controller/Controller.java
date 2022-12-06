/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.JTextField;
import model.Animal;
import model.Cliente;
import model.ClienteDAO;
import model.VeterinarioDAO;

/**
 *
 * @author g247468
 */
public class Controller {

    private static Cliente selectedClient = null;
    private static Animal selectedAnimal = null;

    private static JTextField selectedClientTF = null;
    private static JTextField selectedAnimalTF = null;

    public static void setTextFields(JTextField cliente, JTextField animal) {
        selectedClientTF = cliente;
        selectedAnimalTF = animal;
    }

    public static List getAllClients() {
        return ClienteDAO.getInstance().retrieveAll();
    }

    public static List getAllVeterinarios() {
        return VeterinarioDAO.getInstance().retrieveAll();
    }

    public static void addCliente(String nome, String email, String cidade, String estado, String rua, String bairro, String cep) {;
        ClienteDAO.getInstance().create(nome, email, cidade, estado, rua, bairro, cep);
    }

    public static void addVeterinario(String nome, String telefone, String cidade, String estado, String rua, String bairro) {
        VeterinarioDAO.getInstance().create(nome, telefone, cidade, estado, rua, bairro);
    }

}
