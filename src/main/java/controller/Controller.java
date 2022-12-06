/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.JTextPane;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Veterinario;
import model.VeterinarioDAO;

/**
 *
 * @author g247468
 */
public class Controller {

    private static Cliente selectedClient = null;
    private static Animal selectedAnimal = null;
    private static Veterinario selectedVeterinario = null;

    private static JTextPane selectedClientTP = null;
    private static JTextPane selectedAnimalTP = null;
    private static JTextPane selectedIdadeAnimalTP = null;
    private static JTextPane selectedVeterinarioTP = null;

    public static void setSelectedTextFields(JTextPane cliente, JTextPane animal, JTextPane idadeAnimal, JTextPane veterinario) {
        selectedClientTP = cliente;
        selectedAnimalTP = animal;
        selectedIdadeAnimalTP = idadeAnimal;
        selectedVeterinarioTP = veterinario;
    }

    public static List getAllClients() {
        return ClienteDAO.getInstance().retrieveAll();
    }

    public static List getAllVeterinarios() {
        return VeterinarioDAO.getInstance().retrieveAll();
    }
    
    public static List getAllAnimals(){
        return AnimalDAO.getInstance().retrieveAll();
    }
    
    public static List getAnimalsByClienteId(int id_cli){
        return AnimalDAO.getInstance().retrieveByClienteId(id_cli);
    }

    public static void addCliente(String nome, String email, String cidade, String estado, String rua, String bairro, String cep) {;
        ClienteDAO.getInstance().create(nome, email, cidade, estado, rua, bairro, cep);
    }

    public static void addVeterinario(String nome, String telefone, String cidade, String estado, String rua, String bairro) {
        VeterinarioDAO.getInstance().create(nome, telefone, cidade, estado, rua, bairro);
    }
    
    public static void addAnimal(String nome, int idade, int sexo){
        AnimalDAO.getInstance().create(selectedClient.getId_cli(), 1, nome, idade, sexo);
    }

    public static void setSelectedCliente(Cliente cliente) {
        selectedClient = cliente;
        selectedClientTP.setText(cliente.getNom_cli());
    }

    public static void setSelectedAnimal(Animal animal) {
        selectedAnimal = animal;
        selectedAnimalTP.setText(animal.getNome_animal());
        selectedIdadeAnimalTP.setText(String.valueOf(animal.getIdade_animal()));
    }

    public static void setSelectedVeterinario(Veterinario veterinario) {
        selectedVeterinario = veterinario;
        selectedVeterinarioTP.setText(veterinario.getNom_vet());
    }

    public static Cliente getSelectedClient() {
        return selectedClient;
    }

    public static Animal getSelectedAnimal() {
        return selectedAnimal;
    }

    public static Veterinario getSelectedVeterinario() {
        return selectedVeterinario;
    }

}
