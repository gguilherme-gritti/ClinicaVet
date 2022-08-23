/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author g247468
 */
public class Especie {
    
    private int id_esp;
    private String nome_esp;

    public Especie(int id_esp, String nome_esp) {
        this.id_esp = id_esp;
        this.nome_esp = nome_esp;
    }

    public int getId_esp() {
        return id_esp;
    }

    public String getNome_esp() {
        return nome_esp;
    }

    public void setNome_esp(String nome_esp) {
        this.nome_esp = nome_esp;
    }
    
    
    
}
