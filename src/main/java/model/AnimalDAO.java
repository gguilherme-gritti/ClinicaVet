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
public class AnimalDAO extends DAO {

    static List<Animal> animais = new ArrayList<>();

    public static List<Animal> retrieveAll() {
        return animais;
    }

    public static List<Animal> retrieveByIdCli(int id_cli) {
        List<Animal> animaisCliente = new ArrayList<>();
        for(Animal anm: animais){
            if(anm.getId_cli() == id_cli){
                animaisCliente.add(anm);
            }
        }
     
        return animaisCliente;
    }

    public static void create(int id_ani, int id_cli, int esp_id, String nome_animal, int idade_animal, int sexo_animal) {
        animais.add(new Animal(id_ani, id_cli, esp_id, nome_animal, idade_animal, sexo_animal));
    }

    public boolean update() {
        return true;
    }

    public boolean delete() {
        return true;
    }

}
