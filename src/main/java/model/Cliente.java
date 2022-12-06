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
    private String nom_cli;
    private String email_cli;
    private String cidade_cli;
    private String estado_cli;
    private String rua_cli;
    private String bairro_cli;
    private String cep_cli;

    public Cliente(int id_cli, String nom_cli, String email_cli, String cidade_cli, String estado_cli, String rua_cli, String bairro_cli, String cep_cli) {
        this.id_cli = id_cli;
        this.nom_cli = nom_cli;
        this.email_cli = email_cli;
        this.cidade_cli = cidade_cli;
        this.estado_cli = estado_cli;
        this.rua_cli = rua_cli;
        this.bairro_cli = bairro_cli;
        this.cep_cli = cep_cli;
    }

    public String getCidade_cli() {
        return cidade_cli;
    }

    public void setCidade_cli(String cidade_cli) {
        this.cidade_cli = cidade_cli;
    }

    public String getEstado_cli() {
        return estado_cli;
    }

    public void setEstado_cli(String estado_cli) {
        this.estado_cli = estado_cli;
    }

    public String getRua_cli() {
        return rua_cli;
    }

    public void setRua_cli(String rua_cli) {
        this.rua_cli = rua_cli;
    }

    public String getBairro_cli() {
        return bairro_cli;
    }

    public void setBairro_cli(String bairro_cli) {
        this.bairro_cli = bairro_cli;
    }

    public String getCep_cli() {
        return cep_cli;
    }

    public void setCep_cli(String cep_cli) {
        this.cep_cli = cep_cli;
    }

    public int getId_cli() {
        return id_cli;
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
