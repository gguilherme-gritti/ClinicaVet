/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author g247468
 */
public class Cliente {
    
    private int id_cli;
    private int id_end;
    private String nom_cli;
    private String email_cli;

    public Cliente(int id_cli, int id_end, String nom_cli, String email_cli) {
        this.id_cli = id_cli;
        this.id_end = id_end;
        this.nom_cli = nom_cli;
        this.email_cli = email_cli;
    }

    public int getId_cli() {
        return id_cli;
    }

    public int getId_end() {
        return id_end;
    }

    public String getNom_cli() {
        return nom_cli;
    }

    public void setNom_cli(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    public String getEmail_cli() {
        return email_cli;
    }

    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }
    
}
