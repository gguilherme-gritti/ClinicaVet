/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author g247468
 */
public class Animal {
    
    private int id_ani;
    private int id_cli;
    private int esp_id;
    private int id_trat;
    private String nome_animal;
    private int idade_animal;
    private int sexo_animal;

    public Animal(int id_ani, int id_cli, int esp_id, int id_trat, String nome_animal, int idade_animal, int sexo_animal) {
        this.id_ani = id_ani;
        this.id_cli = id_cli;
        this.esp_id = esp_id;
        this.id_trat = id_trat;
        this.nome_animal = nome_animal;
        this.idade_animal = idade_animal;
        this.sexo_animal = sexo_animal;
    }

    public int getId_ani() {
        return id_ani;
    }

    public int getId_cli() {
        return id_cli;
    }

    public int getEsp_id() {
        return esp_id;
    }


    public int getId_trat() {
        return id_trat;
    }

    public String getNome_animal() {
        return nome_animal;
    }

    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    public int getIdade_animal() {
        return idade_animal;
    }

    public void setIdade_animal(int idade_animal) {
        this.idade_animal = idade_animal;
    }

    public int getSexo_animal() {
        return sexo_animal;
    }

    public void setSexo_animal(int sexo_animal) {
        this.sexo_animal = sexo_animal;
    }
    
    
    
    
}
