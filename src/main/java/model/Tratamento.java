/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author g247468
 */
public class Tratamento {
    
    private int id_trat;
    private int id_animal;
    private String dat_ini;
    private String dat_fim;
    private int finalizado;

    public Tratamento(int id_trat, int id_animal, String dat_ini, String dat_fim, int finalizado) {
        this.id_trat = id_trat;
        this.dat_ini = dat_ini;
        this.dat_fim = dat_fim;
        this.finalizado = finalizado;
        this.id_animal = id_animal;
    }

    public int getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(int finalizado) {
        this.finalizado = finalizado;
    }

    public int getId_trat() {
        return id_trat;
    }

    public String getDat_ini() {
        return dat_ini;
    }

    public void setDat_ini(String dat_ini) {
        this.dat_ini = dat_ini;
    }

    public String getDat_fim() {
        return dat_fim;
    }

    public void setDat_fim(String dat_fim) {
        this.dat_fim = dat_fim;
    } 

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }
    
}
