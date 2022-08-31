/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author g247468
 */
public class Tratamento {
    
    private int id_trat;
    private int id_animal;
    private LocalDate dat_ini;
    private LocalDate dat_fim;

    public Tratamento(int id_trat, LocalDate dat_ini, LocalDate dat_fim) {
        this.id_trat = id_trat;
        this.dat_ini = dat_ini;
        this.dat_fim = dat_fim;
    }

    public int getId_trat() {
        return id_trat;
    }

    public LocalDate getDat_ini() {
        return dat_ini;
    }

    public void setDat_ini(LocalDate dat_ini) {
        this.dat_ini = dat_ini;
    }

    public LocalDate getDat_fim() {
        return dat_fim;
    }

    public void setDat_fim(LocalDate dat_fim) {
        this.dat_fim = dat_fim;
    } 

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }
    
}
