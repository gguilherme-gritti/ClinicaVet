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
    private int id_cons;
    private LocalDate dat_ini;
    private LocalDate dat_fim;

    public Tratamento(int id_trat, int id_cons, LocalDate dat_ini, LocalDate dat_fim) {
        this.id_trat = id_trat;
        this.id_cons = id_cons;
        this.dat_ini = dat_ini;
        this.dat_fim = dat_fim;
    }

    public int getId_trat() {
        return id_trat;
    }

    public int getId_cons() {
        return id_cons;
    }

    public void setId_cons(int id_cons) {
        this.id_cons = id_cons;
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
    
}
