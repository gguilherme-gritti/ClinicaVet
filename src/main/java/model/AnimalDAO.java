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

    private List<Animal> animais = new ArrayList<>();

    public List<Animal> retrieveAll() {
        return animais;
    }

    public List<Animal> retrieveByIdCli(int id_cli) {
        return animais;
    }

    public void create(int id_cli, int esp_id, int id_trat, String nome_animal, int idade_animal, int sexo_animal) {

    }

    public boolean update() {
        return true;
    }

    public boolean delete() {
        return true;
    }

}
