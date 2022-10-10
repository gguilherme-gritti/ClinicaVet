/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.util.List;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author Gritti
 */
public class ClientTableModel extends GenericTableModel{
    
    public ClientTableModel(List vDados){
        super(vDados, new String[]{"Nome", "Email"});
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
        Cliente cliente = (Cliente) vDados.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return cliente.getNom_cli();
            case 1:
                return cliente.getEmail_cli();
            default:
                return "";
        }
        
    }
    
    @Override 
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Cliente cliente = (Cliente) vDados.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                 cliente.setNom_cli((String) aValue);
                 break;
            case 1:
                 cliente.setEmail_cli((String) aValue);
                 break;
            default:
                break;
        }
        
        //Gambs por enquanto
        cliente.setId_end(1);
   
        ClienteDAO.getInstance().update(cliente);

    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
    
}
