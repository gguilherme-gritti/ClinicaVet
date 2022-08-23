/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author g247468
 */
public class Veterinario {
    
    private int id_vet;
    private int id_cons;
    private int id_end;
    private String nom_vet;
    private String tel_vet;

    public Veterinario(int id_vet, int id_cons, int id_end, String nom_vet, String tel_vet) {
        this.id_vet = id_vet;
        this.id_cons = id_cons;
        this.id_end = id_end;
        this.nom_vet = nom_vet;
        this.tel_vet = tel_vet;
    }

    public int getId_vet() {
        return id_vet;
    }


    public int getId_cons() {
        return id_cons;
    }


    public int getId_end() {
        return id_end;
    }

    public String getNom_vet() {
        return nom_vet;
    }

    public void setNom_vet(String nom_vet) {
        this.nom_vet = nom_vet;
    }

    public String getTel_vet() {
        return tel_vet;
    }

    public void setTel_vet(String tel_vet) {
        this.tel_vet = tel_vet;
    }
    
}
