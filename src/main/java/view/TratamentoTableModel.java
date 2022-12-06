/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.util.List;
import model.Tratamento;
import model.Animal;
import model.AnimalDAO;

/**
 *
 * @author Gritti
 */
public class TratamentoTableModel extends GenericTableModel{
    
    public TratamentoTableModel(List vDados) {
        super(vDados, new String[]{"Animal", "Data Inicio", "Data Fim", "Finalizado"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            default:
                return String.class;
        }
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tratamento tratamento = (Tratamento) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                Animal animais = AnimalDAO.getInstance().retrieveById(tratamento.getId_animal());
                
                if(animais != null){
                    return animais.getNome_animal();
                }else{
                    return "";
                } 
            case 1:
                return tratamento.getDat_ini();
            case 2:
                return tratamento.getDat_fim();
            case 3:
                if(tratamento.getFinalizado() == 1){
                    return "SIM";
                }else{
                    return "NÃO";
                }
            default:
                return "";
        }

    }
    
        @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
