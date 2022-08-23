/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author g247468
 */
public class Exame {
    
    private int id_exam;
    private String des_exame;

    public Exame(int id_exam, String des_exame) {
        this.id_exam = id_exam;
        this.des_exame = des_exame;
    }

    public int getId_exam() {
        return id_exam;
    }

    public String getDes_exame() {
        return des_exame;
    }

    public void setDes_exame(String des_exame) {
        this.des_exame = des_exame;
    }
    
}
