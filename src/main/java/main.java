
import model.Animal;
import model.ClienteDAO;
import model.Cliente;
import model.Endereco;
import model.Especie;
import java.util.List;
import model.AnimalDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author g247468
 */
public class main {

    public static void main(String[] args) {
        //ClienteDAO.getInstance().create(1, "Guilherme Gritti", "goulart.gritti@outlook.com");
        Cliente c1 = ClienteDAO.getInstance().retrieveById(1);
        
        System.out.println(c1.getNom_cli());
    }
}
