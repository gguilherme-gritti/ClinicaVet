/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Veterinario;
import model.VeterinarioDAO;

/**
 *
 * @author Gritti
 */
public class VeterinarioTableModel extends GenericTableModel{
    
    public VeterinarioTableModel(List vDados){
        super(vDados, new String[]{"Nome", "Telefone"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                return String.class;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Veterinario veterinario = (Veterinario) vDados.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return veterinario.getNom_vet();
            case 1:
                return veterinario.getTel_vet();
            default:
                return "";
        }
        
    }
    
    @Override 
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Veterinario veterinario = (Veterinario) vDados.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                 veterinario.setNom_vet((String) aValue);
                 break;
            case 1:
                 veterinario.setTel_vet((String) aValue);
                 break;
            default:
                break;
        }
        
        //veterinarioDAO.getInstance().update(veterinario);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
}
