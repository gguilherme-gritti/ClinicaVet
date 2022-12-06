/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Animal;
import model.AnimalDAO;
import model.Especie;
import model.EspecieDAO;

/**
 *
 * @author Gritti
 */
public class AnimalTableModel extends GenericTableModel {

    public AnimalTableModel(List vDados) {
        super(vDados, new String[]{"Nome", "Idade", "Sexo", "Espécie"});
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
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return animal.getNome_animal();
            case 1:
                return String.valueOf(animal.getIdade_animal());
            case 2:
                if (animal.getSexo_animal() == 0) {
                    return "Feminino";
                } else {
                    return "Masculino";
                }
            case 3:
                Especie especies = EspecieDAO.getInstance().retrieveById(animal.getEsp_id());
                if (especies != null) {
                    return especies.getNome_esp();
                } else {
                    return "";
                }
            default:
                return "";
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                animal.setNome_animal((String) aValue);
                break;
            case 1:
                animal.setIdade_animal((int) aValue);
                break;
            case 2:
                if (aValue == "Feminino") {
                    animal.setSexo_animal(0);
                } else {
                    animal.setSexo_animal(1);
                }
                break;
            case 3:
                Especie especies = EspecieDAO.getInstance().retrieveByName((String) aValue);
                if(especies == null){
                    especies = EspecieDAO.getInstance().create((String) aValue);
                }
                
                animal.setEsp_id(especies.getId_esp());
                break;
            default:
                break;
        }

        AnimalDAO.getInstance().update(animal);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
