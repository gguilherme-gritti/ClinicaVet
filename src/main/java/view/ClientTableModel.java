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
public class ClientTableModel extends GenericTableModel {

    public ClientTableModel(List vDados) {
        super(vDados, new String[]{"Nome", "Email", "Cidade", "Estado", "Rua", "Bairro", "CEP"});
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
            case 5:
                return String.class;
            case 6:
                return String.class;
            case 7:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = (Cliente) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return cliente.getNom_cli();
            case 1:
                return cliente.getEmail_cli();
            case 2:
                return cliente.getCidade_cli();
            case 3:
                return cliente.getEstado_cli();
            case 4:
                return cliente.getRua_cli();
            case 5:
                return cliente.getBairro_cli();
            case 6:
                return cliente.getCep_cli();

            default:
                return "";
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cliente cliente = (Cliente) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                cliente.setNom_cli((String) aValue);
                break;
            case 1:
                cliente.setEmail_cli((String) aValue);
                break;
            case 2:
                cliente.setCidade_cli((String) aValue);
                break;
            case 3:
                cliente.setEstado_cli((String) aValue);
                break;
            case 4:
                cliente.setRua_cli((String) aValue);
                break;
            case 5:
                cliente.setBairro_cli((String) aValue);
                break;
            case 6:
                cliente.setCep_cli((String) aValue);
                break;
            default:
                break;
        }

        ClienteDAO.getInstance().update(cliente);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
