/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Exame;
import model.ExameDAO;

/**
 *
 * @author Gritti
 */
public class ExameTableModel extends GenericTableModel {

    public ExameTableModel(List vDados) {
        super(vDados, new String[]{"Descrição", "Resultado"});
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
        Exame exame = (Exame) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return exame.getDes_exame();
            case 1:
                return exame.getRes_exame();

            default:
                return "";
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Exame exame = (Exame) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                exame.setDes_exame((String) aValue);
                break;
            case 1:
                exame.setRes_exame((String) aValue);
                break;
            default:
                break;
        }

        ExameDAO.getInstance().update(exame);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
