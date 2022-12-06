/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Consulta;
import java.time.LocalDate;
import model.ConsultaDAO;

/**
 *
 * @author Gritti
 */
public class ConsultaTableModel extends GenericTableModel{
    
    public ConsultaTableModel(List vDados){
        super(vDados, new String[]{"Data", "Sintomas"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                return String.class;
        }
    }
    
        @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return consulta.getDat_con();
            case 1:
                return consulta.getSintomas();

            default:
                return "";
        }

    }
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                consulta.setDat_con((String) aValue);
                break;
            case 1:
                consulta.setSintomas((String) aValue);
                break;
            default:
                break;
        }

        ConsultaDAO.getInstance().update(consulta);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
}
