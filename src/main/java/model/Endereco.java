/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author g247468
 */
public class Endereco {
    
    private int id_end;
    private String rua_end;
    private String bairro_end;
    private String cidade_end;
    private String cep_end;

    public Endereco(int id_end, String rua_end, String bairro_end, String cidade_end, String cep_end) {
        this.id_end = id_end;
        this.rua_end = rua_end;
        this.bairro_end = bairro_end;
        this.cidade_end = cidade_end;
        this.cep_end = cep_end;
    }

    public int getId_end() {
        return id_end;
    }

    public String getRua_end() {
        return rua_end;
    }

    public void setRua_end(String rua_end) {
        this.rua_end = rua_end;
    }

    public String getBairro_end() {
        return bairro_end;
    }

    public void setBairro_end(String bairro_end) {
        this.bairro_end = bairro_end;
    }

    public String getCidade_end() {
        return cidade_end;
    }

    public void setCidade_end(String cidade_end) {
        this.cidade_end = cidade_end;
    }

    public String getCep_end() {
        return cep_end;
    }

    public void setCep_end(String cep_end) {
        this.cep_end = cep_end;
    }
    
}
