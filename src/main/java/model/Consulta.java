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
public class Consulta {
    
    private int id_cons;
    private int id_exam;
    private LocalDate dat_con;

    public Consulta(int id_cons, int id_exam, LocalDate dat_con) {
        this.id_cons = id_cons;
        this.id_exam = id_exam;
        this.dat_con = dat_con;
    }

    public int getId_cons() {
        return id_cons;
    }

    public int getId_exam() {
        return id_exam;
    }

    public LocalDate getDat_con() {
        return dat_con;
    }

    public void setDat_con(LocalDate dat_con) {
        this.dat_con = dat_con;
    }
    
    
}
