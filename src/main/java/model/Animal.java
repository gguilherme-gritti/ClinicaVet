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
    private int id_esp;
    private String nome_animal;
    private int idade_animal;
    private int sexo_animal;

    public Animal(int id_ani, int id_cli, int id_esp, String nome_animal, int idade_animal, int sexo_animal) {
        this.id_ani = id_ani;
        this.id_cli = id_cli;
        this.id_esp = id_esp;
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

    public void setEsp_id(int id_esp) {
        this.id_esp = id_esp;
    }

    public int getEsp_id() {
        return id_esp;
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
