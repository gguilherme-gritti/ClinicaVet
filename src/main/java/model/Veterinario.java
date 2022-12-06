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
    private String nom_vet;
    private String tel_vet;
    private String cidade_vet;
    private String estado_vet;
    private String rua_vet;
    private String bairro_vet;

    public Veterinario(int id_vet, String nom_vet, String tel_vet, String cidade_vet, String estado_vet, String rua_vet, String bairro_vet) {
        this.id_vet = id_vet;
        this.nom_vet = nom_vet;
        this.tel_vet = tel_vet;
        this.cidade_vet = cidade_vet;
        this.estado_vet = estado_vet;
        this.rua_vet = rua_vet;
        this.bairro_vet = bairro_vet;
    }

    public String getCidade_vet() {
        return cidade_vet;
    }

    public void setCidade_vet(String cidade_vet) {
        this.cidade_vet = cidade_vet;
    }

    public String getEstado_vet() {
        return estado_vet;
    }

    public void setEstado_vet(String estado_vet) {
        this.estado_vet = estado_vet;
    }

    public String getRua_vet() {
        return rua_vet;
    }

    public void setRua_vet(String rua_vet) {
        this.rua_vet = rua_vet;
    }

    public String getBairro_vet() {
        return bairro_vet;
    }

    public void setBairro_vet(String bairro_vet) {
        this.bairro_vet = bairro_vet;
    }

    public int getId_vet() {
        return id_vet;
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
